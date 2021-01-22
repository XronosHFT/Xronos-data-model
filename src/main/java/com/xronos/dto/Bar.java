package com.xronos.dto;

import com.xronos.constants.ExchangeEnum;
import com.xronos.constants.IntervalEnum;
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
  private float volume;
  private float openInterest;
  private float openPrice;
  private float highPrice;
  private float lowPrice;
  private float closePrice;
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

  public float volume() {
    return volume;
  }

  public Bar volume(float volume) {
    this.volume = volume;
    return this;
  }

  public float openInterest() {
    return openInterest;
  }

  public Bar openInterest(float openInterest) {
    this.openInterest = openInterest;
    return this;
  }

  public float openPrice() {
    return openPrice;
  }

  public Bar openPrice(float openPrice) {
    this.openPrice = openPrice;
    return this;
  }

  public float highPrice() {
    return highPrice;
  }

  public Bar highPrice(float highPrice) {
    this.highPrice = highPrice;
    return this;
  }

  public float lowPrice() {
    return lowPrice;
  }

  public Bar lowPrice(float lowPrice) {
    this.lowPrice = lowPrice;
    return this;
  }

  public float closePrice() {
    return closePrice;
  }

  public Bar closePrice(float closePrice) {
    this.closePrice = closePrice;
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
      out.writeFloat(volume);
      out.writeFloat(openInterest);
      out.writeFloat(openPrice);
      out.writeFloat(highPrice);
      out.writeFloat(lowPrice);
      out.writeFloat(closePrice);
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
        volume = in.readFloat();
        openInterest = in.readFloat();
        openPrice = in.readFloat();
        highPrice = in.readFloat();
        lowPrice = in.readFloat();
        closePrice = in.readFloat();
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
      out.write("volume").writeFloat(volume);
      out.write("openInterest").writeFloat(openInterest);
      out.write("openPrice").writeFloat(openPrice);
      out.write("highPrice").writeFloat(highPrice);
      out.write("lowPrice").writeFloat(lowPrice);
      out.write("closePrice").writeFloat(closePrice);
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
      volume = in.read("volume").readFloat();
      openInterest = in.read("openInterest").readFloat();
      openPrice = in.read("openPrice").readFloat();
      highPrice = in.read("highPrice").readFloat();
      lowPrice = in.read("lowPrice").readFloat();
      closePrice = in.read("closePrice").readFloat();
    }
  }
}
