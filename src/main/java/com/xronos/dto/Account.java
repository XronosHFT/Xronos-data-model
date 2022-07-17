package com.xronos.dto;

import com.xronos.constants.ExchangeEnum;
import com.xronos.constants.ProductEnum;
import com.xronos.constants.XronosConstant;
import com.xronos.util.ToolUtil;
import net.openhft.chronicle.bytes.BytesIn;
import net.openhft.chronicle.bytes.BytesOut;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;

public class Account extends AbstractEvent<Account> {

  private static final int MASHALLABLE_VERSION = 1;

  private String accountId;

  private String type;

  private String state;

  private String subType;

  /**
   * 账户可用余额
   */
  private double available;

  /**
   * 账户冻结余额
   */
  private double frozen;

  /**
   * 账户冻结余额
   */
  private double total;

  /**
   * 账户盈利
   */
  private double pnl;

  /**
   * 事件发生时间
   */
  private long sendingTime;

  public String accountId() {
    return accountId;
  }

  public String xsAccountId() {
    return ToolUtil.getAccountKey(exchange, accountId, symbol);
  }

  public Account accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  public String type() {
    return type;
  }

  public Account type(String type) {
    this.type = type;
    return this;
  }

  public String state() {
    return state;
  }

  public Account state(String state) {
    this.state = state;
    return this;
  }

  public String subType() {
    return subType;
  }

  public Account subType(String subType) {
    this.subType = subType;
    return this;
  }

  public Account exchange(ExchangeEnum exchange) {
    this.exchange = exchange;
    return this;
  }


  public String symbol() {
    return symbol;
  }

  public Account symbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  public double available() {
    return available;
  }

  public Account available(double available) {
    this.available = available;
    return this;
  }

  public double frozen() {
    return frozen;
  }

  public Account frozen(double frozen) {
    this.frozen = frozen;
    return this;
  }

  public double pnl() {
    return pnl;
  }

  public Account pnl(double pnl) {
    this.pnl = pnl;
    return this;
  }

  @Override
  public long sendingTime() {
    return sendingTime;
  }

  @Override
  public Account sendingTime(long sendingTime) {
    this.sendingTime = sendingTime;
    return this;
  }


  public double total() {
    return total;
  }

  public Account total(double total) {
    this.total = total;
    return this;
  }

  @Override
  public void writeMarshallable(BytesOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.writeObject(String.class, accountId);
      out.writeObject(String.class, symbol);
      out.writeObject(String.class, type);
      out.writeObject(String.class, state);
      out.writeObject(String.class, subType);
      out.writeDouble(available);
      out.writeDouble(frozen);
      out.writeDouble(total);
      out.writeDouble(pnl);
      out.writeLong(sendingTime);
      out.writeObject(ExchangeEnum.class, exchange);
    }
  }

  @Override
  public void readMarshallable(BytesIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      int version = (int) in.readStopBit();
      if (version == MASHALLABLE_VERSION) {
        accountId = (String) in.readObject(String.class);
        symbol = (String) in.readObject(String.class);
        type = (String) in.readObject(String.class);
        state = (String) in.readObject(String.class);
        subType = (String) in.readObject(String.class);
        available = in.readFloat();
        frozen = in.readFloat();
        total = in.readFloat();
        pnl = in.readFloat();
        sendingTime = in.readLong();
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
      out.write("accountId").object(String.class, accountId);
      out.write("symbol").object(String.class, symbol);
      out.write("type").object(String.class, type);
      out.write("state").object(String.class, state);
      out.write("subType").object(String.class, subType);
      out.write("available").writeDouble(available);
      out.write("frozen").writeDouble(frozen);
      out.write("total").writeDouble(total);
      out.write("pnl").writeDouble(pnl);
      out.write("sendingTime").writeLong(sendingTime);
      out.write("exchange").object(ExchangeEnum.class, exchange);
    }
  }

  @Override
  public void readMarshallable(WireIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      symbol = in.read("symbol").object(symbol, String.class);
      accountId = in.read("accountId").object(accountId, String.class);
      type = in.read("type").object(type, String.class);
      state = in.read("state").object(state, String.class);
      subType = in.read("subType").object(subType, String.class);
      available = in.read("available").readFloat();
      frozen = in.read("frozen").readFloat();
      total = in.read("total").readFloat();
      pnl = in.read("pnl").readFloat();
      sendingTime = in.read("sendingTime").readLong();
      exchange = in.read("exchange").object(exchange, ExchangeEnum.class);
    }
  }
}
