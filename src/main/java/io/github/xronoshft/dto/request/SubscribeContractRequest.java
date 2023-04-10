package io.github.xronoshft.dto.request;


import io.github.xronoshft.constants.ExchangeEnum;
import io.github.xronoshft.constants.IntervalEnum;
import io.github.xronoshft.dto.AbstractEvent;
import net.openhft.chronicle.bytes.BytesIn;
import net.openhft.chronicle.bytes.BytesOut;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;

public class SubscribeContractRequest extends AbstractEvent<SubscribeContractRequest> {
  private static final int MASHALLABLE_VERSION = 1;

  private IntervalEnum period;

  private String accountId;

  private String apiName;

  public IntervalEnum period() {
    return period;
  }

  public SubscribeContractRequest period(IntervalEnum period) {
    this.period = period;
    return this;
  }

  public String symbol() {
    return symbol;
  }

  public SubscribeContractRequest symbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  public ExchangeEnum exchange() {
    return exchange;
  }

  public SubscribeContractRequest exchange(ExchangeEnum exchange) {
    this.exchange = exchange;
    return this;
  }

  public String accountId() {
    return accountId;
  }

  public SubscribeContractRequest accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  public String apiName() {
    return apiName;
  }

  public SubscribeContractRequest apiName(String apiName) {
    this.apiName = apiName;
    return this;
  }

  @Override
  public void writeMarshallable(BytesOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.writeObject(String.class, symbol);
      out.writeObject(ExchangeEnum.class, exchange);
      out.writeObject(IntervalEnum.class, period);
      out.writeObject(String.class, accountId);
      out.writeObject(String.class, apiName);
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
        period = (IntervalEnum) in.readObject(IntervalEnum.class);
        accountId = (String) in.readObject(String.class);
        apiName = (String) in.readObject(String.class);
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
      out.write("period").object(IntervalEnum.class, period);
      out.write("accountId").object(String.class, accountId);
      out.write("apiName").object(String.class, apiName);
    }
  }

  @Override
  public void readMarshallable(WireIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      symbol = in.read("symbol").object(symbol, String.class);
      exchange = in.read("exchange").object(exchange, ExchangeEnum.class);
      period = in.read("period").object(period, IntervalEnum.class);
      accountId = in.read("accountId").object(accountId, String.class);
      apiName = in.read("apiName").object(apiName, String.class);
    }
  }
}
