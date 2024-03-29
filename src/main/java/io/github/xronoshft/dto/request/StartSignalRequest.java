package io.github.xronoshft.dto.request;

import io.github.xronoshft.constants.ExchangeEnum;
import io.github.xronoshft.dto.AbstractEvent;
import net.openhft.chronicle.bytes.BytesIn;
import net.openhft.chronicle.bytes.BytesOut;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;

public class StartSignalRequest extends AbstractEvent<StartSignalRequest> {
  private static final int MASHALLABLE_VERSION = 1;

  private String name;

  private Object config;

  public String name() {
    return name;
  }

  public StartSignalRequest name(String name) {
    this.name = name;
    return this;
  }

  public Object config() {
    return config;
  }

  public StartSignalRequest config(Object config) {
    this.config = config;
    return this;
  }

  @Override
  public void writeMarshallable(BytesOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.writeObject(String.class, symbol);
      out.writeObject(ExchangeEnum.class, exchange);
      out.writeObject(String.class, name);
      out.writeObject(Object.class, config);
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
        name = (String) in.readObject(String.class);
        config = in.readObject(Object.class);
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
      out.write("name").object(String.class, name);
      out.write("config").object(Object.class, config);
    }
  }

  @Override
  public void readMarshallable(WireIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      symbol = in.read("symbol").object(symbol, String.class);
      exchange = in.read("exchange").object(exchange, ExchangeEnum.class);
      name = in.read("name").object(name, String.class);
      config = in.read("config").object(config, Object.class);
    }
  }
}
