package com.xronos.dto;

import com.xronos.constants.ExchangeEnum;
import net.openhft.chronicle.bytes.BytesIn;
import net.openhft.chronicle.bytes.BytesOut;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;
import org.apache.commons.lang3.StringUtils;

public class Balance extends AbstractEvent<Balance> {

  private static final int MASHALLABLE_VERSION = 1;
  private String accountId = StringUtils.EMPTY;
  private String asset = StringUtils.EMPTY;
  private double balance;
  private double available;
  private double frozen;
  private ExchangeEnum exchange = ExchangeEnum.NONE;

  public String accountId() {
    return accountId;
  }

  public Balance accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  public double balance() {
    return balance;
  }

  public Balance balance(double balance) {
    this.balance = balance;
    return this;
  }

  public double frozen() {
    return frozen;
  }

  public Balance frozen(double frozen) {
    this.frozen = frozen;
    return this;
  }

  public double available() {
    return available;
  }

  public String xsAccountId() {
    return gatewayName + "." + accountId;
  }

  public String asset() {
    return asset;
  }

  public Balance asset(String asset) {
    this.asset = asset;
    return this;
  }

  public ExchangeEnum exchange() {
    return exchange;
  }

  public Balance exchange(ExchangeEnum exchange) {
    this.exchange = exchange;
    return this;
  }

  public String xsSymbol() {
    return (asset + "." + exchange.name()).toLowerCase();
  }

  public Balance available(double available) {
    this.available = available;
    return this;
  }


  @Override
  public void writeMarshallable(BytesOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.writeObject(String.class, symbol);
      out.writeObject(String.class, accountId);
      out.writeObject(String.class, asset);
      out.writeDouble(balance);
      out.writeDouble(available);
      out.writeDouble(frozen);
      out.writeObject(ExchangeEnum.class, exchange);
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
        asset = (String) in.readObject(String.class);
        balance = in.readFloat();
        available = in.readFloat();
        frozen = in.readFloat();
        exchange = (ExchangeEnum) in.readObject(ExchangeEnum.class);
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
      out.write("asset").object(String.class, asset);
      out.write("balance").writeDouble(balance);
      out.write("available").writeDouble(available);
      out.write("frozen").writeDouble(frozen);
      out.write("exchange").object(ExchangeEnum.class, exchange);
    }
  }

  @Override
  public void readMarshallable(WireIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      symbol = in.read("symbol").object(symbol, String.class);
      accountId = in.read("accountId").object(accountId, String.class);
      asset = in.read("asset").object(asset, String.class);
      balance = in.read("balance").readFloat();
      available = in.read("available").readFloat();
      frozen = in.read("frozen").readFloat();
      exchange = in.read("exchange").object(exchange, ExchangeEnum.class);
    }
  }
}
