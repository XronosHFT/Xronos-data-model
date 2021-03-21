package com.xronos.dto.request;

import com.xronos.constants.ExchangeEnum;
import com.xronos.dto.AbstractEvent;
import net.openhft.chronicle.bytes.BytesIn;
import net.openhft.chronicle.bytes.BytesOut;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;

public class CancelOrderRequest extends AbstractEvent<CancelOrderRequest> {

  private static final int MASHALLABLE_VERSION = 1;

  private long orderId;

  private String xsOrderId;

  public CancelOrderRequest orderId(long orderId) {
    this.orderId = orderId;
    return this;
  }

  public String xsOrderId() {
    return xsOrderId;
  }

  public CancelOrderRequest xsOrderId(String xsOrderId) {
    this.xsOrderId = xsOrderId;
    return this;
  }

  public long orderId() {
    return orderId;
  }

  public String symbol() {
    return symbol;
  }

  public CancelOrderRequest symbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  public ExchangeEnum exchange() {
    return exchange;
  }

  public CancelOrderRequest exchange(ExchangeEnum exchange) {
    this.exchange = exchange;
    return this;
  }

  @Override
  public void writeMarshallable(BytesOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.writeObject(String.class, symbol);
      out.writeObject(ExchangeEnum.class, exchange);
      out.writeLong(orderId);
    }
  }

  @Override
  public void readMarshallable(BytesIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      int version = (int) in.readStopBit();
      if (version == MASHALLABLE_VERSION) {
        symbol = (String) in.readObject(String.class);
        exchange = (ExchangeEnum) in.readObject(ExchangeEnum.class);
        orderId = in.readLong();
      } else {
        throw new IllegalStateException("Unknown version " + version);
      }
    }
  }

  @Override
  public void writeMarshallable(WireOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.write("symbol").object(String.class, symbol);
      out.write("exchange").object(ExchangeEnum.class, exchange);
      out.write("orderId").writeLong(orderId);
    }
  }

  @Override
  public void readMarshallable(WireIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      symbol = in.read("symbol").object(symbol, String.class);
      exchange = in.read("exchange").object(exchange, ExchangeEnum.class);
      orderId = in.read("orderId").readLong();
    }
  }
}
