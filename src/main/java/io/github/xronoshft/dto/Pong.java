package io.github.xronoshft.dto;

import io.github.xronoshft.constants.ExchangeEnum;
import io.github.xronoshft.constants.StrategyStatusEnum;
import net.openhft.chronicle.bytes.BytesIn;
import net.openhft.chronicle.bytes.BytesOut;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;

public class Pong extends AbstractEvent<Pong> {

  private static final int MASHALLABLE_VERSION = 1;

  private String strategyName;

  private StrategyStatusEnum strategyStatus;

  /**
   * 事件发生时间
   */
  private long sendingTime;

  public String strategyName() {
    return strategyName;
  }

  public Pong strategyName(String strategyName) {
    this.strategyName = strategyName;
    return this;
  }

  public StrategyStatusEnum strategyStatus() {
    return strategyStatus;
  }

  public Pong strategyStatus(StrategyStatusEnum strategyStatus) {
    this.strategyStatus = strategyStatus;
    return this;
  }

  public Pong exchange(ExchangeEnum exchange) {
    this.exchange = exchange;
    return this;
  }


  public String symbol() {
    return symbol;
  }

  public Pong symbol(String symbol) {
    this.symbol = symbol;
    return this;
  }


  @Override
  public void writeMarshallable(BytesOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.writeObject(String.class, strategyName);
      out.writeObject(String.class, symbol);
      out.writeObject(StrategyStatusEnum.class, strategyStatus);
      out.writeObject(ExchangeEnum.class, exchange);
    }
  }

  @Override
  public void readMarshallable(BytesIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      int version = (int) in.readStopBit();
      if (version == MASHALLABLE_VERSION) {
        strategyName = (String) in.readObject(String.class);
        symbol = (String) in.readObject(String.class);
        strategyStatus = (StrategyStatusEnum) in.readObject(StrategyStatusEnum.class);
        exchange = (ExchangeEnum) in.readObject(ExchangeEnum.class);
      } else {
        throw new IllegalStateException("Unknown version " + version);
      }
    }
  }

  @Override
  public void writeMarshallable(WireOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.write("strategyName").object(String.class, strategyName);
      out.write("symbol").object(String.class, symbol);
      out.write("strategyStatus").object(StrategyStatusEnum.class, strategyStatus);
      out.write("exchange").object(ExchangeEnum.class, exchange);
    }
  }

  @Override
  public void readMarshallable(WireIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      symbol = in.read("symbol").object(symbol, String.class);
      strategyName = in.read("strategyName").object(strategyName, String.class);
      strategyStatus = in.read("strategyStatus").object(strategyStatus, StrategyStatusEnum.class);
      exchange = in.read("exchange").object(exchange, ExchangeEnum.class);
    }
  }
}
