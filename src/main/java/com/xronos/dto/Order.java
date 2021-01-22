package com.xronos.dto;

import com.xronos.constants.DirectionEnum;
import com.xronos.constants.ExchangeEnum;
import com.xronos.constants.OffsetEnum;
import com.xronos.constants.OrderTypeEnum;
import com.xronos.constants.StatusEnum;
import net.openhft.chronicle.bytes.BytesIn;
import net.openhft.chronicle.bytes.BytesOut;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

public class Order extends AbstractEvent<Order> {
  private static final int MASHALLABLE_VERSION = 1;

  private String orderId = StringUtils.EMPTY;

  private OrderTypeEnum type = OrderTypeEnum.NONE;
  private DirectionEnum direction = DirectionEnum.NONE;
  private OffsetEnum offset = OffsetEnum.NONE;
  private StatusEnum status = StatusEnum.NONE;

  private float price;
  private float volume;
  private float traded;
  private float remainAmount;
  private Long time = 0L;


  public String symbol() {
    return symbol;
  }

  public Order symbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  public ExchangeEnum exchange() {
    return exchange;
  }

  public Order exchange(ExchangeEnum exchange) {
    this.exchange = exchange;
    return this;
  }

  public String orderId() {
    return orderId;
  }

  public Order orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

  public OrderTypeEnum type() {
    return type;
  }

  public Order type(OrderTypeEnum type) {
    this.type = type;
    return this;
  }

  public DirectionEnum direction() {
    return direction;
  }

  public Order direction(DirectionEnum direction) {
    this.direction = direction;
    return this;
  }

  public OffsetEnum offset() {
    return offset;
  }

  public Order offset(OffsetEnum offset) {
    this.offset = offset;
    return this;
  }

  public StatusEnum status() {
    return status;
  }

  public Order status(StatusEnum status) {
    this.status = status;
    return this;
  }

  public float price() {
    return price;
  }

  public Order price(float price) {
    this.price = price;
    return this;
  }

  public float volume() {
    return volume;
  }

  public Order volume(float volume) {
    this.volume = volume;
    return this;
  }

  public float traded() {
    return traded;
  }

  public Order traded(float traded) {
    this.traded = traded;
    return this;
  }

  public float remainAmount() {
    return remainAmount;
  }

  public Order remainAmount(float remainAmount) {
    this.remainAmount = remainAmount;
    return this;
  }

  public Long time() {
    return time;
  }

  public Order time(Long time) {
    this.time = time;
    return this;
  }


  public String xsOrderId() {
    return (exchange.name() + "." + orderId).toLowerCase();
  }

  public boolean active() {
    Set<StatusEnum> activeStatus = new HashSet<StatusEnum>() {
      {
        add(StatusEnum.SUBMITTING);
        add(StatusEnum.NOTTRADED);
        add(StatusEnum.PARTTRADED);
        add(StatusEnum.PARTCANCELED);
        add(StatusEnum.CANCELLING);
      }
    };
    return activeStatus.contains(status);
  }

  @Override
  public void writeMarshallable(BytesOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.writeObject(String.class, symbol);
      out.writeObject(String.class, orderId);
      out.writeObject(ExchangeEnum.class, exchange);
      out.writeObject(OrderTypeEnum.class, type);
      out.writeObject(DirectionEnum.class, direction);
      out.writeObject(OffsetEnum.class, offset);
      out.writeObject(StatusEnum.class, status);
      out.writeFloat(price);
      out.writeFloat(volume);
      out.writeFloat(traded);
      out.writeFloat(remainAmount);
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
        exchange = (ExchangeEnum) in.readObject(ExchangeEnum.class);
        type = (OrderTypeEnum) in.readObject(OrderTypeEnum.class);
        direction = (DirectionEnum) in.readObject(DirectionEnum.class);
        offset = (OffsetEnum) in.readObject(OffsetEnum.class);
        status = (StatusEnum) in.readObject(OffsetEnum.class);
        price = in.readFloat();
        volume = in.readFloat();
        traded = in.readFloat();
        remainAmount = in.readFloat();
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
      out.write("exchange").object(ExchangeEnum.class, exchange);
      out.write("orderId").object(String.class, orderId);
      out.write("OrderTypeEnum").object(OrderTypeEnum.class, type);
      out.write("direction").object(DirectionEnum.class, direction);
      out.write("offset").object(OffsetEnum.class, offset);
      out.write("status").object(StatusEnum.class, status);
      out.write("price").writeFloat(price);
      out.write("volume").writeFloat(volume);
      out.write("traded").writeFloat(traded);
      out.write("remainAmount").writeFloat(remainAmount);
      out.write("time").writeLong(time);
    }
  }

  @Override
  public void readMarshallable(WireIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      symbol = in.read("symbol").object(symbol, String.class);
      exchange = in.read("exchange").object(exchange, ExchangeEnum.class);
      orderId = in.read("orderId").object(orderId, String.class);
      type = in.read("type").object(type, OrderTypeEnum.class);
      direction = in.read("direction").object(direction, DirectionEnum.class);
      offset = in.read("offset").object(offset, OffsetEnum.class);
      status = in.read("status").object(status, StatusEnum.class);
      price = in.read("price").readFloat();
      volume = in.read("volume").readFloat();
      traded = in.read("traded").readFloat();
      remainAmount = in.read("remainAmount").readFloat();
      time = in.read("time").readLong();
    }
  }
}
