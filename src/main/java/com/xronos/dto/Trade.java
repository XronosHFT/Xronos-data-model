package com.xronos.dto;

import com.xronos.constants.DirectionEnum;
import com.xronos.constants.ExchangeEnum;
import com.xronos.constants.OffsetEnum;
import com.xronos.constants.XronosConstant;
import net.openhft.chronicle.bytes.BytesIn;
import net.openhft.chronicle.bytes.BytesOut;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;

public class Trade extends AbstractEvent<Trade> {
  private static final int MASHALLABLE_VERSION = 1;

  private long orderId;
  private long tradeId;
  private DirectionEnum direction = DirectionEnum.NONE;
  private OffsetEnum offset;

  private String feeAsset;
  private String role;

  private double profit;
  private double price;
  private double volume;
  private double fee;

  private long time;

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

  public long orderId() {
    return orderId;
  }

  public Trade orderId(long orderId) {
    this.orderId = orderId;
    return this;
  }

  public long tradeId() {
    return tradeId;
  }

  public Trade tradeId(long tradeId) {
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

  public double price() {
    return price;
  }

  public Trade price(double price) {
    this.price = price;
    return this;
  }

  public double volume() {
    return volume;
  }

  public Trade volume(double volume) {
    this.volume = volume;
    return this;
  }

  public double fee() {
    return fee;
  }

  public Trade fee(double fee) {
    this.fee = fee;
    return this;
  }

  public long time() {
    return time;
  }

  public Trade time(long time) {
    this.time = time;
    return this;
  }

  public String xsOrderId() {
    return gatewayName + XronosConstant.DOT_SEPARATOR + orderId;
  }

  public String xsTradeId() {
    return exchange.name() + XronosConstant.DOT_SEPARATOR + tradeId;
  }

  public double profit() {
    return profit;
  }

  public Trade profit(double profit) {
    this.profit = profit;
    return this;
  }

  public String feeAsset() {
    return feeAsset;
  }

  public Trade feeAsset(String feeAsset) {
    this.feeAsset = feeAsset;
    return this;
  }

  public String role() {
    return role;
  }

  public Trade role(String role) {
    this.role = role;
    return this;
  }

  @Override
  public void writeMarshallable(BytesOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.writeObject(String.class, symbol);
      out.writeObject(String.class, feeAsset);
      out.writeObject(String.class, role);
      out.writeObject(DirectionEnum.class, direction);
      out.writeObject(OffsetEnum.class, offset);

      out.writeLong(orderId);
      out.writeLong(tradeId);
      out.writeLong(time);

      out.writeDouble(price);
      out.writeDouble(volume);
      out.writeDouble(fee);
      out.writeDouble(profit);
    }
  }

  @Override
  public void readMarshallable(BytesIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      int version = (int) in.readStopBit();
      if (version == MASHALLABLE_VERSION) {
        symbol = (String) in.readObject(String.class);
        feeAsset = (String) in.readObject(String.class);
        role = (String) in.readObject(String.class);
        direction = (DirectionEnum) in.readObject(DirectionEnum.class);
        offset = (OffsetEnum) in.readObject(OffsetEnum.class);

        time = in.readLong();
        orderId = in.readLong();
        tradeId = in.readLong();

        price = in.readDouble();
        volume = in.readDouble();
        fee = in.readDouble();
        profit = in.readDouble();
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
      out.write("feeAsset").object(String.class, feeAsset);
      out.write("role").object(String.class, role);

      out.write("direction").object(DirectionEnum.class, direction);
      out.write("offset").object(OffsetEnum.class, offset);

      out.write("time").writeLong(time);
      out.write("orderId").writeLong(orderId);
      out.write("tradeId").writeLong(tradeId);

      out.write("price").writeDouble(price);
      out.write("volume").writeDouble(volume);
      out.write("fee").writeDouble(fee);
      out.write("profit").writeDouble(profit);
    }
  }

  @Override
  public void readMarshallable(WireIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      symbol = in.read("symbol").object(symbol, String.class);
      feeAsset = in.read("symbol").object(feeAsset, String.class);
      role = in.read("symbol").object(role, String.class);
      direction = in.read("direction").object(direction, DirectionEnum.class);
      offset = in.read("offset").object(offset, OffsetEnum.class);

      price = in.read("price").readDouble();
      volume = in.read("volume").readDouble();
      fee = in.read("fee").readDouble();
      profit = in.read("profit").readDouble();

      time = in.read("time").readLong();
      orderId = in.read("orderId").readLong();
      tradeId = in.read("tradeId").readLong();
    }
  }
}
