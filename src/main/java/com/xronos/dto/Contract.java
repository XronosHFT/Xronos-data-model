package com.xronos.dto;

import com.xronos.constants.ExchangeEnum;
import com.xronos.constants.OptionTypeEnum;
import com.xronos.constants.ProductEnum;
import net.openhft.chronicle.bytes.BytesIn;
import net.openhft.chronicle.bytes.BytesOut;
import net.openhft.chronicle.wire.WireIn;
import net.openhft.chronicle.wire.WireOut;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

public class Contract extends AbstractEvent<Contract> {
  private static final int MASHALLABLE_VERSION = 1;

  private String name = StringUtils.EMPTY;
  private ProductEnum product = ProductEnum.NONE;
  private int size;
  private float pricePrecision;
  private float amountPrecision;

  private float minOrderAmount = 1.0f;           // minimum trading volume of the contract
  private float maxOrderAmount = Float.MAX_VALUE;
  private float minOrderValue = 1.0f;
  private boolean stopSupported = false;    //whether server supports stop order
  private boolean netPosition = false;      // whether gateway uses net position volume
  private boolean historyData = false;      // whether gateway provides bar history data

  private float optionStrike = 0;
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

  public int size() {
    return size;
  }

  public Contract size(int size) {
    this.size = size;
    return this;
  }

  public float pricePrecision() {
    return pricePrecision;
  }

  public Contract pricePrecision(float pricePrecision) {
    this.pricePrecision = pricePrecision;
    return this;
  }

  public float amountPrecision() {
    return amountPrecision;
  }

  public Contract amountPrecision(float amountPrecision) {
    this.amountPrecision = amountPrecision;
    return this;
  }

  public float minOrderAmount() {
    return minOrderAmount;
  }

  public Contract minOrderAmount(float minOrderAmount) {
    this.minOrderAmount = minOrderAmount;
    return this;
  }

  public float maxOrderAmount() {
    return maxOrderAmount;
  }

  public Contract maxOrderAmount(float maxOrderAmount) {
    this.maxOrderAmount = maxOrderAmount;
    return this;
  }

  public float minOrderValue() {
    return minOrderValue;
  }

  public Contract minOrderValue(float minOrderValue) {
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

  public float optionStrike() {
    return optionStrike;
  }

  public Contract optionStrike(float optionStrike) {
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


  @Override
  public void writeMarshallable(BytesOut out) {
    super.writeMarshallable(out);
    if (PREGENERATED_MARSHALLABLE) {
      out.writeObject(String.class, symbol);
      out.writeObject(String.class, name);
      out.writeObject(ProductEnum.class, product);
      out.writeInt(size);
      out.writeFloat(pricePrecision);
      out.writeFloat(amountPrecision);
      out.writeFloat(minOrderAmount);
      out.writeFloat(maxOrderAmount);
      out.writeFloat(minOrderValue);
      out.writeBoolean(stopSupported);
      out.writeBoolean(netPosition);
      out.writeBoolean(historyData);
      out.writeFloat(optionStrike);
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
        size = in.readInt();
        pricePrecision = in.readFloat();
        amountPrecision = in.readFloat();
        minOrderAmount = in.readFloat();
        maxOrderAmount = in.readFloat();
        minOrderValue = in.readFloat();
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
      out.write("product").object(ProductEnum.class, product);
      out.write("size").writeInt(size);
      out.write("pricePrecision").writeFloat(pricePrecision);
      out.write("amountPrecision").writeFloat(amountPrecision);
      out.write("minOrderAmount").writeFloat(minOrderAmount);
      out.write("maxOrderAmount").writeFloat(maxOrderAmount);
      out.write("minOrderValue").writeFloat(minOrderValue);
      out.write("stopSupported").writeBoolean(stopSupported);
      out.write("netPosition").writeBoolean(netPosition);
      out.write("historyData").writeBoolean(historyData);
      out.write("optionStrike").writeFloat(optionStrike);
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
      product = in.read("product").object(product, ProductEnum.class);
      size = in.read("size").readInt();
      pricePrecision = in.read("pricePrecision").readFloat();
      amountPrecision = in.read("amountPrecision").readFloat();
      minOrderAmount = in.read("minOrderAmount").readFloat();
      maxOrderAmount = in.read("maxOrderAmount").readFloat();
      minOrderValue = in.read("minOrderValue").readFloat();
      stopSupported = in.read("stopSupported").readBoolean();
      netPosition = in.read("netPosition").readBoolean();
      historyData = in.read("historyData").readBoolean();
      optionStrike = in.read("optionStrike").readFloat();
      optionUnderlying = in.read("optionUnderlying").object(optionUnderlying, String.class);
      optionType = in.read("optionType").object(optionType, OptionTypeEnum.class);
      optionExpiry = in.read("optionExpiry").object(optionExpiry, Date.class);
    }
  }
}
