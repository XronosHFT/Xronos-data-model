package com.xronos.dto;

import com.xronos.constants.ContractTypeEnum;
import com.xronos.constants.DirectionEnum;
import com.xronos.constants.ExchangeEnum;
import com.xronos.constants.LeverRateEnum;
import com.xronos.constants.OffsetEnum;
import com.xronos.constants.OrderTypeEnum;
import com.xronos.constants.StatusEnum;
import com.xronos.constants.XronosConstant;
import net.openhft.chronicle.bytes.BytesIn;
import net.openhft.chronicle.bytes.BytesOut;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

public class Order extends AbstractEvent<Order> {
  private static final int MASHALLABLE_VERSION = 1;

  private long orderId = Long.MIN_VALUE;
  private String clientOrderId =StringUtils.EMPTY;

  private OrderTypeEnum orderType = OrderTypeEnum.NONE;
  private DirectionEnum direction = DirectionEnum.NONE;
  private OffsetEnum offset = OffsetEnum.NONE;
  private StatusEnum status = StatusEnum.NONE;
  private ContractTypeEnum contractType = ContractTypeEnum.NONE;
  private LeverRateEnum leverRate = LeverRateEnum.NONE;

  private double price;
  private double volume;
  private double traded;
  private double remainAmount;
  private double fee;
  private long time = 0L;

  private String accountId = StringUtils.EMPTY;

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

  public long orderId() {
    return orderId;
  }

  public Order orderId(long orderId) {
    this.orderId = orderId;
    return this;
  }

  public OrderTypeEnum orderType() {
    return orderType;
  }

  public Order orderType(OrderTypeEnum type) {
    this.orderType = type;
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

  public double price() {
    return price;
  }

  public Order price(double price) {
    this.price = price;
    return this;
  }

  public double volume() {
    return volume;
  }

  public Order volume(double volume) {
    this.volume = volume;
    return this;
  }

  public double traded() {
    return traded;
  }

  public Order traded(double traded) {
    this.traded = traded;
    return this;
  }

  public double remainAmount() {
    return remainAmount;
  }

  public Order remainAmount(double remainAmount) {
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

  public ContractTypeEnum contractType() {
    return contractType;
  }

  public Order contractType(ContractTypeEnum contractTypeEnum) {
    this.contractType = contractTypeEnum;
    return this;
  }

  public LeverRateEnum leverRate() {
    return leverRate;
  }

  public Order leverRate(LeverRateEnum leverRate) {
    this.leverRate = leverRate;
    return this;
  }

  public String xsOrderId() {
    return (exchange.name() + XronosConstant.DOT_SEPARATOR + orderId).toLowerCase();
  }

  public String xsSymbol() {
    return (symbol + XronosConstant.DOT_SEPARATOR + exchange.name()).toLowerCase();
  }

  /**
   * 状态是活跃的，订单必定是活跃状态，活跃指的是还有接下来的状态。
   * 对于合约订单，如果是开仓状态，订单仍旧应该属于活跃订单，其他订单（如现货），此时应该是不活跃
   *
   * @return
   */
  public boolean active() {
    return StatusEnum.isActive(status);
  }

  public double fee() {
    return fee;
  }

  public Order fee(double fee) {
    this.fee = fee;
    return this;
  }

  public String accountId() {
    return accountId;
  }

  public Order accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  public String clientOrderId() {
    return clientOrderId;
  }

  public Order clientOrderId(String clientOrderId) {
    this.clientOrderId = clientOrderId;
    return this;
  }

  @Override
  public void writeMarshallable(BytesOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.writeObject(String.class, symbol);
      out.writeLong(orderId);
      out.writeObject(String.class, clientOrderId);
      out.writeObject(String.class, accountId);
      out.writeObject(ExchangeEnum.class, exchange);
      out.writeObject(OrderTypeEnum.class, orderType);
      out.writeObject(DirectionEnum.class, direction);
      out.writeObject(OffsetEnum.class, offset);
      out.writeObject(StatusEnum.class, status);
      out.writeObject(LeverRateEnum.class, leverRate);
      out.writeDouble(price);
      out.writeDouble(volume);
      out.writeDouble(traded);
      out.writeDouble(remainAmount);
      out.writeDouble(fee);
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
        accountId = (String) in.readObject(String.class);
        clientOrderId = (String) in.readObject(String.class);
        orderId = in.readLong();
        exchange = (ExchangeEnum) in.readObject(ExchangeEnum.class);
        orderType = (OrderTypeEnum) in.readObject(OrderTypeEnum.class);
        direction = (DirectionEnum) in.readObject(DirectionEnum.class);
        offset = (OffsetEnum) in.readObject(OffsetEnum.class);
        status = (StatusEnum) in.readObject(StatusEnum.class);
        leverRate = (LeverRateEnum) in.readObject(LeverRateEnum.class);
        price = in.readFloat();
        volume = in.readFloat();
        traded = in.readFloat();
        remainAmount = in.readFloat();
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
      out.write("accountId").object(String.class, accountId);
      out.write("clientOrderId").object(String.class, clientOrderId);
      out.write("exchange").object(ExchangeEnum.class, exchange);
      out.write("orderId").writeLong(orderId);
      out.write("orderType").object(OrderTypeEnum.class, orderType);
      out.write("direction").object(DirectionEnum.class, direction);
      out.write("offset").object(OffsetEnum.class, offset);
      out.write("status").object(StatusEnum.class, status);
      out.write("leverRate").object(LeverRateEnum.class, leverRate);
      out.write("price").writeDouble(price);
      out.write("volume").writeDouble(volume);
      out.write("traded").writeDouble(traded);
      out.write("remainAmount").writeDouble(remainAmount);
      out.write("fee").writeDouble(fee);
      out.write("time").writeLong(time);
    }
  }

  @Override
  public void readMarshallable(WireIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      symbol = in.read("symbol").object(symbol, String.class);
      accountId = in.read("accountId").object(accountId, String.class);
      clientOrderId = in.read("clientOrderId").object(clientOrderId, String.class);
      exchange = in.read("exchange").object(exchange, ExchangeEnum.class);
      orderId = in.read("orderId").readLong();
      orderType = in.read("type").object(orderType, OrderTypeEnum.class);
      direction = in.read("direction").object(direction, DirectionEnum.class);
      offset = in.read("offset").object(offset, OffsetEnum.class);
      status = in.read("status").object(status, StatusEnum.class);
      leverRate = in.read("leverRate").object(leverRate, LeverRateEnum.class);
      price = in.read("price").readFloat();
      volume = in.read("volume").readFloat();
      traded = in.read("traded").readFloat();
      remainAmount = in.read("remainAmount").readFloat();
      fee = in.read("fee").readFloat();
      time = in.read("time").readLong();
    }
  }
}
