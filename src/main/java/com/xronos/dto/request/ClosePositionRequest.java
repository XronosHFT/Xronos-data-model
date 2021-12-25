package com.xronos.dto.request;


import com.xronos.constants.ContractTypeEnum;
import com.xronos.constants.DirectionEnum;
import com.xronos.constants.ExchangeEnum;
import com.xronos.constants.OffsetEnum;
import com.xronos.constants.OrderTypeEnum;
import com.xronos.constants.TradeModeEnum;
import com.xronos.dto.AbstractEvent;
import net.openhft.chronicle.bytes.BytesIn;
import net.openhft.chronicle.bytes.BytesOut;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;

public class ClosePositionRequest extends AbstractEvent<ClosePositionRequest> {

  private static final int MASHALLABLE_VERSION = 1;
  private DirectionEnum direction = DirectionEnum.NONE;
  private OrderTypeEnum orderType = OrderTypeEnum.NONE;
  private OffsetEnum offset = OffsetEnum.NONE;
  private ContractTypeEnum contractType = ContractTypeEnum.NONE;
  private TradeModeEnum tradeMode = TradeModeEnum.NONE;


  public String symbol() {
    return symbol;
  }

  public ClosePositionRequest symbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  public ExchangeEnum exchange() {
    return exchange;
  }

  public ClosePositionRequest exchange(ExchangeEnum exchange) {
    this.exchange = exchange;
    return this;
  }

  public DirectionEnum direction() {
    return direction;
  }

  public ClosePositionRequest direction(DirectionEnum direction) {
    this.direction = direction;
    return this;
  }

  public OrderTypeEnum orderType() {
    return orderType;
  }

  public ClosePositionRequest orderType(OrderTypeEnum orderType) {
    this.orderType = orderType;
    return this;
  }


  public OffsetEnum offset() {
    return offset;
  }

  public ClosePositionRequest offset(OffsetEnum offset) {
    this.offset = offset;
    return this;
  }


  public ContractTypeEnum contractType() {
    return contractType;
  }

  public ClosePositionRequest contractType(ContractTypeEnum contractType) {
    this.contractType = contractType;
    return this;
  }

  public TradeModeEnum tradeMode() {
    return tradeMode;
  }

  public ClosePositionRequest tradeMode(TradeModeEnum tradeMode) {
    this.tradeMode = tradeMode;
    return this;
  }

  @Override
  public void writeMarshallable(BytesOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.writeObject(String.class, symbol);
      out.writeObject(OrderTypeEnum.class, orderType);
      out.writeObject(OffsetEnum.class, offset);
      out.writeObject(ContractTypeEnum.class, contractType);
      out.writeObject(TradeModeEnum.class, tradeMode);
    }
  }

  @Override
  public void readMarshallable(BytesIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      int version = (int) in.readStopBit();
      if (version == MASHALLABLE_VERSION) {
        symbol = (String) in.readObject(String.class);
        orderType = (OrderTypeEnum) in.readObject(OrderTypeEnum.class);
        offset = (OffsetEnum) in.readObject(OffsetEnum.class);
        contractType = (ContractTypeEnum) in.readObject(ContractTypeEnum.class);
        tradeMode = (TradeModeEnum) in.readObject(TradeModeEnum.class);
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
      out.write("type").object(OrderTypeEnum.class, orderType);
      out.write("offset").object(OffsetEnum.class, offset);
      out.write("contractType").object(ContractTypeEnum.class, contractType);
      out.write("tradeMode").object(TradeModeEnum.class, tradeMode);
    }
  }

  @Override
  public void readMarshallable(WireIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      symbol = in.read("symbol").object(symbol, String.class);
      orderType = in.read("type").object(orderType, OrderTypeEnum.class);
      offset = in.read("offset").object(offset, OffsetEnum.class);
      contractType = in.read("contractType").object(contractType, ContractTypeEnum.class);
      tradeMode = in.read("tradeMode").object(tradeMode, TradeModeEnum.class);
    }
  }
}
