package com.xronos.dto;


import com.xronos.constants.ContractTypeEnum;
import com.xronos.constants.ExchangeEnum;
import com.xronos.constants.XronosConstant;
import net.openhft.chronicle.bytes.BytesIn;
import net.openhft.chronicle.bytes.BytesOut;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;

public class Tick extends AbstractEvent<Tick> {
  private static final int MASHALLABLE_VERSION = 1;

  private long datetime;
  private String name = "";
  private ContractTypeEnum contractType = ContractTypeEnum.NONE;
  private double volume = 0;

  private double openInterest = 0;
  private double lastPrice = 0;
  private double lastVolume = 0;
  private double limitUp = 0;
  private double limitDown = 0;

  private double openPrice = 0;
  private double highPrice = 0;
  private double lowPrice = 0;
  private double preClose = 0;

  private double bidPrice1 = 0;
  private double bidPrice2 = 0;
  private double bidPrice3 = 0;
  private double bidPrice4 = 0;
  private double bidPrice5 = 0;

  private double askPrice1 = 0;
  private double askPrice2 = 0;
  private double askPrice3 = 0;
  private double askPrice4 = 0;
  private double askPrice5 = 0;

  private double bidVolume1 = 0;
  private double bidVolume2 = 0;
  private double bidVolume3 = 0;
  private double bidVolume4 = 0;
  private double bidVolume5 = 0;

  private double askVolume1 = 0;
  private double askVolume2 = 0;
  private double askVolume3 = 0;
  private double askVolume4 = 0;
  private double askVolume5 = 0;

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

  public double volume() {
    return volume;
  }

  public Tick volume(double volume) {
    this.volume = volume;
    return this;
  }

  public double openInterest() {
    return openInterest;
  }

  public Tick openInterest(double openInterest) {
    this.openInterest = openInterest;
    return this;
  }

  public double lastPrice() {
    return lastPrice;
  }

  public Tick lastPrice(double lastPrice) {
    this.lastPrice = lastPrice;
    return this;
  }

  public double lastVolume() {
    return lastVolume;
  }

  public Tick lastVolume(double lastVolume) {
    this.lastVolume = lastVolume;
    return this;
  }

  public double limitUp() {
    return limitUp;
  }

  public Tick limitUp(double limitUp) {
    this.limitUp = limitUp;
    return this;
  }

  public double limitDown() {
    return limitDown;
  }

  public Tick limitDown(double limitDown) {
    this.limitDown = limitDown;
    return this;
  }

  public double openPrice() {
    return openPrice;
  }

  public Tick openPrice(double openPrice) {
    this.openPrice = openPrice;
    return this;
  }

  public double highPrice() {
    return highPrice;
  }

  public Tick highPrice(double highPrice) {
    this.highPrice = highPrice;
    return this;
  }

  public double lowPrice() {
    return lowPrice;
  }

  public Tick lowPrice(double lowPrice) {
    this.lowPrice = lowPrice;
    return this;
  }

  public double preClose() {
    return preClose;
  }

  public Tick preClose(double preClose) {
    this.preClose = preClose;
    return this;
  }

  public double bidPrice1() {
    return bidPrice1;
  }

  public Tick bidPrice1(double bidPrice1) {
    this.bidPrice1 = bidPrice1;
    return this;
  }

  public double bidPrice2() {
    return bidPrice2;
  }

  public Tick bidPrice2(double bidPrice2) {
    this.bidPrice2 = bidPrice2;
    return this;
  }

  public double bidPrice3() {
    return bidPrice3;
  }

  public Tick bidPrice3(double bidPrice3) {
    this.bidPrice3 = bidPrice3;
    return this;
  }

  public double bidPrice4() {
    return bidPrice4;
  }

  public Tick bidPrice4(double bidPrice4) {
    this.bidPrice4 = bidPrice4;
    return this;
  }

  public double bidPrice5() {
    return bidPrice5;
  }

  public Tick bidPrice5(double bidPrice5) {
    this.bidPrice5 = bidPrice5;
    return this;
  }

  public double askPrice1() {
    return askPrice1;
  }

  public Tick askPrice1(double askPrice1) {
    this.askPrice1 = askPrice1;
    return this;
  }

  public double askPrice2() {
    return askPrice2;
  }

  public Tick askPrice2(double askPrice2) {
    this.askPrice2 = askPrice2;
    return this;
  }

  public double askPrice3() {
    return askPrice3;
  }

  public Tick askPrice3(double askPrice3) {
    this.askPrice3 = askPrice3;
    return this;
  }

  public double askPrice4() {
    return askPrice4;
  }

  public Tick askPrice4(double askPrice4) {
    this.askPrice4 = askPrice4;
    return this;
  }

  public double askPrice5() {
    return askPrice5;
  }

  public Tick askPrice5(double askPrice5) {
    this.askPrice5 = askPrice5;
    return this;
  }

  public double bidVolume1() {
    return bidVolume1;
  }

  public Tick bidVolume1(double bidVolume1) {
    this.bidVolume1 = bidVolume1;
    return this;
  }

  public double bidVolume2() {
    return bidVolume2;
  }

  public Tick bidVolume2(double bidVolume2) {
    this.bidVolume2 = bidVolume2;
    return this;
  }

  public double bidVolume3() {
    return bidVolume3;
  }

  public Tick bidVolume3(double bidVolume3) {
    this.bidVolume3 = bidVolume3;
    return this;
  }

  public double bidVolume4() {
    return bidVolume4;
  }

  public Tick bidVolume4(double bidVolume4) {
    this.bidVolume4 = bidVolume4;
    return this;
  }

  public double bidVolume5() {
    return bidVolume5;
  }

  public Tick bidVolume5(double bidVolume5) {
    this.bidVolume5 = bidVolume5;
    return this;
  }

  public double askVolume1() {
    return askVolume1;
  }

  public Tick askVolume1(double askVolume1) {
    this.askVolume1 = askVolume1;
    return this;
  }

  public double askVolume2() {
    return askVolume2;
  }

  public Tick askVolume2(double askVolume2) {
    this.askVolume2 = askVolume2;
    return this;
  }

  public double askVolume3() {
    return askVolume3;
  }

  public Tick askVolume3(double askVolume3) {
    this.askVolume3 = askVolume3;
    return this;
  }

  public double askVolume4() {
    return askVolume4;
  }

  public Tick askVolume4(double askVolume4) {
    this.askVolume4 = askVolume4;
    return this;
  }

  public double askVolume5() {
    return askVolume5;
  }

  public Tick askVolume5(double askVolume5) {
    this.askVolume5 = askVolume5;
    return this;
  }

  public ContractTypeEnum contractType() {
    return contractType;
  }

  public Tick contractType(ContractTypeEnum contractType) {
    this.contractType = contractType;
    return this;
  }

  @Override
  public String xsSymbol() {
    if (!ContractTypeEnum.NONE.equals(contractType)) {
      return (symbol + XronosConstant.UNDERLINE_SEPARATOR + contractType + XronosConstant.DOT_SEPARATOR + exchange.name()).toLowerCase();
    }
    return (symbol + XronosConstant.DOT_SEPARATOR + exchange.name()).toLowerCase();
  }

  @Override
  public void writeMarshallable(BytesOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.writeObject(String.class, symbol);
      out.writeObject(ExchangeEnum.class, exchange);
      out.writeObject(ContractTypeEnum.class, contractType);
      out.writeLong(datetime);
      out.writeObject(String.class, name);
      out.writeDouble(volume);
      out.writeDouble(openInterest);
      out.writeDouble(lastPrice);
      out.writeDouble(lastVolume);
      out.writeDouble(limitUp);
      out.writeDouble(limitDown);

      out.writeDouble(openPrice);
      out.writeDouble(highPrice);
      out.writeDouble(lowPrice);
      out.writeDouble(preClose);

      out.writeDouble(bidPrice1);
      out.writeDouble(bidPrice2);
      out.writeDouble(bidPrice3);
      out.writeDouble(bidPrice4);
      out.writeDouble(bidPrice5);

      out.writeDouble(askPrice1);
      out.writeDouble(askPrice2);
      out.writeDouble(askPrice3);
      out.writeDouble(askPrice4);
      out.writeDouble(askPrice5);

      out.writeDouble(bidVolume1);
      out.writeDouble(bidVolume2);
      out.writeDouble(bidVolume3);
      out.writeDouble(bidVolume4);
      out.writeDouble(bidVolume5);

      out.writeDouble(askVolume1);
      out.writeDouble(askVolume2);
      out.writeDouble(askVolume3);
      out.writeDouble(askVolume4);
      out.writeDouble(askVolume5);
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
        contractType = (ContractTypeEnum) in.readObject(ContractTypeEnum.class);
        datetime = in.readLong();
        name = (String) in.readObject(String.class);
        volume = in.readDouble();
        openInterest = in.readDouble();
        lastPrice = in.readDouble();
        lastVolume = in.readDouble();
        limitUp = in.readDouble();
        limitDown = in.readDouble();

        openPrice = in.readDouble();
        highPrice = in.readDouble();
        lowPrice = in.readDouble();
        preClose = in.readDouble();

        bidPrice1 = in.readDouble();
        bidPrice2 = in.readDouble();
        bidPrice3 = in.readDouble();
        bidPrice4 = in.readDouble();
        bidPrice5 = in.readDouble();

        askPrice1 = in.readDouble();
        askPrice2 = in.readDouble();
        askPrice3 = in.readDouble();
        askPrice4 = in.readDouble();
        askPrice5 = in.readDouble();

        bidVolume1 = in.readDouble();
        bidVolume2 = in.readDouble();
        bidVolume3 = in.readDouble();
        bidVolume4 = in.readDouble();
        bidVolume5 = in.readDouble();

        askVolume1 = in.readDouble();
        askVolume2 = in.readDouble();
        askVolume3 = in.readDouble();
        askVolume4 = in.readDouble();
        askVolume5 = in.readDouble();
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
      out.write("contractType").object(ContractTypeEnum.class, contractType);
      out.write("datetime").writeLong(datetime);
      out.write("name").object(String.class, name);
      out.write("volume").writeDouble(volume);

      out.write("openInterest").writeDouble(openInterest);
      out.write("lastPrice").writeDouble(lastPrice);
      out.write("lastVolume").writeDouble(lastVolume);
      out.write("limitUp").writeDouble(limitUp);
      out.write("limitDown").writeDouble(limitDown);

      out.write("openPrice").writeDouble(openPrice);
      out.write("highPrice").writeDouble(highPrice);
      out.write("lowPrice").writeDouble(lowPrice);
      out.write("preClose").writeDouble(preClose);

      out.write("bidPrice1").writeDouble(bidPrice1);
      out.write("bidPrice2").writeDouble(bidPrice2);
      out.write("bidPrice3").writeDouble(bidPrice3);
      out.write("bidPrice4").writeDouble(bidPrice4);
      out.write("bidPrice5").writeDouble(bidPrice5);

      out.write("askPrice1").writeDouble(askPrice1);
      out.write("askPrice2").writeDouble(askPrice2);
      out.write("askPrice3").writeDouble(askPrice3);
      out.write("askPrice4").writeDouble(askPrice4);
      out.write("askPrice5").writeDouble(askPrice5);

      out.write("bidVolume1").writeDouble(bidVolume1);
      out.write("bidVolume2").writeDouble(bidVolume2);
      out.write("bidVolume3").writeDouble(bidVolume3);
      out.write("bidVolume4").writeDouble(bidVolume4);
      out.write("bidVolume5").writeDouble(bidVolume5);

      out.write("askVolume1").writeDouble(askVolume1);
      out.write("askVolume2").writeDouble(askVolume2);
      out.write("askVolume3").writeDouble(askVolume3);
      out.write("askVolume4").writeDouble(askVolume4);
      out.write("askVolume5").writeDouble(askVolume5);
    }
  }

  @Override
  public void readMarshallable(WireIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      symbol = in.read("symbol").object(symbol, String.class);
      exchange = in.read("exchange").object(exchange, ExchangeEnum.class);
      contractType = in.read("contractType").object(contractType, ContractTypeEnum.class);
      datetime = in.read("datetime").readLong();
      name = in.read("name").object(name, String.class);
      volume = in.read("volume").readDouble();

      openInterest = in.read("openInterest").readDouble();
      lastPrice = in.read("lastPrice").readDouble();
      lastVolume = in.read("lastVolume").readDouble();
      limitUp = in.read("limitUp").readDouble();
      limitDown = in.read("limitDown").readDouble();

      openPrice = in.read("openPrice").readDouble();
      highPrice = in.read("highPrice").readDouble();
      lowPrice = in.read("lowPrice").readDouble();
      preClose = in.read("preClose").readDouble();

      bidPrice1 = in.read("bidPrice1").readDouble();
      bidPrice2 = in.read("bidPrice2").readDouble();
      bidPrice3 = in.read("bidPrice3").readDouble();
      bidPrice4 = in.read("bidPrice4").readDouble();
      bidPrice5 = in.read("bidPrice5").readDouble();

      askPrice1 = in.read("askPrice1").readDouble();
      askPrice2 = in.read("askPrice2").readDouble();
      askPrice3 = in.read("askPrice3").readDouble();
      askPrice4 = in.read("askPrice4").readDouble();
      askPrice5 = in.read("askPrice5").readDouble();

      bidVolume1 = in.read("bidVolume1").readDouble();
      bidVolume2 = in.read("bidVolume2").readDouble();
      bidVolume3 = in.read("bidVolume3").readDouble();
      bidVolume4 = in.read("bidVolume4").readDouble();
      bidVolume5 = in.read("bidVolume5").readDouble();

      askVolume1 = in.read("askVolume1").readDouble();
      askVolume2 = in.read("askVolume2").readDouble();
      askVolume3 = in.read("askVolume3").readDouble();
      askVolume4 = in.read("askVolume4").readDouble();
      askVolume5 = in.read("askVolume5").readDouble();
    }
  }
}
