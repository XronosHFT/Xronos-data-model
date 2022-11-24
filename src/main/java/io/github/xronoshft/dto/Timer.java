package io.github.xronoshft.dto;

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

  private String topic;

  private Object data;

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

  public String topic() {
    return topic;
  }

  public Timer topic(String topic) {
    this.topic = topic;
    return this;
  }

  public long time() {
    return time;
  }

  public Timer time(long time, TimeUnit unit) {
    this.time = System.nanoTime() + ((time > 0) ? unit.toNanos(time) : 0);
    return this;
  }

  public Object data() {
    return data;
  }

  public Timer data(Object msg) {
    this.data = msg;
    return this;
  }

  @Override
  public void writeMarshallable(BytesOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.writeObject(String.class, name);
      out.writeObject(String.class, topic);
      out.writeLong(time);
      out.writeObject(Object.class, data);
    }
  }

  @Override
  public void readMarshallable(BytesIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      int version = (int) in.readStopBit();
      if (version == MASHALLABLE_VERSION) {
        name = (String) in.readObject(String.class);
        topic = (String) in.readObject(String.class);
        time = in.readLong();
        data = in.readObject(Object.class);
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
      out.write("topic").object(String.class, topic);
      out.write("time").writeLong(time);
      out.write("data").object(Object.class, data);
    }
  }

  @Override
  public void readMarshallable(WireIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      name = in.read("name").object(name, String.class);
      name = in.read("topic").object(topic, String.class);
      time = in.read("time").readLong();
      data = in.read("data").object(data, Object.class);
    }
  }
}
