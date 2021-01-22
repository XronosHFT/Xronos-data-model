package com.xronos.dto;


import com.xronos.constants.DirectionEnum;
import com.xronos.constants.ExchangeEnum;
import com.xronos.dto.request.OrderRequest;
import net.openhft.chronicle.bytes.BytesIn;
import net.openhft.chronicle.bytes.BytesOut;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;

public class Position extends AbstractEvent<OrderRequest> {
  private static final int MASHALLABLE_VERSION = 1;

  private DirectionEnum direction = DirectionEnum.NONE;

  private float volume;
  private float frozen;
  private float price;
  private float pnl;
  private float xsVolume;

  public String symbol() {
    return symbol;
  }

  public Position symbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  public ExchangeEnum exchange() {
    return exchange;
  }

  public Position exchange(ExchangeEnum exchange) {
    this.exchange = exchange;
    return this;
  }

  public DirectionEnum direction() {
    return direction;
  }

  public Position direction(DirectionEnum direction) {
    this.direction = direction;
    return this;
  }

  public float volume() {
    return volume;
  }

  public Position volume(float volume) {
    this.volume = volume;
    return this;
  }

  public float frozen() {
    return frozen;
  }

  public Position frozen(float frozen) {
    this.frozen = frozen;
    return this;
  }

  public float price() {
    return price;
  }

  public Position price(float price) {
    this.price = price;
    return this;
  }

  public float pnl() {
    return pnl;
  }

  public Position pnl(float pnl) {
    this.pnl = pnl;
    return this;
  }

  public float xsVolume() {
    return xsVolume;
  }

  public Position xsVolume(float xsVolume) {
    this.xsVolume = xsVolume;
    return this;
  }

  @Override
  public void writeMarshallable(BytesOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.writeObject(String.class, symbol);
      out.writeObject(ExchangeEnum.class, exchange);
      out.writeObject(DirectionEnum.class, direction);
      out.writeFloat(volume);
      out.writeFloat(frozen);
      out.writeFloat(price);
      out.writeFloat(pnl);
      out.writeFloat(xsVolume);
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
        direction = (DirectionEnum) in.readObject(DirectionEnum.class);
        volume = in.readFloat();
        frozen = in.readFloat();
        price = in.readFloat();
        pnl = in.readFloat();
        xsVolume = in.readFloat();
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
      out.write("direction").object(DirectionEnum.class, direction);
      out.write("volume").writeFloat(volume);
      out.write("frozen").writeFloat(frozen);
      out.write("price").writeFloat(price);
      out.write("pnl").writeFloat(pnl);
      out.write("xsVolume").writeFloat(xsVolume);
    }
  }

  @Override
  public void readMarshallable(WireIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      symbol = in.read("symbol").object(symbol, String.class);
      exchange = in.read("exchange").object(exchange, ExchangeEnum.class);
      direction = in.read("direction").object(direction, DirectionEnum.class);
      volume = in.read("volume").readFloat();
      frozen = in.read("frozen").readFloat();
      price = in.read("price").readFloat();
      pnl = in.read("pnl").readFloat();
      xsVolume = in.read("xsVolume").readFloat();
    }
  }
}
