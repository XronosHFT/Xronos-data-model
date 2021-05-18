package com.xronos.dto.strategy.param;

import com.xronos.constants.ExchangeEnum;
import com.xronos.constants.StrategyTemplateEnum;
import net.openhft.chronicle.wire.SelfDescribingMarshallable;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.TimeUnit;

public class CalendarSpreadArbitrageParam extends SelfDescribingMarshallable {

  protected ExchangeEnum exchangeEnum;

  protected boolean strategyRunningFlag = false;

  // 设定套利监控交易对
  private String currentContract = StringUtils.EMPTY;
  private String nextContract = StringUtils.EMPTY;

  private double orderRatioBaseQuote = 0.5; //
  private double orderRatioBaseMid = 0.5; //

  private int time = 50;             // 10ms
  private TimeUnit timeUnit;

  private String type;
  private String subType;
  private ExchangeEnum exchange;

  public String currentContract() {
    return currentContract;
  }

  public CalendarSpreadArbitrageParam currentContract(String baseCur) {
    this.currentContract = baseCur;
    return this;
  }

  public String nextContract() {
    return nextContract;
  }

  public CalendarSpreadArbitrageParam nextContract(String quoteCur) {
    this.nextContract = quoteCur;
    return this;
  }

  public double orderRatioBaseQuote() {
    return orderRatioBaseQuote;
  }

  public CalendarSpreadArbitrageParam orderRatioBaseQuote(double orderRatioBaseQuote) {
    this.orderRatioBaseQuote = orderRatioBaseQuote;
    return this;
  }

  public double orderRatioBaseMid() {
    return orderRatioBaseMid;
  }

  public CalendarSpreadArbitrageParam orderRatioBaseMid(double orderRatioBaseMid) {
    this.orderRatioBaseMid = orderRatioBaseMid;
    return this;
  }

  public StrategyTemplateEnum getStrategyTemplateName() {
    return StrategyTemplateEnum.TRIANGLE;
  }

  public String currentContractXsSymbol() {
    if (StringUtils.isNotBlank(currentContract)) {
      return (currentContract + getSuffix()).toLowerCase();
    }
    return StringUtils.EMPTY;
  }

  public String nextContractXsSymbol() {
    if (StringUtils.isNotBlank(nextContract)) {
      return (nextContract + getSuffix()).toLowerCase();
    }
    return StringUtils.EMPTY;
  }

  private String getSuffix() {
    return "." + exchange().name().toLowerCase();
  }

  public TimeUnit timeUnit() {
    return timeUnit;
  }

  public CalendarSpreadArbitrageParam timeUnit(TimeUnit timeUnit) {
    this.timeUnit = timeUnit;
    return this;
  }

  public boolean strategyRunningFlag() {
    return strategyRunningFlag;
  }

  public int time() {
    return time;
  }

  public CalendarSpreadArbitrageParam time(int time) {
    this.time = time;
    return this;
  }

  public String type() {
    return type;
  }

  public CalendarSpreadArbitrageParam type(String type) {
    this.type = type;
    return this;
  }

  public ExchangeEnum exchange() {
    return exchange;
  }

  public CalendarSpreadArbitrageParam exchange(ExchangeEnum exchangeEnum) {
    this.exchange = exchangeEnum;
    return this;
  }

  public String subType() {
    return subType;
  }

  public CalendarSpreadArbitrageParam subType(String subType) {
    this.subType = subType;
    return this;
  }
}