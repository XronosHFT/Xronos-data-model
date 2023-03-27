package io.github.xronoshft.dto.request;

import io.github.xronoshft.constants.ContractTypeEnum;
import io.github.xronoshft.constants.ExchangeEnum;
import io.github.xronoshft.dto.AbstractEvent;
import net.openhft.chronicle.bytes.BytesIn;
import net.openhft.chronicle.bytes.BytesOut;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;

import java.util.Map;

public class CancelOrderRequest extends AbstractEvent<CancelOrderRequest> {

  private static final int MASHALLABLE_VERSION = 1;

  private long orderId;

  private Map<Long, String> clientOrderIdSymbolMap;

  private String xsOrderId;

  private Long clientOrderId;

  private String accountId;

  private String apiName;

  private String identity;

  private ContractTypeEnum contractType;

  public Map<Long, String> clientOrderIdSymbolMap() {
    return clientOrderIdSymbolMap;
  }

  public CancelOrderRequest clientOrderIdSymbolMap(Map<Long, String> clientOrderIdSymbolMap) {
    this.clientOrderIdSymbolMap = clientOrderIdSymbolMap;
    return this;
  }

  public CancelOrderRequest orderId(long orderId) {
    this.orderId = orderId;
    return this;
  }

  public String xsOrderId() {
    return xsOrderId;
  }

  public CancelOrderRequest xsOrderId(String xsOrderId) {
    this.xsOrderId = xsOrderId;
    return this;
  }

  public long orderId() {
    return orderId;
  }

  public String symbol() {
    return symbol;
  }

  public CancelOrderRequest symbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  public ExchangeEnum exchange() {
    return exchange;
  }

  public CancelOrderRequest exchange(ExchangeEnum exchange) {
    this.exchange = exchange;
    return this;
  }

  public ContractTypeEnum contractType() {
    return contractType;
  }

  public CancelOrderRequest contractType(ContractTypeEnum contractTypeEnum) {
    this.contractType = contractTypeEnum;
    return this;
  }


  public Long clientOrderId() {
    return clientOrderId;
  }

  public CancelOrderRequest clientOrderId(Long clientOrderId) {
    this.clientOrderId = clientOrderId;
    return this;
  }

  public String accountId() {
    return accountId;
  }

  public CancelOrderRequest accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  public String apiName() {
    return apiName;
  }

  public CancelOrderRequest apiName(String apiName) {
    this.apiName = apiName;
    return this;
  }

  public String identity() {
    return identity;
  }

  public CancelOrderRequest identity(String identity) {
    this.identity = identity;
    return this;
  }

  @Override
  public void writeMarshallable(BytesOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.writeObject(String.class, symbol);
      out.writeLong(clientOrderId);
      out.writeObject(String.class, accountId);
      out.writeObject(String.class, apiName);
      out.writeObject(String.class, identity);
      out.writeObject(Map.class, clientOrderIdSymbolMap);
      out.writeObject(ExchangeEnum.class, exchange);
      out.writeObject(ContractTypeEnum.class, contractType);
      out.writeLong(orderId);
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
        apiName = (String) in.readObject(String.class);
        clientOrderId = in.readLong();
        identity = (String) in.readObject(String.class);
        clientOrderIdSymbolMap = (Map) in.readObject(Map.class);
        exchange = (ExchangeEnum) in.readObject(ExchangeEnum.class);
        contractType = (ContractTypeEnum) in.readObject(ContractTypeEnum.class);
        orderId = in.readLong();
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
      out.write("apiName").object(String.class, apiName);
      out.write("clientOrderId").writeLong(clientOrderId);
      out.write("identity").object(String.class, identity);
      out.write("clientOrderIdSymbolMap").object(Map.class, clientOrderIdSymbolMap);
      out.write("exchange").object(ExchangeEnum.class, exchange);
      out.write("contractType").object(ContractTypeEnum.class, contractType);
      out.write("orderId").writeLong(orderId);
    }
  }

  @Override
  public void readMarshallable(WireIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      symbol = in.read("symbol").object(symbol, String.class);
      accountId = in.read("accountId").object(accountId, String.class);
      apiName = in.read("apiName").object(apiName, String.class);
      clientOrderId = in.read("clientOrderId").readLong();
      identity = in.read("identity").object(identity, String.class);
      clientOrderIdSymbolMap = in.read("clientOrderIdSymbolMap").object(clientOrderIdSymbolMap, Map.class);
      exchange = in.read("exchange").object(exchange, ExchangeEnum.class);
      contractType = in.read("contractType").object(contractType, ContractTypeEnum.class);
      orderId = in.read("orderId").readLong();
    }
  }
}
