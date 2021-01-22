package com.xronos.dto;

import com.xronos.constants.DirectionEnum;
import com.xronos.constants.ExchangeEnum;
import com.xronos.constants.OffsetEnum;
import net.openhft.chronicle.bytes.BytesIn;
import net.openhft.chronicle.bytes.BytesOut;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;
import org.apache.commons.lang3.StringUtils;

public class Trade extends AbstractEvent<Trade> {
  private static final int MASHALLABLE_VERSION = 1;

  private String orderId = StringUtils.EMPTY;
  private String tradeId = StringUtils.EMPTY;
  private DirectionEnum direction = DirectionEnum.NONE;

  private OffsetEnum offset;
  private float price;
  private float volume;
  private float fee;
  private Long time;

  public String symbol() {
    return symbol;
  }

  public Trade symbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  public ExchangeEnum exchange() {
    return exchange;
  }

  public Trade exchange(ExchangeEnum exchange) {
    this.exchange = exchange;
    return this;
  }

  public String orderId() {
    return orderId;
  }

  public Trade orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

  public String tradeId() {
    return tradeId;
  }

  public Trade tradeId(String tradeId) {
    this.tradeId = tradeId;
    return this;
  }

  public DirectionEnum direction() {
    return direction;
  }

  public Trade direction(DirectionEnum direction) {
    this.direction = direction;
    return this;
  }

  public OffsetEnum offset() {
    return offset;
  }

  public Trade offset(OffsetEnum offset) {
    this.offset = offset;
    return this;
  }

  public float price() {
    return price;
  }

  public Trade price(float price) {
    this.price = price;
    return this;
  }

  public float volume() {
    return volume;
  }

  public Trade volume(float volume) {
    this.volume = volume;
    return this;
  }

  public float fee() {
    return fee;
  }

  public Trade fee(float fee) {
    this.fee = fee;
    return this;
  }

  public Long time() {
    return time;
  }

  public Trade time(Long time) {
    this.time = time;
    return this;
  }

  public String xsOrderId() {
    return gatewayName + "." + orderId;
  }

  public String xsTradeId() {
    return gatewayName + "." + tradeId;
  }


  @Override
  public void writeMarshallable(BytesOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.writeObject(String.class, symbol);
      out.writeObject(String.class, orderId);
      out.writeObject(String.class, tradeId);
      out.writeObject(DirectionEnum.class, direction);
      out.writeObject(OffsetEnum.class, offset);
      out.writeFloat(price);
      out.writeFloat(volume);
      out.writeFloat(fee);
      out.writeLong(time);
    }
  }

  @Override
  public void readMarshallable(BytesIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      int version = (int) in.readStopBit();
      if (version == MASHALLABLE_VERSION) {
        symbol = (String) in.readObject(String.class);
        orderId = (String) in.readObject(String.class);
        tradeId = (String) in.readObject(String.class);
        direction = (DirectionEnum) in.readObject(DirectionEnum.class);
        offset = (OffsetEnum) in.readObject(OffsetEnum.class);
        price = in.readFloat();
        volume = in.readFloat();
        fee = in.readFloat();
        time = in.readLong();
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
      out.write("orderId").object(String.class, orderId);
      out.write("tradeId").object(String.class, tradeId);
      out.write("direction").object(DirectionEnum.class, direction);
      out.write("offset").object(OffsetEnum.class, offset);
      out.write("price").writeFloat(price);
      out.write("volume").writeFloat(volume);
      out.write("fee").writeFloat(fee);
      out.write("time").writeLong(time);
    }
  }

  @Override
  public void readMarshallable(WireIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      symbol = in.read("symbol").object(symbol, String.class);
      orderId = in.read("orderId").object(orderId, String.class);
      tradeId = in.read("tradeId").object(tradeId, String.class);
      direction = in.read("direction").object(direction, DirectionEnum.class);
      offset = in.read("offset").object(offset, OffsetEnum.class);
      price = in.read("price").readFloat();
      volume = in.read("volume").readFloat();
      fee = in.read("fee").readFloat();
      time = in.read("time").readLong();
    }
  }
}
