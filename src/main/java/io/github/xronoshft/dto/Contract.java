package io.github.xronoshft.dto;

import io.github.xronoshft.constants.ContractStatusEnum;
import io.github.xronoshft.constants.ContractTypeEnum;
import io.github.xronoshft.constants.ExchangeEnum;
import io.github.xronoshft.constants.OptionTypeEnum;
import io.github.xronoshft.constants.ProductEnum;
import io.github.xronoshft.util.ToolUtil;
import net.openhft.chronicle.bytes.BytesIn;
import net.openhft.chronicle.bytes.BytesOut;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

public class Contract extends AbstractEvent<Contract> {
  private static final int MASHALLABLE_VERSION = 1;

  private String name = StringUtils.EMPTY; // ETH210611
  private ProductEnum product = ProductEnum.NONE; // SPOT, MARGIN
  private double size;
  private ContractStatusEnum status;
  private ContractTypeEnum contractType; //CW, NW, CQ, NQ
  private String deliveryDate;
  private double ctMult; // 合约乘数
  private String ctValCcy; // 合约面值计价币种
  private long settlementTime;
  private long deliveryTime;
  private double pricePrecision;
  private double amountPrecision;

  private double minOrderAmount = 1.0;           // minimum trading volume of the contract
  private double maxOrderAmount = Double.MAX_VALUE;
  private double minOrderValue = 1.0;
  private double maxOrderValue = Double.MAX_VALUE;
  private double limitOrderMinOrderAmount = 1.0;
  private double limitOrderMaxOrderAmount = Double.MAX_VALUE;
  private double sellMarketMinOrderAmount = 1.0;
  private double sellMarketMaxOrderAmount = Double.MAX_VALUE;
  private double buyMarketMaxOrderValue = Double.MAX_VALUE;
  private boolean stopSupported = false;    //whether server supports stop order
  private boolean netPosition = false;      // whether gateway uses net position volume
  private boolean historyData = false;      // whether gateway provides bar history data

  private double optionStrike = 0;
  private String optionUnderlying = StringUtils.EMPTY;          // xs_symbol of underlying contract
  private OptionTypeEnum optionType;
  private Date optionExpiry = new Date();

  public String symbol() {
    return symbol;
  }

  public Contract symbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  public ExchangeEnum exchange() {
    return exchange;
  }

  public Contract exchange(ExchangeEnum exchange) {
    this.exchange = exchange;
    return this;
  }

  public String name() {
    return name;
  }

  public Contract name(String name) {
    this.name = name;
    return this;
  }

  public ProductEnum product() {
    return product;
  }

  public Contract product(ProductEnum product) {
    this.product = product;
    return this;
  }

  public double size() {
    return size;
  }

  public Contract size(double size) {
    this.size = size;
    return this;
  }

  public double pricePrecision() {
    return pricePrecision;
  }

  public Contract pricePrecision(double pricePrecision) {
    this.pricePrecision = pricePrecision;
    return this;
  }

  public double amountPrecision() {
    return amountPrecision;
  }

  public Contract amountPrecision(double amountPrecision) {
    this.amountPrecision = amountPrecision;
    return this;
  }

  public double minOrderAmount() {
    return minOrderAmount;
  }

  public Contract minOrderAmount(double minOrderAmount) {
    this.minOrderAmount = minOrderAmount;
    return this;
  }

  public double maxOrderAmount() {
    return maxOrderAmount;
  }

  public Contract maxOrderAmount(double maxOrderAmount) {
    this.maxOrderAmount = maxOrderAmount;
    return this;
  }

  public double minOrderValue() {
    return minOrderValue;
  }

  public Contract minOrderValue(double minOrderValue) {
    this.minOrderValue = minOrderValue;
    return this;
  }

  public boolean stopSupported() {
    return stopSupported;
  }

  public Contract stopSupported(boolean stopSupported) {
    this.stopSupported = stopSupported;
    return this;
  }

  public boolean netPosition() {
    return netPosition;
  }

  public Contract netPosition(boolean netPosition) {
    this.netPosition = netPosition;
    return this;
  }

  public boolean historyData() {
    return historyData;
  }

  public Contract historyData(boolean historyData) {
    this.historyData = historyData;
    return this;
  }

  public double optionStrike() {
    return optionStrike;
  }

  public Contract optionStrike(double optionStrike) {
    this.optionStrike = optionStrike;
    return this;
  }

  public String optionUnderlying() {
    return optionUnderlying;
  }

  public Contract optionUnderlying(String optionUnderlying) {
    this.optionUnderlying = optionUnderlying;
    return this;
  }

  public OptionTypeEnum optionType() {
    return optionType;
  }

  public Contract optionType(OptionTypeEnum optionType) {
    this.optionType = optionType;
    return this;
  }

  public Date optionExpiry() {
    return optionExpiry;
  }

  public Contract optionExpiry(Date optionExpiry) {
    this.optionExpiry = optionExpiry;
    return this;
  }

  public double maxOrderValue() {
    return maxOrderValue;
  }

  public Contract maxOrderValue(double maxOrderValue) {
    this.maxOrderValue = maxOrderValue;
    return this;
  }

  public double limitOrderMinOrderAmount() {
    return limitOrderMinOrderAmount;
  }

  public Contract limitOrderMinOrderAmount(double limitOrderMinOrderAmount) {
    this.limitOrderMinOrderAmount = limitOrderMinOrderAmount;
    return this;
  }

  public double limitOrderMaxOrderAmount() {
    return limitOrderMaxOrderAmount;
  }

  public Contract limitOrderMaxOrderAmount(double limitOrderMaxOrderAmount) {
    this.limitOrderMaxOrderAmount = limitOrderMaxOrderAmount;
    return this;
  }

  public double sellMarketMinOrderAmount() {
    return sellMarketMinOrderAmount;
  }

  public Contract sellMarketMinOrderAmount(double sellMarketMinOrderAmount) {
    this.sellMarketMinOrderAmount = sellMarketMinOrderAmount;
    return this;
  }

  public double sellMarketMaxOrderAmount() {
    return sellMarketMaxOrderAmount;
  }

  public Contract sellMarketMaxOrderAmount(double sellMarketMaxOrderAmount) {
    this.sellMarketMaxOrderAmount = sellMarketMaxOrderAmount;
    return this;
  }

  public double buyMarketMaxOrderValue() {
    return buyMarketMaxOrderValue;
  }

  public Contract buyMarketMaxOrderValue(double buyMarketMaxOrderValue) {
    this.buyMarketMaxOrderValue = buyMarketMaxOrderValue;
    return this;
  }

  public ContractStatusEnum status() {
    return status;
  }

  public Contract status(ContractStatusEnum status) {
    this.status = status;
    return this;
  }

  public ContractTypeEnum contractType() {
    return contractType;
  }

  public Contract contractType(ContractTypeEnum contractType) {
    this.contractType = contractType;
    return this;
  }

  public String deliveryDate() {
    return deliveryDate;
  }

  public Contract deliveryDate(String deliveryDate) {
    this.deliveryDate = deliveryDate;
    return this;
  }

  public long deliveryTime() {
    return deliveryTime;
  }

  public Contract deliveryTime(long deliveryTime) {
    this.deliveryTime = deliveryTime;
    return this;
  }

  public long settlementTime() {
    return settlementTime;
  }

  public Contract settlementTime(long settlementTime) {
    this.settlementTime = settlementTime;
    return this;
  }

  public double ctMult() {
    return ctMult;
  }

  public Contract ctMult(double ctMult) {
    this.ctMult = ctMult;
    return this;
  }

  public String ctValCcy() {
    return ctValCcy;
  }

  public Contract ctValCcy(String ctValCcy) {
    this.ctValCcy = ctValCcy;
    return this;
  }

  public String xsSymbol() {
    return ToolUtil.getContractKey(symbol, exchange);
  }

  @Override
  public void writeMarshallable(BytesOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.writeObject(String.class, symbol);
      out.writeObject(String.class, name);
      out.writeObject(String.class, ctValCcy);
      out.writeDouble(ctMult);
      out.writeObject(ProductEnum.class, product);
      out.writeLong(deliveryTime);
      out.writeObject(ContractStatusEnum.class, status);
      out.writeObject(ContractTypeEnum.class, contractType);
      out.writeObject(String.class, deliveryDate);
      out.writeLong(settlementTime);
      out.writeDouble(size);
      out.writeDouble(pricePrecision);
      out.writeDouble(amountPrecision);
      out.writeDouble(minOrderAmount);
      out.writeDouble(maxOrderAmount);
      out.writeDouble(minOrderValue);
      out.writeDouble(maxOrderValue);
      out.writeDouble(limitOrderMinOrderAmount);
      out.writeDouble(limitOrderMaxOrderAmount);
      out.writeDouble(sellMarketMinOrderAmount);
      out.writeDouble(sellMarketMaxOrderAmount);
      out.writeDouble(buyMarketMaxOrderValue);
      out.writeBoolean(stopSupported);
      out.writeBoolean(netPosition);
      out.writeBoolean(historyData);
      out.writeDouble(optionStrike);
      out.writeObject(String.class, optionUnderlying);
      out.writeObject(OptionTypeEnum.class, optionType);
      out.writeObject(Date.class, optionExpiry);
    }
  }

  @Override
  public void readMarshallable(BytesIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      int version = (int) in.readStopBit();
      if (version == MASHALLABLE_VERSION) {
        symbol = (String) in.readObject(String.class);
        name = (String) in.readObject(String.class);
        product = (ProductEnum) in.readObject(ProductEnum.class);
        size = in.readDouble();
        ctMult = in.readDouble();
        ctValCcy =  (String) in.readObject(String.class);
        deliveryTime = in.readLong();
        status = (ContractStatusEnum) in.readObject(ContractStatusEnum.class);
        contractType = (ContractTypeEnum) in.readObject(ContractTypeEnum.class);
        deliveryDate = (String) in.readObject(String.class);
        settlementTime = in.readLong();
        pricePrecision = in.readFloat();
        amountPrecision = in.readFloat();
        minOrderAmount = in.readFloat();
        maxOrderAmount = in.readFloat();
        minOrderValue = in.readFloat();
        maxOrderValue = in.readDouble();
        limitOrderMinOrderAmount = in.readDouble();
        limitOrderMaxOrderAmount = in.readDouble();
        sellMarketMinOrderAmount = in.readDouble();
        sellMarketMaxOrderAmount = in.readDouble();
        buyMarketMaxOrderValue = in.readDouble();
        stopSupported = in.readBoolean();
        netPosition = in.readBoolean();
        historyData = in.readBoolean();
        optionStrike = in.readFloat();
        optionUnderlying = (String) in.readObject(String.class);
        optionType = (OptionTypeEnum) in.readObject(OptionTypeEnum.class);
        optionExpiry = (Date) in.readObject(Date.class);
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
      out.write("name").object(String.class, name);
      out.write("ctValCcy").object(String.class, ctValCcy);
      out.write("product").object(ProductEnum.class, product);
      out.write("size").writeDouble(size);
      out.write("ctMult").writeDouble(ctMult);
      out.write("deliveryTime").writeLong(deliveryTime);
      out.write("status").object(ContractStatusEnum.class, status);
      out.write("contractType").object(ContractTypeEnum.class, contractType);
      out.write("deliveryDate").object(String.class, deliveryDate);
      out.write("settlementTime").writeLong(settlementTime);
      out.write("pricePrecision").writeDouble(pricePrecision);
      out.write("amountPrecision").writeDouble(amountPrecision);
      out.write("minOrderAmount").writeDouble(minOrderAmount);
      out.write("maxOrderAmount").writeDouble(maxOrderAmount);
      out.write("minOrderValue").writeDouble(minOrderValue);
      out.write("maxOrderValue").writeDouble(maxOrderValue);
      out.write("limitOrderMinOrderAmount").writeDouble(limitOrderMinOrderAmount);
      out.write("limitOrderMaxOrderAmount").writeDouble(limitOrderMaxOrderAmount);
      out.write("sellMarketMinOrderAmount").writeDouble(sellMarketMinOrderAmount);
      out.write("sellMarketMaxOrderAmount").writeDouble(sellMarketMaxOrderAmount);
      out.write("buyMarketMaxOrderValue").writeDouble(buyMarketMaxOrderValue);
      out.write("stopSupported").writeBoolean(stopSupported);
      out.write("netPosition").writeBoolean(netPosition);
      out.write("historyData").writeBoolean(historyData);
      out.write("optionStrike").writeDouble(optionStrike);
      out.write("optionUnderlying").object(String.class, optionUnderlying);
      out.write("optionType").object(OptionTypeEnum.class, optionType);
      out.write("optionExpiry").object(Date.class, optionExpiry);
    }
  }

  @Override
  public void readMarshallable(WireIn in) {
    super.readMarshallable(in);
    if (PREGENERATED_MARSHALLABLE) {
      symbol = in.read("symbol").object(symbol, String.class);
      name = in.read("name").object(name, String.class);
      ctValCcy = in.read("ctValCcy").object(ctValCcy, String.class);
      product = in.read("product").object(product, ProductEnum.class);
      size = in.read("size").readDouble();
      ctMult = in.read("ctMult").readDouble();
      deliveryTime = in.read("deliveryTime").readLong();
      status = in.read("status").object(status, ContractStatusEnum.class);
      contractType = in.read("contractType").object(ContractTypeEnum.class);
      deliveryDate = in.read("deliveryDate").object(String.class);
      settlementTime = in.read("settlementTime").readLong();
      pricePrecision = in.read("pricePrecision").readDouble();
      amountPrecision = in.read("amountPrecision").readDouble();
      minOrderAmount = in.read("minOrderAmount").readDouble();
      maxOrderAmount = in.read("maxOrderAmount").readDouble();
      minOrderValue = in.read("minOrderValue").readDouble();
      maxOrderValue = in.read("maxOrderValue").readDouble();
      limitOrderMinOrderAmount = in.read("limitOrderMinOrderAmount").readDouble();
      limitOrderMaxOrderAmount = in.read("limitOrderMaxOrderAmount").readDouble();
      sellMarketMinOrderAmount = in.read("sellMarketMinOrderAmount").readDouble();
      sellMarketMaxOrderAmount = in.read("sellMarketMaxOrderAmount").readDouble();
      buyMarketMaxOrderValue = in.read("buyMarketMaxOrderValue").readDouble();
      stopSupported = in.read("stopSupported").readBoolean();
      netPosition = in.read("netPosition").readBoolean();
      historyData = in.read("historyData").readBoolean();
      optionStrike = in.read("optionStrike").readDouble();
      optionUnderlying = in.read("optionUnderlying").object(optionUnderlying, String.class);
      optionType = in.read("optionType").object(optionType, OptionTypeEnum.class);
      optionExpiry = in.read("optionExpiry").object(optionExpiry, Date.class);
    }
  }
}
