package io.github.xronoshft.dto.status;

import io.github.xronoshft.constants.ExchangeEnum;
import io.github.xronoshft.constants.WebsocketStatusEnum;
import io.github.xronoshft.dto.AbstractEvent;
import net.openhft.chronicle.bytes.BytesIn;
import net.openhft.chronicle.bytes.BytesOut;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;
import org.apache.commons.lang3.StringUtils;

public class WebSocketStatus extends AbstractEvent<WebSocketStatus> {
  private static final int MASHALLABLE_VERSION = 1;

  private String name = StringUtils.EMPTY;

  private WebsocketStatusEnum status;

  public String symbol() {
    return symbol;
  }

  public WebSocketStatus symbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  public ExchangeEnum exchange() {
    return exchange;
  }

  public WebSocketStatus exchange(ExchangeEnum exchange) {
    this.exchange = exchange;
    return this;
  }

  public String name() {
    return name;
  }

  public WebSocketStatus name(String name) {
    this.name = name;
    return this;
  }

  public WebsocketStatusEnum status() {
    return status;
  }

  public WebSocketStatus status(WebsocketStatusEnum status) {
    this.status = status;
    return this;
  }

  @Override
  public void writeMarshallable(BytesOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.writeObject(String.class, symbol);
      out.writeObject(ExchangeEnum.class, exchange);
      out.writeObject(WebsocketStatusEnum.class, status);
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
        status = (WebsocketStatusEnum) in.readObject(WebsocketStatusEnum.class);
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
      out.write("status").object(WebsocketStatusEnum.class, status);
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
      status = in.read("status").object(status, WebsocketStatusEnum.class);
    }
  }
}
