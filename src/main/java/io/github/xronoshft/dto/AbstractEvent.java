package io.github.xronoshft.dto;

import io.github.xronoshft.constants.ExchangeEnum;
import io.github.xronoshft.constants.XronosConstant;
import net.openhft.chronicle.bytes.BytesIn;
import net.openhft.chronicle.bytes.BytesOut;
import net.openhft.chronicle.wire.SelfDescribingMarshallable;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;

import java.io.Serializable;

public class AbstractEvent<E extends AbstractEvent<E>> extends SelfDescribingMarshallable implements Serializable {
  // used to control the benchmark
  public static final boolean BYTES_IN_BINARY = Boolean.getBoolean("byteInBinary");

  // used to control the benchmark
  public static final boolean PREGENERATED_MARSHALLABLE = Boolean.getBoolean("pregeneratedMarshallable");
  private static final int MASHALLABLE_VERSION = 1;
  private long sender;
  private long target;
  // client sending time
  private long sendingTime;

  String gatewayName;

  protected String symbol;

  protected ExchangeEnum exchange;

  @Override
  public boolean usesSelfDescribingMessage() {
    return !BYTES_IN_BINARY;
  }

  public long sender() {
    return sender;
  }

  public E sender(long sender) {
    this.sender = sender;
    return (E) this;
  }

  public long target() {
    return target;
  }

  public E target(long target) {
    this.target = target;
    return (E) this;
  }

  public long sendingTime() {
    return sendingTime;
  }

  public E sendingTime(long sendingTime) {
    this.sendingTime = sendingTime;
    return (E) this;
  }

  @Override
  public void writeMarshallable(BytesOut out) {
    if (PREGENERATED_MARSHALLABLE) {
      out.writeStopBit(MASHALLABLE_VERSION);
      out.writeLong(sender);
      out.writeLong(target);
      out.writeLong(sendingTime);
    } else {
      super.writeMarshallable(out);
    }
  }

  @Override
  public void readMarshallable(BytesIn in) {
    if (PREGENERATED_MARSHALLABLE) {
      int version = (int) in.readStopBit();
      if (version == MASHALLABLE_VERSION) {
        sender = in.readLong();
        target = in.readLong();
        sendingTime = in.readLong();
      } else {
        throw new IllegalStateException("Unknown version " + version);
      }
    } else {
      super.readMarshallable(in);
    }
  }

  @Override
  public void writeMarshallable(WireOut out) {
    if (PREGENERATED_MARSHALLABLE) {
      out.write("sender").writeLong(sender);
      out.write("target").writeLong(target);
      out.write("sendingTime").writeLong(sendingTime);
    } else {
      super.writeMarshallable(out);
    }
  }

  @Override
  public void readMarshallable(WireIn in) {
    if (PREGENERATED_MARSHALLABLE) {
      sender = in.read("sender").readLong();
      target = in.read("target").readLong();
      sendingTime = in.read("sendingTime").readLong();
    } else {
      super.readMarshallable(in);
    }
  }

  public String gatewayName() {
    return gatewayName;
  }

  public E gatewayName(String gatewayName) {
    this.gatewayName = gatewayName;
    return (E) this;
  }

  public String xsSymbol() {
    return (symbol + XronosConstant.DOT_SEPARATOR + exchange.name()).toLowerCase();
  }

  public ExchangeEnum exchange() {
    return exchange;
  }

  public AbstractEvent<E> exchange(ExchangeEnum exchange) {
    this.exchange = exchange;
    return this;
  }

  public void copy(E e) {
  }
}
