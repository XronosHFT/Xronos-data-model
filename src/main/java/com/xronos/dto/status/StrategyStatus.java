package com.xronos.dto.status;

import com.xronos.constants.ExchangeEnum;
import com.xronos.constants.StrategyStatusEnum;
import com.xronos.dto.AbstractEvent;
import net.openhft.chronicle.bytes.BytesIn;
import net.openhft.chronicle.bytes.BytesOut;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;
import org.apache.commons.lang3.StringUtils;

public class StrategyStatus extends AbstractEvent<StrategyStatus> {
  private static final int MASHALLABLE_VERSION = 1;

  private String name = StringUtils.EMPTY;

  private StrategyStatusEnum status;

  public String symbol() {
    return symbol;
  }

  public StrategyStatus symbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  public ExchangeEnum exchange() {
    return exchange;
  }

  public StrategyStatus exchange(ExchangeEnum exchange) {
    this.exchange = exchange;
    return this;
  }

  public String name() {
    return name;
  }

  public StrategyStatus name(String name) {
    this.name = name;
    return this;
  }

  public StrategyStatusEnum status() {
    return status;
  }

  public StrategyStatus status(StrategyStatusEnum status) {
    this.status = status;
    return this;
  }

  @Override
  public void writeMarshallable(BytesOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.writeObject(String.class, symbol);
      out.writeObject(ExchangeEnum.class, exchange);
      out.writeObject(StrategyStatusEnum.class, status);
      out.writeObject(String.class, name);
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
        status = (StrategyStatusEnum) in.readObject(StrategyStatusEnum.class);
        name = (String) in.readObject(String.class);
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
      out.write("status").object(StrategyStatusEnum.class, status);
      out.write("name").object(String.class, name);
    }
  }

  @Override
  public void readMarshallable(WireIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      symbol = in.read("symbol").object(symbol, String.class);
      exchange = in.read("exchange").object(exchange, ExchangeEnum.class);
      name = in.read("name").object(name, String.class);
      status = in.read("status").object(status, StrategyStatusEnum.class);
    }
  }
}
