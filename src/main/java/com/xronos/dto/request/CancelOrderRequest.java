package com.xronos.dto.request;

import com.xronos.constants.ContractTypeEnum;
import com.xronos.constants.ExchangeEnum;
import com.xronos.dto.AbstractEvent;
import net.openhft.chronicle.bytes.BytesIn;
import net.openhft.chronicle.bytes.BytesOut;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;

import java.util.Map;

public class CancelOrderRequest extends AbstractEvent<CancelOrderRequest> {

  private static final int MASHALLABLE_VERSION = 1;

  private long orderId;

  private Map<String, String> clientOrderIdSymbolMap;

  private String xsOrderId;

  private ContractTypeEnum contractType;

  public Map<String, String> clientOrderIdSymbolMap() {
    return clientOrderIdSymbolMap;
  }

  public CancelOrderRequest clientOrderIdSymbolMap(Map<String, String> clientOrderIdSymbolMap) {
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

  @Override
  public void writeMarshallable(BytesOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.writeObject(String.class, symbol);
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
      clientOrderIdSymbolMap = in.read("clientOrderIdSymbolMap").object(clientOrderIdSymbolMap, Map.class);
      exchange = in.read("exchange").object(exchange, ExchangeEnum.class);
      exchange = in.read("contractType").object(exchange, ContractTypeEnum.class);
      orderId = in.read("orderId").readLong();
    }
  }
}
