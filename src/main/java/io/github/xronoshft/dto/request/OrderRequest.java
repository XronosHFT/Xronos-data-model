package io.github.xronoshft.dto.request;


import io.github.xronoshft.constants.ContractTypeEnum;
import io.github.xronoshft.constants.DirectionEnum;
import io.github.xronoshft.constants.ExchangeEnum;
import io.github.xronoshft.constants.OffsetEnum;
import io.github.xronoshft.constants.OrderTypeEnum;
import io.github.xronoshft.constants.TradeModeEnum;
import io.github.xronoshft.dto.AbstractEvent;
import io.github.xronoshft.util.OrderIdUtils;
import net.openhft.chronicle.bytes.BytesIn;
import net.openhft.chronicle.bytes.BytesOut;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class OrderRequest extends AbstractEvent<OrderRequest> {

  private static final int MASHALLABLE_VERSION = 1;
  private DirectionEnum direction = DirectionEnum.NONE;
  private OrderTypeEnum orderType = OrderTypeEnum.NONE;
  private OffsetEnum offset = OffsetEnum.NONE;
  private ContractTypeEnum contractType = ContractTypeEnum.NONE;
  private TradeModeEnum tradeMode = TradeModeEnum.NONE;
  private String clientOrderId = StringUtils.EMPTY;
  private String accountId = StringUtils.EMPTY;
  private String apiName = StringUtils.EMPTY;
  private String identity = StringUtils.EMPTY;

  public String clientOrderId() {
    return clientOrderId;
  }

  public OrderRequest clientOrderId(String clientOrderId) {
    if (Objects.nonNull(clientOrderId) && !"".equals(clientOrderId)) {
      this.clientOrderId = clientOrderId;
    } else {
      this.clientOrderId = OrderIdUtils.generator(OrderIdUtils.XS_PREFIX);
    }
    return this;
  }

  private double volume;
  private double price;
  private int precision;
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

  public int precision() {
    return precision;
  }

  public OrderRequest precision(int precision) {
    this.precision = precision;
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

  public TradeModeEnum tradeMode() {
    return tradeMode;
  }

  public OrderRequest tradeMode(TradeModeEnum tradeMode) {
    this.tradeMode = tradeMode;
    return this;
  }

  public String accountId() {
    return accountId;
  }

  public OrderRequest accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  public String apiName() {
    return apiName;
  }

  public OrderRequest apiName(String apiName) {
    this.apiName = apiName;
    return this;
  }

  public String identity() {
    return identity;
  }

  public OrderRequest identity(String identity) {
    this.identity = identity;
    return this;
  }

  @Override
  public void writeMarshallable(BytesOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.writeObject(String.class, symbol);
      out.writeObject(String.class, clientOrderId);
      out.writeObject(String.class, accountId);
      out.writeObject(String.class, apiName);
      out.writeObject(String.class, identity);
      out.writeDouble(price);
      out.writeInt(precision);
      out.writeInt(leverRate);
      out.writeObject(OrderTypeEnum.class, orderType);
      out.writeDouble(volume);
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
        clientOrderId = (String) in.readObject(String.class);
        accountId = (String) in.readObject(String.class);
        apiName = (String) in.readObject(String.class);
        identity = (String) in.readObject(String.class);
        price = in.readDouble();
        precision = in.readInt();
        leverRate = in.readInt();
        orderType = (OrderTypeEnum) in.readObject(OrderTypeEnum.class);
        volume = in.readDouble();
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
      out.write("clientOrderId").object(String.class, clientOrderId);
      out.write("accountId").object(String.class, accountId);
      out.write("apiName").object(String.class, apiName);
      out.write("identity").object(String.class, identity);
      out.write("price").writeDouble(price);
      out.write("precision").writeInt(precision);
      out.write("leverRate").writeInt(leverRate);
      out.write("type").object(OrderTypeEnum.class, orderType);
      out.write("volume").writeDouble(volume);
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
      clientOrderId = in.read("clientOrderId").object(clientOrderId, String.class);
      apiName = in.read("apiName").object(apiName, String.class);
      accountId = in.read("accountId").object(accountId, String.class);
      identity = in.read("identity").object(identity, String.class);
      price = in.read("price").readDouble();
      precision = in.read("precision").readInt();
      leverRate = in.read("leverRate").readInt();
      orderType = in.read("type").object(orderType, OrderTypeEnum.class);
      volume = in.read("volume").readDouble();
      offset = in.read("offset").object(offset, OffsetEnum.class);
      contractType = in.read("contractType").object(contractType, ContractTypeEnum.class);
      tradeMode = in.read("tradeMode").object(tradeMode, TradeModeEnum.class);
    }
  }
}
