package com.xronos.dto.status;

import com.xronos.constants.ExchangeEnum;
import com.xronos.constants.StrategyStatusEnum;
import com.xronos.dto.AbstractEvent;
import net.openhft.chronicle.bytes.BytesIn;
import net.openhft.chronicle.bytes.BytesOut;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;
import org.apache.commons.lang3.StringUtils;

public class StrategyTemplate extends AbstractEvent<StrategyTemplate> {
  private static final int MASHALLABLE_VERSION = 1;

  private String name = StringUtils.EMPTY;

  /**
   * 策略类型
   */
  private String template = StringUtils.EMPTY;

  /**
   * 策略状态
   */
  private StrategyStatusEnum status;

  private String config;

  public String symbol() {
    return symbol;
  }

  public StrategyTemplate symbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  public ExchangeEnum exchange() {
    return exchange;
  }

  public StrategyTemplate exchange(ExchangeEnum exchange) {
    this.exchange = exchange;
    return this;
  }

  public String name() {
    return name;
  }

  public StrategyTemplate name(String name) {
    this.name = name;
    return this;
  }

  public StrategyStatusEnum status() {
    return status;
  }

  public StrategyTemplate status(StrategyStatusEnum status) {
    this.status = status;
    return this;
  }

  public String template() {
    return template;
  }

  public StrategyTemplate template(String template) {
    this.template = template;
    return this;
  }

  public String config() {
    return config;
  }

  public StrategyTemplate config(String config) {
    this.config = config;
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
      out.writeObject(String.class, template);
      out.writeObject(String.class, config);
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
        template = (String) in.readObject(String.class);
        config = (String) in.readObject(String.class);
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
      out.write("template").object(String.class, template);
      out.write("config").object(String.class, config);
    }
  }

  @Override
  public void readMarshallable(WireIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      symbol = in.read("symbol").object(symbol, String.class);
      exchange = in.read("exchange").object(exchange, ExchangeEnum.class);
      status = in.read("status").object(status, StrategyStatusEnum.class);
      name = in.read("name").object(name, String.class);
      template = in.read("template").object(template, String.class);
      config = in.read("config").object(config, String.class);
    }
  }
}
