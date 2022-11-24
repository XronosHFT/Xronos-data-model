package io.github.xronoshft.dto.request;

import io.github.xronoshft.constants.ExchangeEnum;
import io.github.xronoshft.constants.IntervalEnum;
import io.github.xronoshft.dto.AbstractEvent;
import net.openhft.chronicle.bytes.BytesIn;
import net.openhft.chronicle.bytes.BytesOut;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;

import java.util.Date;

public class HistoryRequest extends AbstractEvent<HistoryRequest> {
  private static final int MASHALLABLE_VERSION = 1;

  private Date start;
  private Date end;
  private IntervalEnum interval = IntervalEnum.RUNTIME;

  public String symbol() {
    return symbol;
  }

  public HistoryRequest symbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  public ExchangeEnum exchange() {
    return exchange;
  }

  public HistoryRequest exchange(ExchangeEnum exchange) {
    this.exchange = exchange;
    return this;
  }

  public Date start() {
    return start;
  }

  public HistoryRequest start(Date start) {
    this.start = start;
    return this;
  }

  public Date end() {
    return end;
  }

  public HistoryRequest end(Date end) {
    this.end = end;
    return this;
  }

  public IntervalEnum interval() {
    return interval;
  }

  public HistoryRequest interval(IntervalEnum interval) {
    this.interval = interval;
    return this;
  }


  @Override
  public void writeMarshallable(BytesOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.writeObject(String.class, symbol);
      out.writeObject(ExchangeEnum.class, exchange);
      out.writeObject(Date.class, start);
      out.writeObject(Date.class, end);
      out.writeObject(IntervalEnum.class, interval);
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
        start = (Date) in.readObject(String.class);
        end = (Date) in.readObject(String.class);
        interval = (IntervalEnum) in.readObject(IntervalEnum.class);
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
      out.write("start").object(Date.class, start);
      out.write("end").object(Date.class, end);
      out.write("interval").object(IntervalEnum.class, interval);
    }
  }

  @Override
  public void readMarshallable(WireIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      symbol = in.read("symbol").object(symbol, String.class);
      exchange = in.read("exchange").object(exchange, ExchangeEnum.class);
      start = in.read("start").object(start, Date.class);
      end = in.read("end").object(end, Date.class);
      interval = in.read("interval").object(interval, IntervalEnum.class);
    }
  }
}
