package io.github.xronoshft.dto;


import io.github.xronoshft.constants.ContractTypeEnum;
import io.github.xronoshft.constants.DirectionEnum;
import io.github.xronoshft.constants.ExchangeEnum;
import io.github.xronoshft.constants.LeverRateEnum;
import io.github.xronoshft.util.ToolUtil;
import net.openhft.chronicle.bytes.BytesIn;
import net.openhft.chronicle.bytes.BytesOut;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;
import org.apache.commons.lang3.StringUtils;

public class Position extends AbstractEvent<Position> {
  private static final int MASHALLABLE_VERSION = 1;

  private DirectionEnum direction = DirectionEnum.NONE;
  private LeverRateEnum leverRate;
  private ContractTypeEnum contractType;
  private String accountId = StringUtils.EMPTY;

  private double volume;
  private double frozenVol;
  private double availableVol;
  private double price;
  private double pnl;
  private double pnlRatio;
  private double xsVolume;

  public String symbol() {
    return symbol;
  }

  public Position symbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  public ExchangeEnum exchange() {
    return exchange;
  }

  public Position exchange(ExchangeEnum exchange) {
    this.exchange = exchange;
    return this;
  }

  public DirectionEnum direction() {
    return direction;
  }

  public Position direction(DirectionEnum direction) {
    this.direction = direction;
    return this;
  }

  public double volume() {
    return volume;
  }

  public Position volume(double volume) {
    this.volume = volume;
    return this;
  }

  public double frozenVol() {
    return frozenVol;
  }

  public Position frozenVol(double frozen) {
    this.frozenVol = frozen;
    return this;
  }

  public double price() {
    return price;
  }

  public Position price(double price) {
    this.price = price;
    return this;
  }

  public double pnl() {
    return pnl;
  }

  public Position pnl(double pnl) {
    this.pnl = pnl;
    return this;
  }

  public double xsVolume() {
    return xsVolume;
  }

  public Position xsVolume(double xsVolume) {
    this.xsVolume = xsVolume;
    return this;
  }

  public double pnlRatio() {
    return pnlRatio;
  }

  public Position pnlRatio(double pnlRatio) {
    this.pnlRatio = pnlRatio;
    return this;
  }

  public LeverRateEnum leverRate() {
    return leverRate;
  }

  public Position leverRate(LeverRateEnum leverRate) {
    this.leverRate = leverRate;
    return this;
  }

  public ContractTypeEnum contractType() {
    return contractType;
  }

  public Position contractType(ContractTypeEnum contractType) {
    this.contractType = contractType;
    return this;
  }

  public double availableVol() {
    return availableVol;
  }

  public Position availableVol(double availableVol) {
    this.availableVol = availableVol;
    return this;
  }

  public String accountId() {
    return accountId;
  }

  public Position accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  @Override
  public String xsSymbol() {
    return ToolUtil.getPositionKey(symbol, exchange, direction, contractType, accountId);
  }

  @Override
  public void writeMarshallable(BytesOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.writeObject(String.class, symbol);
      out.writeObject(String.class, accountId);
      out.writeObject(ExchangeEnum.class, exchange);
      out.writeObject(DirectionEnum.class, direction);
      out.writeObject(ContractTypeEnum.class, contractType);
      out.writeDouble(volume);
      out.writeDouble(frozenVol);
      out.writeDouble(availableVol);
      out.writeDouble(price);
      out.writeDouble(pnl);
      out.writeDouble(pnlRatio);
      out.writeObject(LeverRateEnum.class, leverRate);
      out.writeDouble(xsVolume);
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
        exchange = (ExchangeEnum) in.readObject(ExchangeEnum.class);
        direction = (DirectionEnum) in.readObject(DirectionEnum.class);
        contractType = (ContractTypeEnum) in.readObject(ContractTypeEnum.class);
        volume = in.readDouble();
        frozenVol = in.readDouble();
        availableVol = in.readDouble();
        price = in.readDouble();
        pnl = in.readDouble();
        pnlRatio = in.readDouble();
        leverRate = (LeverRateEnum) in.readObject(LeverRateEnum.class);
        xsVolume = in.readDouble();
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
      out.write("exchange").object(ExchangeEnum.class, exchange);
      out.write("direction").object(DirectionEnum.class, direction);
      out.write("contractType").object(ContractTypeEnum.class, contractType);
      out.write("volume").writeDouble(volume);
      out.write("frozenVol").writeDouble(frozenVol);
      out.write("availableVol").writeDouble(availableVol);
      out.write("price").writeDouble(price);
      out.write("pnl").writeDouble(pnl);
      out.write("pnlRatio").writeDouble(pnlRatio);
      out.write("leverRate").object(LeverRateEnum.class, leverRate);
      out.write("xsVolume").writeDouble(xsVolume);
    }
  }

  @Override
  public void readMarshallable(WireIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      symbol = in.read("symbol").object(symbol, String.class);
      accountId = in.read("accountId").object(accountId, String.class);
      exchange = in.read("exchange").object(exchange, ExchangeEnum.class);
      direction = in.read("direction").object(direction, DirectionEnum.class);
      contractType = in.read("contractType").object(contractType, ContractTypeEnum.class);
      volume = in.read("volume").readDouble();
      frozenVol = in.read("frozenVol").readDouble();
      availableVol = in.read("availableVol").readDouble();
      price = in.read("price").readDouble();
      pnl = in.read("pnl").readDouble();
      pnlRatio = in.read("pnlRatio").readDouble();
      leverRate = in.read("leverRate").object(leverRate, LeverRateEnum.class);
      xsVolume = in.read("xsVolume").readDouble();
    }
  }
}
