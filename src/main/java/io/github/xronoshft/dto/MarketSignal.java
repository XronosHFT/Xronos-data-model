package io.github.xronoshft.dto;

import io.github.xronoshft.constants.ExchangeEnum;
import net.openhft.chronicle.bytes.BytesIn;
import net.openhft.chronicle.bytes.BytesOut;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;

public class MarketSignal extends AbstractEvent<MarketSignal> {
  private static final int MASHALLABLE_VERSION = 1;

  private String type;

  private String subType;

  private String detail;

  private double amount;

  public String symbol() {
    return symbol;
  }

  public MarketSignal symbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  public ExchangeEnum exchange() {
    return exchange;
  }

  public MarketSignal exchange(ExchangeEnum exchange) {
    this.exchange = exchange;
    return this;
  }

  public String type() {
    return type;
  }

  public MarketSignal type(String type) {
    this.type = type;
    return this;
  }

  public String subType() {
    return subType;
  }

  public MarketSignal subType(String subType) {
    this.subType = subType;
    return this;
  }

  public String detail() {
    return detail;
  }

  public MarketSignal detail(String detail) {
    this.detail = detail;
    return this;
  }

  public double amount() {
    return amount;
  }

  public MarketSignal amount(double amount) {
    this.amount = amount;
    return this;
  }


  @Override
  public void writeMarshallable(BytesOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.writeObject(String.class, symbol);
      out.writeObject(ExchangeEnum.class, exchange);
      out.writeObject(String.class, type);
      out.writeObject(String.class, subType);
      out.writeObject(String.class, detail);
      out.writeDouble(amount);
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
        type = (String) in.readObject(String.class);
        subType = (String) in.readObject(String.class);
        detail = (String) in.readObject(String.class);
        amount = in.readDouble();
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
      out.write("type").object(String.class, type);
      out.write("subType").object(String.class, subType);
      out.write("detail").object(String.class, detail);
      out.write("amount").writeDouble(amount);
    }
  }

  @Override
  public void readMarshallable(WireIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      symbol = in.read("symbol").object(symbol, String.class);
      exchange = in.read("exchange").object(exchange, ExchangeEnum.class);
      detail = in.read("detail").object(detail, String.class);
      subType = in.read("subType").object(subType, String.class);
      type = in.read("type").object(type, String.class);
      amount = in.read("amount").readDouble();
    }
  }
}
