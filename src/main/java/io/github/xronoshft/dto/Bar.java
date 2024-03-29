package io.github.xronoshft.dto;

import io.github.xronoshft.constants.ExchangeEnum;
import io.github.xronoshft.constants.IntervalEnum;
import net.openhft.chronicle.bytes.BytesIn;
import net.openhft.chronicle.bytes.BytesOut;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;


public class Bar extends AbstractEvent<Bar> {

  private static final int MASHALLABLE_VERSION = 1;

  private String symbol = StringUtils.EMPTY;
  private ExchangeEnum exchange = ExchangeEnum.NONE;
  private Date datetime = new Date();
  private IntervalEnum interval;
  //成交量张数.值是买卖双边之和
  private double volume;
  //成交笔数.值是买卖双边之和
  private double count;
  // 成交量(币)。 值是买卖双边之和
  private double amount;
  private double openInterest;
  private double openPrice;
  private double highPrice;
  private double lowPrice;
  private double closePrice;
  private String xsSymbol = StringUtils.EMPTY;

  public String symbol() {
    return symbol;
  }

  public Bar symbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  public ExchangeEnum exchange() {
    return exchange;
  }

  public Bar exchange(ExchangeEnum exchange) {
    this.exchange = exchange;
    return this;
  }

  public Date datetime() {
    return datetime;
  }

  public Bar datetime(Date datetime) {
    this.datetime = datetime;
    return this;
  }

  public IntervalEnum interval() {
    return interval;
  }

  public Bar interval(IntervalEnum interval) {
    this.interval = interval;
    return this;
  }

  public double volume() {
    return volume;
  }

  public Bar volume(double volume) {
    this.volume = volume;
    return this;
  }

  public double openInterest() {
    return openInterest;
  }

  public Bar openInterest(double openInterest) {
    this.openInterest = openInterest;
    return this;
  }

  public double openPrice() {
    return openPrice;
  }

  public Bar openPrice(double openPrice) {
    this.openPrice = openPrice;
    return this;
  }

  public double highPrice() {
    return highPrice;
  }

  public Bar highPrice(double highPrice) {
    this.highPrice = highPrice;
    return this;
  }

  public double lowPrice() {
    return lowPrice;
  }

  public Bar lowPrice(double lowPrice) {
    this.lowPrice = lowPrice;
    return this;
  }

  public double closePrice() {
    return closePrice;
  }

  public Bar closePrice(double closePrice) {
    this.closePrice = closePrice;
    return this;
  }

  public double count() {
    return count;
  }

  public Bar count(double count) {
    this.count = count;
    return this;
  }

  public double amount() {
    return amount;
  }

  public Bar amount(double amount) {
    this.amount = amount;
    return this;
  }

  public Bar xsSymbol(String xsSymbol) {
    this.xsSymbol = xsSymbol;
    return this;
  }


  @Override
  public void writeMarshallable(BytesOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.writeObject(String.class, symbol);
      out.writeObject(ExchangeEnum.class, exchange);
      out.writeObject(Date.class, datetime);
      out.writeObject(IntervalEnum.class, interval);
      out.writeDouble(volume);
      out.writeDouble(count);
      out.writeDouble(amount);
      out.writeDouble(openInterest);
      out.writeDouble(openPrice);
      out.writeDouble(highPrice);
      out.writeDouble(lowPrice);
      out.writeDouble(closePrice);
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
        datetime = (Date) in.readObject(Date.class);
        interval = (IntervalEnum) in.readObject(IntervalEnum.class);
        volume = in.readDouble();
        count = in.readDouble();
        amount = in.readDouble();
        openInterest = in.readDouble();
        openPrice = in.readDouble();
        highPrice = in.readDouble();
        lowPrice = in.readDouble();
        closePrice = in.readDouble();
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
      out.write("datetime").object(Date.class, datetime);
      out.write("interval").object(IntervalEnum.class, interval);
      out.write("volume").writeDouble(volume);
      out.write("count").writeDouble(count);
      out.write("amount").writeDouble(amount);
      out.write("openInterest").writeDouble(openInterest);
      out.write("openPrice").writeDouble(openPrice);
      out.write("highPrice").writeDouble(highPrice);
      out.write("lowPrice").writeDouble(lowPrice);
      out.write("closePrice").writeDouble(closePrice);
    }
  }

  @Override
  public void readMarshallable(WireIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      symbol = in.read("symbol").object(symbol, String.class);
      exchange = in.read("exchange").object(exchange, ExchangeEnum.class);
      datetime = in.read("datetime").object(datetime, Date.class);
      interval = in.read("interval").object(interval, IntervalEnum.class);
      volume = in.read("volume").readDouble();
      count = in.read("count").readDouble();
      amount = in.read("amount").readDouble();
      openInterest = in.read("openInterest").readDouble();
      openPrice = in.read("openPrice").readDouble();
      highPrice = in.read("highPrice").readDouble();
      lowPrice = in.read("lowPrice").readDouble();
      closePrice = in.read("closePrice").readDouble();
    }
  }
}
