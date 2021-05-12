package com.xronos.dto.strategy.param;

import com.xronos.constants.ExchangeEnum;
import com.xronos.constants.StrategyTemplateEnum;
import com.xronos.dto.AbstractEvent;
import com.xronos.dto.Contract;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.TimeUnit;

public class TriangleParam extends AbstractEvent<TriangleParam> {

  protected ExchangeEnum exchangeEnum;

  protected boolean strategyRunningFlag = false;

  // 设定套利监控交易对
  private String baseCur = StringUtils.EMPTY;
  private String quoteCur = StringUtils.EMPTY;
  private String midCur = StringUtils.EMPTY;

  private double baseQuoteSlippage = 0.0001; // slip page
  private double baseMidSlippage = 0.0001;
  private double quoteMidSlippage = 0.0001;

  private double baseQuoteFee = 0.0001;  // fee
  private double baseMidFee = 0.0001;
  private double quoteMidFee = 0.0001;

  private double orderRatioBaseQuote = 0.5; //
  private double orderRatioBaseMid = 0.5; //

  // 设定市场初始 ------------现在没有接口，人工转币，保持套利市场平衡--------------
  // 设定账户最少预留数量,根据你自己的初始市场情况而定, 注意： 是数量而不是比例
  private double baseQuoteQuoteReserve = 0.0;
  private double baseQuoteBaseReserve = 0.0;
  private double quoteMidMidReserve = 0.0;
  private double quoteMidQuoteReserve = 0.0;
  private double baseMidBaseReserve = 0.0;
  private double baseMidMidReserve = 0.0;

  // 最小的交易单位设定
  private double minBaseQuoteTradingValue = 0.2;   // LTC/BTC交易对，设置为0.2, ETH/BTC交易对，设置为0.02
  private double minBaseMidTradingValue = 0.2;     // LTC/BTC交易对，设置为0.2, ETH/BTC交易对，设置为0.02
  private double minQuoteMidTradingValue = 0.2;    // LTC/BTC交易对，设置为0.2, ETH/BTC交易对，设置为0.02

  private double minBaseQuoteTradingAmount = 0.2;   // LTC/BTC交易对，设置为0.2, ETH/BTC交易对，设置为0.02
  private double minBaseMidTradingAmount = 0.2;     // LTC/BTC交易对，设置为0.2, ETH/BTC交易对，设置为0.02
  private double minQuoteMidTradingAmount = 0.2;    // LTC/BTC交易对，设置为0.2, ETH/BTC交易对，设置为0.02

  private int time = 50;             // 10ms
  private TimeUnit timeUnit;

  private String type;
  private String subType;

  public boolean isstrategyRunningFlag() {
    return strategyRunningFlag;
  }

  public TriangleParam strategyRunningFlag(boolean strategyRunningFlag) {
    this.strategyRunningFlag = strategyRunningFlag;
    return this;
  }

  public String baseCur() {
    return baseCur;
  }

  public TriangleParam baseCur(String baseCur) {
    this.baseCur = baseCur;
    return this;
  }

  public String quoteCur() {
    return quoteCur;
  }

  public TriangleParam quoteCur(String quoteCur) {
    this.quoteCur = quoteCur;
    return this;
  }

  public String midCur() {
    return midCur;
  }

  public TriangleParam midCur(String midCur) {
    this.midCur = midCur;
    return this;
  }

  public double baseQuoteSlippage() {
    return baseQuoteSlippage;
  }

  public TriangleParam baseQuoteSlippage(double baseQuoteSlippage) {
    this.baseQuoteSlippage = baseQuoteSlippage;
    return this;
  }

  public double baseMidSlippage() {
    return baseMidSlippage;
  }

  public TriangleParam baseMidSlippage(double baseMidSlippage) {
    this.baseMidSlippage = baseMidSlippage;
    return this;
  }

  public double quoteMidSlippage() {
    return quoteMidSlippage;
  }

  public TriangleParam quoteMidSlippage(double quoteMidSlippage) {
    this.quoteMidSlippage = quoteMidSlippage;
    return this;
  }

  public double baseQuoteFee() {
    return baseQuoteFee;
  }

  public TriangleParam baseQuoteFee(double baseQuoteFee) {
    this.baseQuoteFee = baseQuoteFee;
    return this;
  }

  public double baseMidFee() {
    return baseMidFee;
  }

  public TriangleParam baseMidFee(double baseMidFee) {
    this.baseMidFee = baseMidFee;
    return this;
  }

  public double quoteMidFee() {
    return quoteMidFee;
  }

  public TriangleParam quoteMidFee(double quoteMidFee) {
    this.quoteMidFee = quoteMidFee;
    return this;
  }

  public double orderRatioBaseQuote() {
    return orderRatioBaseQuote;
  }

  public TriangleParam orderRatioBaseQuote(double orderRatioBaseQuote) {
    this.orderRatioBaseQuote = orderRatioBaseQuote;
    return this;
  }

  public double orderRatioBaseMid() {
    return orderRatioBaseMid;
  }

  public TriangleParam orderRatioBaseMid(double orderRatioBaseMid) {
    this.orderRatioBaseMid = orderRatioBaseMid;
    return this;
  }

  public double baseQuoteQuoteReserve() {
    return baseQuoteQuoteReserve;
  }

  public TriangleParam baseQuoteQuoteReserve(double baseQuoteQuoteReserve) {
    this.baseQuoteQuoteReserve = baseQuoteQuoteReserve;
    return this;
  }

  public double baseQuoteBaseReserve() {
    return baseQuoteBaseReserve;
  }

  public TriangleParam baseQuoteBaseReserve(double baseQuoteBaseReserve) {
    this.baseQuoteBaseReserve = baseQuoteBaseReserve;
    return this;
  }

  public double quoteMidMidReserve() {
    return quoteMidMidReserve;
  }

  public TriangleParam quoteMidMidReserve(double quoteMidMidReserve) {
    this.quoteMidMidReserve = quoteMidMidReserve;
    return this;
  }

  public double quoteMidQuoteReserve() {
    return quoteMidQuoteReserve;
  }

  public TriangleParam quoteMidQuoteReserve(double quoteMidQuoteReserve) {
    this.quoteMidQuoteReserve = quoteMidQuoteReserve;
    return this;
  }

  public double baseMidBaseReserve() {
    return baseMidBaseReserve;
  }

  public TriangleParam baseMidBaseReserve(double baseMidBaseReserve) {
    this.baseMidBaseReserve = baseMidBaseReserve;
    return this;
  }

  public double baseMidMidReserve() {
    return baseMidMidReserve;
  }

  public TriangleParam baseMidMidReserve(double baseMidMidReserve) {
    this.baseMidMidReserve = baseMidMidReserve;
    return this;
  }

  public TriangleParam minBaseQuoteTradingValue(double minBaseQuoteTradingValue) {
    this.minBaseQuoteTradingValue = minBaseQuoteTradingValue;
    return this;
  }

  public TriangleParam minBaseMidTradingValue(double minBaseMidTradingValue) {
    this.minBaseMidTradingValue = minBaseMidTradingValue;
    return this;
  }

  public TriangleParam minQuoteMidTradingValue(double minQuoteMidTradingValue) {
    this.minQuoteMidTradingValue = minQuoteMidTradingValue;
    return this;
  }

  public TriangleParam minBaseQuoteTradingAmount(double minBaseQuoteTradingAmount) {
    this.minBaseQuoteTradingAmount = minBaseQuoteTradingAmount;
    return this;
  }

  public TriangleParam minBaseMidTradingAmount(double minBaseMidTradingAmount) {
    this.minBaseMidTradingAmount = minBaseMidTradingAmount;
    return this;
  }

  public TriangleParam minQuoteMidTradingAmount(double minQuoteMidTradingAmount) {
    this.minQuoteMidTradingAmount = minQuoteMidTradingAmount;
    return this;
  }

  public double minBaseQuoteTradingValue() {
    Contract contract = getContract(baseQuoteQwSymbol());
    if (contract != null) {
      double minTradeUnit = contract.minOrderValue();
      if (minTradeUnit > 0) {
        minBaseQuoteTradingValue = minTradeUnit;
      }
    }
    return minBaseQuoteTradingValue;
  }

  public void setMinBaseQuoteTradingValue(double minBaseQuoteTradingValue) {
    this.minBaseQuoteTradingValue = minBaseQuoteTradingValue;
  }

  public StrategyTemplateEnum getStrategyTemplateName() {
    return StrategyTemplateEnum.TRIANGLE;
  }

  public String baseQuoteQwSymbol() {
    if (StringUtils.isNotBlank(baseCur()) && StringUtils.isNotBlank(quoteCur())) {
      return (baseCur() + quoteCur() + getSuffix()).toLowerCase();
    }
    return StringUtils.EMPTY;
  }


  public String baseMidQwSymbol() {
    if (StringUtils.isNotBlank(baseCur()) && StringUtils.isNotBlank(midCur())) {
      return (baseCur() + midCur() + getSuffix()).toLowerCase();
    }
    return StringUtils.EMPTY;
  }

  public String quoteMidQwSymbol() {
    if (StringUtils.isNotBlank(quoteCur()) && StringUtils.isNotBlank(midCur())) {
      return (quoteCur() + midCur() + getSuffix()).toLowerCase();
    }
    return StringUtils.EMPTY;
  }

  public String baseCurQwSymbol() {
    if (StringUtils.isNotBlank(baseCur())) {
      return (baseCur() + getSuffix()).toLowerCase();
    }
    return StringUtils.EMPTY;
  }

  public String midCurQwSymbol() {
    if (StringUtils.isNotBlank(midCur())) {
      return (midCur() + getSuffix()).toLowerCase();
    }
    return StringUtils.EMPTY;
  }

  public String quoteCurQwSymbol() {
    if (StringUtils.isNotBlank(quoteCur())) {
      return (quoteCur() + getSuffix()).toLowerCase();
    }
    return StringUtils.EMPTY;
  }

  private String getSuffix() {
    return "." + exchange().name().toLowerCase();
  }

  public double minBaseMidTradingValue() {
    Contract contract = getContract(baseMidQwSymbol());
    if (contract != null) {
      double minTradeUnit = contract.minOrderValue();
      if (minTradeUnit > 0) {
        minBaseMidTradingValue = minTradeUnit;
      }
    }
    return minBaseMidTradingValue;
  }

  public void setMinBaseMidTradingValue(double minBaseMidTradingValue) {
    this.minBaseMidTradingValue = minBaseMidTradingValue;
  }

  public double minQuoteMidTradingValue() {
    Contract contract = getContract(quoteMidQwSymbol());
    if (contract != null) {
      double minTradeUnit = contract.minOrderValue();
      if (minTradeUnit > 0) {
        minQuoteMidTradingValue = minTradeUnit;
      }
    }
    return minQuoteMidTradingValue;
  }

  public double minSellUnit(String curPair) {
    if (curPair == null) {
      return 0.0;
    }
    if (curPair.equals(baseQuoteQwSymbol())) {
      return minBaseQuoteTradingValue();
    } else if (curPair.equals(baseMidQwSymbol())) {
      return minBaseMidTradingValue();
    } else if (curPair.equals(quoteMidQwSymbol())) {
      return minQuoteMidTradingValue();
    } else {
      return 0.0;
    }
  }

  public double minBuyUnit(String curPair) {
    if (curPair == null) {
      return 0.0;
    }
    if (curPair.equals(baseQuoteQwSymbol())) {
      return minBaseQuoteTradingAmount();
    } else if (curPair.equals(baseMidQwSymbol())) {
      return minBaseMidTradingAmount();
    } else if (curPair.equals(quoteMidQwSymbol())) {
      return minQuoteMidTradingAmount();
    } else {
      return 0.0;
    }
  }

  public double minBaseQuoteTradingAmount() {
    Contract contract = getContract(baseQuoteQwSymbol());
    if (contract != null) {
      double minTradeUnit = contract.minOrderAmount();
      if (minTradeUnit > 0) {
        minBaseQuoteTradingAmount = minTradeUnit;
      }
    }
    return minBaseQuoteTradingAmount;
  }

  public double minBaseMidTradingAmount() {
    Contract contract = getContract(baseMidQwSymbol());
    if (contract != null) {
      double minTradeUnit = contract.minOrderAmount();
      if (minTradeUnit > 0) {
        minBaseMidTradingAmount = minTradeUnit;
      }
    }
    return minBaseMidTradingAmount;
  }

  public double minQuoteMidTradingAmount() {
    Contract contract = getContract(quoteMidQwSymbol());
    if (contract != null) {
      double minTradeUnit = contract.minOrderAmount();
      if (minTradeUnit > 0) {
        minQuoteMidTradingAmount = minTradeUnit;
      }
    }
    return minQuoteMidTradingAmount;
  }

  private Contract getContract(String quoteMidQwSymbol) {
    //TODO tobe enhance
    return null;
  }

  public TimeUnit timeUnit() {
    return timeUnit;
  }

  public TriangleParam timeUnit(TimeUnit timeUnit) {
    this.timeUnit = timeUnit;
    return this;
  }

  public boolean strategyRunningFlag() {
    return strategyRunningFlag;
  }

  public int time() {
    return time;
  }

  public TriangleParam time(int time) {
    this.time = time;
    return this;
  }

  public String type() {
    return type;
  }

  public TriangleParam type(String type) {
    this.type = type;
    return this;
  }

  public ExchangeEnum exchange() {
    return exchange;
  }

  public TriangleParam exchange(ExchangeEnum exchangeEnum) {
    this.exchange = exchangeEnum;
    return this;
  }

  public String subType() {
    return subType;
  }

  public TriangleParam subType(String subType) {
    this.subType = subType;
    return this;
  }
}