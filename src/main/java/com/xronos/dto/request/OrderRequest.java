package com.xronos.dto.request;


import com.xronos.constants.ContractTypeEnum;
import com.xronos.constants.DirectionEnum;
import com.xronos.constants.ExchangeEnum;
import com.xronos.constants.OffsetEnum;
import com.xronos.constants.OrderTypeEnum;
import com.xronos.dto.AbstractEvent;
import net.openhft.chronicle.bytes.BytesIn;
import net.openhft.chronicle.bytes.BytesOut;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;

public class OrderRequest extends AbstractEvent<OrderRequest> {

  private static final int MASHALLABLE_VERSION = 1;
  private DirectionEnum direction = DirectionEnum.NONE;
  private OrderTypeEnum orderType = OrderTypeEnum.NONE;
  private OffsetEnum offset = OffsetEnum.NONE;
  private ContractTypeEnum contractType = ContractTypeEnum.NONE;

  private double volume;
  private double price;
  private int leverRate = 1;

  public String symbol() {
    return symbol;
  }

  public OrderRequest symbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  public ExchangeEnum exchange() {
    return exchange;
  }

  public OrderRequest exchange(ExchangeEnum exchange) {
    this.exchange = exchange;
    return this;
  }

  public DirectionEnum direction() {
    return direction;
  }

  public OrderRequest direction(DirectionEnum direction) {
    this.direction = direction;
    return this;
  }

  public OrderTypeEnum orderType() {
    return orderType;
  }

  public OrderRequest orderType(OrderTypeEnum orderType) {
    this.orderType = orderType;
    return this;
  }

  public double volume() {
    return volume;
  }

  public OrderRequest volume(double volume) {
    this.volume = volume;
    return this;
  }

  public double price() {
    return price;
  }

  public OrderRequest price(double price) {
    this.price = price;
    return this;
  }

  public OffsetEnum offset() {
    return offset;
  }

  public OrderRequest offset(OffsetEnum offset) {
    this.offset = offset;
    return this;
  }

  public int leverRate() {
    return leverRate;
  }

  public OrderRequest leverRate(int leverRate) {
    this.leverRate = leverRate;
    return this;
  }

  public ContractTypeEnum contractType() {
    return contractType;
  }

  public OrderRequest contractType(ContractTypeEnum contractType) {
    this.contractType = contractType;
    return this;
  }

  @Override
  public void writeMarshallable(BytesOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.writeObject(String.class, symbol);
      out.writeDouble(price);
      out.writeInt(leverRate);
      out.writeObject(OrderTypeEnum.class, orderType);
      out.writeDouble(volume);
      out.writeObject(OffsetEnum.class, offset);
      out.writeObject(ContractTypeEnum.class, contractType);
    }
  }

  @Override
  public void readMarshallable(BytesIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      int version = (int) in.readStopBit();
      if (version == MASHALLABLE_VERSION) {
        symbol = (String) in.readObject(String.class);
        price = in.readDouble();
        leverRate = in.readInt();
        orderType = (OrderTypeEnum) in.readObject(OrderTypeEnum.class);
        volume = in.readDouble();
        offset = (OffsetEnum) in.readObject(OffsetEnum.class);
        contractType = (ContractTypeEnum) in.readObject(ContractTypeEnum.class);
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
      out.write("price").writeDouble(price);
      out.write("leverRate").writeInt(leverRate);
      out.write("type").object(OrderTypeEnum.class, orderType);
      out.write("volume").writeDouble(volume);
      out.write("offset").object(OffsetEnum.class, offset);
      out.write("contractType").object(ContractTypeEnum.class, contractType);
    }
  }

  @Override
  public void readMarshallable(WireIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      symbol = in.read("symbol").object(symbol, String.class);
      price = in.read("price").readDouble();
      leverRate = in.read("leverRate").readInt();
      orderType = in.read("type").object(orderType, OrderTypeEnum.class);
      volume = in.read("volume").readDouble();
      offset = in.read("offset").object(offset, OffsetEnum.class);
      contractType = in.read("contractType").object(contractType, ContractTypeEnum.class);
    }
  }
}
