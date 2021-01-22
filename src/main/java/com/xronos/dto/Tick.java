package com.xronos.dto;


import com.xronos.constants.ExchangeEnum;
import net.openhft.chronicle.bytes.BytesIn;
import net.openhft.chronicle.bytes.BytesOut;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;

public class Tick extends AbstractEvent<Tick> {
  private static final int MASHALLABLE_VERSION = 1;

  private long datetime;
  private String name = "";
  private float volume = 0;

  private float openInterest = 0;
  private float lastPrice = 0;
  private float lastVolume = 0;
  private float limitUp = 0;
  private float limitDown = 0;

  private float openPrice = 0;
  private float highPrice = 0;
  private float lowPrice = 0;
  private float preClose = 0;

  private float bidPrice1 = 0;
  private float bidPrice2 = 0;
  private float bidPrice3 = 0;
  private float bidPrice4 = 0;
  private float bidPrice5 = 0;

  private float askPrice1 = 0;
  private float askPrice2 = 0;
  private float askPrice3 = 0;
  private float askPrice4 = 0;
  private float askPrice5 = 0;

  private float bidVolume1 = 0;
  private float bidVolume2 = 0;
  private float bidVolume3 = 0;
  private float bidVolume4 = 0;
  private float bidVolume5 = 0;

  private float askVolume1 = 0;
  private float askVolume2 = 0;
  private float askVolume3 = 0;
  private float askVolume4 = 0;
  private float askVolume5 = 0;

  public String symbol() {
    return symbol;
  }

  public Tick symbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  public ExchangeEnum exchange() {
    return exchange;
  }

  public Tick exchange(ExchangeEnum exchange) {
    this.exchange = exchange;
    return this;
  }

  public long datetime() {
    return datetime;
  }

  public Tick datetime(long datetime) {
    this.datetime = datetime;
    return this;
  }

  public String name() {
    return name;
  }

  public Tick name(String name) {
    this.name = name;
    return this;
  }

  public float volume() {
    return volume;
  }

  public Tick volume(float volume) {
    this.volume = volume;
    return this;
  }

  public float openInterest() {
    return openInterest;
  }

  public Tick openInterest(float openInterest) {
    this.openInterest = openInterest;
    return this;
  }

  public float lastPrice() {
    return lastPrice;
  }

  public Tick lastPrice(float lastPrice) {
    this.lastPrice = lastPrice;
    return this;
  }

  public float lastVolume() {
    return lastVolume;
  }

  public Tick lastVolume(float lastVolume) {
    this.lastVolume = lastVolume;
    return this;
  }

  public float limitUp() {
    return limitUp;
  }

  public Tick limitUp(float limitUp) {
    this.limitUp = limitUp;
    return this;
  }

  public float limitDown() {
    return limitDown;
  }

  public Tick limitDown(float limitDown) {
    this.limitDown = limitDown;
    return this;
  }

  public float openPrice() {
    return openPrice;
  }

  public Tick openPrice(float openPrice) {
    this.openPrice = openPrice;
    return this;
  }

  public float highPrice() {
    return highPrice;
  }

  public Tick highPrice(float highPrice) {
    this.highPrice = highPrice;
    return this;
  }

  public float lowPrice() {
    return lowPrice;
  }

  public Tick lowPrice(float lowPrice) {
    this.lowPrice = lowPrice;
    return this;
  }

  public float preClose() {
    return preClose;
  }

  public Tick preClose(float preClose) {
    this.preClose = preClose;
    return this;
  }

  public float bidPrice1() {
    return bidPrice1;
  }

  public Tick bidPrice1(float bidPrice1) {
    this.bidPrice1 = bidPrice1;
    return this;
  }

  public float bidPrice2() {
    return bidPrice2;
  }

  public Tick bidPrice2(float bidPrice2) {
    this.bidPrice2 = bidPrice2;
    return this;
  }

  public float bidPrice3() {
    return bidPrice3;
  }

  public Tick bidPrice3(float bidPrice3) {
    this.bidPrice3 = bidPrice3;
    return this;
  }

  public float bidPrice4() {
    return bidPrice4;
  }

  public Tick bidPrice4(float bidPrice4) {
    this.bidPrice4 = bidPrice4;
    return this;
  }

  public float bidPrice5() {
    return bidPrice5;
  }

  public Tick bidPrice5(float bidPrice5) {
    this.bidPrice5 = bidPrice5;
    return this;
  }

  public float askPrice1() {
    return askPrice1;
  }

  public Tick askPrice1(float askPrice1) {
    this.askPrice1 = askPrice1;
    return this;
  }

  public float askPrice2() {
    return askPrice2;
  }

  public Tick askPrice2(float askPrice2) {
    this.askPrice2 = askPrice2;
    return this;
  }

  public float askPrice3() {
    return askPrice3;
  }

  public Tick askPrice3(float askPrice3) {
    this.askPrice3 = askPrice3;
    return this;
  }

  public float askPrice4() {
    return askPrice4;
  }

  public Tick askPrice4(float askPrice4) {
    this.askPrice4 = askPrice4;
    return this;
  }

  public float askPrice5() {
    return askPrice5;
  }

  public Tick askPrice5(float askPrice5) {
    this.askPrice5 = askPrice5;
    return this;
  }

  public float bidVolume1() {
    return bidVolume1;
  }

  public Tick bidVolume1(float bidVolume1) {
    this.bidVolume1 = bidVolume1;
    return this;
  }

  public float bidVolume2() {
    return bidVolume2;
  }

  public Tick bidVolume2(float bidVolume2) {
    this.bidVolume2 = bidVolume2;
    return this;
  }

  public float bidVolume3() {
    return bidVolume3;
  }

  public Tick bidVolume3(float bidVolume3) {
    this.bidVolume3 = bidVolume3;
    return this;
  }

  public float bidVolume4() {
    return bidVolume4;
  }

  public Tick bidVolume4(float bidVolume4) {
    this.bidVolume4 = bidVolume4;
    return this;
  }

  public float bidVolume5() {
    return bidVolume5;
  }

  public Tick bidVolume5(float bidVolume5) {
    this.bidVolume5 = bidVolume5;
    return this;
  }

  public float askVolume1() {
    return askVolume1;
  }

  public Tick askVolume1(float askVolume1) {
    this.askVolume1 = askVolume1;
    return this;
  }

  public float askVolume2() {
    return askVolume2;
  }

  public Tick askVolume2(float askVolume2) {
    this.askVolume2 = askVolume2;
    return this;
  }

  public float askVolume3() {
    return askVolume3;
  }

  public Tick askVolume3(float askVolume3) {
    this.askVolume3 = askVolume3;
    return this;
  }

  public float askVolume4() {
    return askVolume4;
  }

  public Tick askVolume4(float askVolume4) {
    this.askVolume4 = askVolume4;
    return this;
  }

  public float askVolume5() {
    return askVolume5;
  }

  public Tick askVolume5(float askVolume5) {
    this.askVolume5 = askVolume5;
    return this;
  }


  @Override
  public void writeMarshallable(BytesOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.writeObject(String.class, symbol);
      out.writeObject(ExchangeEnum.class, exchange);
      out.writeLong(datetime);
      out.writeObject(String.class, name);
      out.writeFloat(volume);
      out.writeFloat(openInterest);
      out.writeFloat(lastPrice);
      out.writeFloat(lastVolume);
      out.writeFloat(limitUp);
      out.writeFloat(limitDown);

      out.writeFloat(openPrice);
      out.writeFloat(highPrice);
      out.writeFloat(lowPrice);
      out.writeFloat(preClose);

      out.writeFloat(bidPrice1);
      out.writeFloat(bidPrice2);
      out.writeFloat(bidPrice3);
      out.writeFloat(bidPrice4);
      out.writeFloat(bidPrice5);

      out.writeFloat(askPrice1);
      out.writeFloat(askPrice2);
      out.writeFloat(askPrice3);
      out.writeFloat(askPrice4);
      out.writeFloat(askPrice5);

      out.writeFloat(bidVolume1);
      out.writeFloat(bidVolume2);
      out.writeFloat(bidVolume3);
      out.writeFloat(bidVolume4);
      out.writeFloat(bidVolume5);

      out.writeFloat(askVolume1);
      out.writeFloat(askVolume2);
      out.writeFloat(askVolume3);
      out.writeFloat(askVolume4);
      out.writeFloat(askVolume5);
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
        datetime = in.readLong();
        name = (String) in.readObject(String.class);
        volume = in.readFloat();
        openInterest = in.readFloat();
        lastPrice = in.readFloat();
        lastVolume = in.readFloat();
        limitUp = in.readFloat();
        limitDown = in.readFloat();

        openPrice = in.readFloat();
        highPrice = in.readFloat();
        lowPrice = in.readFloat();
        preClose = in.readFloat();

        bidPrice1 = in.readFloat();
        bidPrice2 = in.readFloat();
        bidPrice3 = in.readFloat();
        bidPrice4 = in.readFloat();
        bidPrice5 = in.readFloat();

        askPrice1 = in.readFloat();
        askPrice2 = in.readFloat();
        askPrice3 = in.readFloat();
        askPrice4 = in.readFloat();
        askPrice5 = in.readFloat();

        bidVolume1 = in.readFloat();
        bidVolume2 = in.readFloat();
        bidVolume3 = in.readFloat();
        bidVolume4 = in.readFloat();
        bidVolume5 = in.readFloat();

        askVolume1 = in.readFloat();
        askVolume2 = in.readFloat();
        askVolume3 = in.readFloat();
        askVolume4 = in.readFloat();
        askVolume5 = in.readFloat();
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
      out.write("datetime").writeLong(datetime);
      out.write("name").object(String.class, name);
      out.write("volume").writeFloat(volume);

      out.write("openInterest").writeFloat(openInterest);
      out.write("lastPrice").writeFloat(lastPrice);
      out.write("lastVolume").writeFloat(lastVolume);
      out.write("limitUp").writeFloat(limitUp);
      out.write("limitDown").writeFloat(limitDown);

      out.write("openPrice").writeFloat(openPrice);
      out.write("highPrice").writeFloat(highPrice);
      out.write("lowPrice").writeFloat(lowPrice);
      out.write("preClose").writeFloat(preClose);

      out.write("bidPrice1").writeFloat(bidPrice1);
      out.write("bidPrice2").writeFloat(bidPrice2);
      out.write("bidPrice3").writeFloat(bidPrice3);
      out.write("bidPrice4").writeFloat(bidPrice4);
      out.write("bidPrice5").writeFloat(bidPrice5);

      out.write("askPrice1").writeFloat(askPrice1);
      out.write("askPrice2").writeFloat(askPrice2);
      out.write("askPrice3").writeFloat(askPrice3);
      out.write("askPrice4").writeFloat(askPrice4);
      out.write("askPrice5").writeFloat(askPrice5);

      out.write("bidVolume1").writeFloat(bidVolume1);
      out.write("bidVolume2").writeFloat(bidVolume2);
      out.write("bidVolume3").writeFloat(bidVolume3);
      out.write("bidVolume4").writeFloat(bidVolume4);
      out.write("bidVolume5").writeFloat(bidVolume5);

      out.write("askVolume1").writeFloat(askVolume1);
      out.write("askVolume2").writeFloat(askVolume2);
      out.write("askVolume3").writeFloat(askVolume3);
      out.write("askVolume4").writeFloat(askVolume4);
      out.write("askVolume5").writeFloat(askVolume5);
    }
  }

  @Override
  public void readMarshallable(WireIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      symbol = in.read("symbol").object(symbol, String.class);
      exchange = in.read("exchange").object(exchange, ExchangeEnum.class);
      datetime = in.read("datetime").readLong();
      name = in.read("name").object(name, String.class);
      volume = in.read("volume").readFloat();

      openInterest = in.read("openInterest").readFloat();
      lastPrice = in.read("lastPrice").readFloat();
      lastVolume = in.read("lastVolume").readFloat();
      limitUp = in.read("limitUp").readFloat();
      limitDown = in.read("limitDown").readFloat();

      openPrice = in.read("openPrice").readFloat();
      highPrice = in.read("highPrice").readFloat();
      lowPrice = in.read("lowPrice").readFloat();
      preClose = in.read("preClose").readFloat();

      bidPrice1 = in.read("bidPrice1").readFloat();
      bidPrice2 = in.read("bidPrice2").readFloat();
      bidPrice3 = in.read("bidPrice3").readFloat();
      bidPrice4 = in.read("bidPrice4").readFloat();
      bidPrice5 = in.read("bidPrice5").readFloat();

      askPrice1 = in.read("askPrice1").readFloat();
      askPrice2 = in.read("askPrice2").readFloat();
      askPrice3 = in.read("askPrice3").readFloat();
      askPrice4 = in.read("askPrice4").readFloat();
      askPrice5 = in.read("askPrice5").readFloat();

      bidVolume1 = in.read("bidVolume1").readFloat();
      bidVolume2 = in.read("bidVolume2").readFloat();
      bidVolume3 = in.read("bidVolume3").readFloat();
      bidVolume4 = in.read("bidVolume4").readFloat();
      bidVolume5 = in.read("bidVolume5").readFloat();

      askVolume1 = in.read("askVolume1").readFloat();
      askVolume2 = in.read("askVolume2").readFloat();
      askVolume3 = in.read("askVolume3").readFloat();
      askVolume4 = in.read("askVolume4").readFloat();
      askVolume5 = in.read("askVolume5").readFloat();
    }
  }
}
