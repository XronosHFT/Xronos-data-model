package com.xronos.dto;

import net.openhft.chronicle.bytes.BytesIn;
import net.openhft.chronicle.bytes.BytesOut;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Timer extends AbstractEvent<Timer> implements Delayed {

  private static final int MASHALLABLE_VERSION = 1;

  private String name;

  private long time;

  @Override
  public long getDelay(@NotNull TimeUnit timeUnit) {
    return time - System.nanoTime();
  }

  @Override
  public int compareTo(@NotNull Delayed delayed) {
    Timer item = (Timer) delayed;
    long diff = this.time - item.time;
    if (diff <= 0) {
      return -1;
    } else {
      return 1;
    }
  }

  public String name() {
    return name;
  }

  public Timer name(String name) {
    this.name = name;
    return this;
  }

  public long time() {
    return time;
  }

  public Timer time(long time, TimeUnit unit) {
    this.time = System.nanoTime() + ((time > 0) ? unit.toNanos(time) : 0);
    return this;
  }


  @Override
  public void writeMarshallable(BytesOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.writeObject(String.class, name);
      out.writeLong(time);
    }
  }

  @Override
  public void readMarshallable(BytesIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      int version = (int) in.readStopBit();
      if (version == MASHALLABLE_VERSION) {
        name = (String) in.readObject(String.class);
        time = in.readLong();
      } else {
        throw new IllegalStateException("Unknown version " + version);
      }
    }
  }

  @Override
  public void writeMarshallable(WireOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.write("name").object(String.class, name);
      out.write("time").writeLong(time);
    }
  }

  @Override
  public void readMarshallable(WireIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      name = in.read("name").object(name, String.class);
      time = in.read("time").readLong();
    }
  }
}