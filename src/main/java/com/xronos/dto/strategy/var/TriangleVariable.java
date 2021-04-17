package com.xronos.dto.strategy.var;

import com.xronos.dto.AbstractEvent;
import com.xronos.dto.Balance;
import com.xronos.dto.Tick;
import com.xronos.dto.Trade;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;


public class TriangleVariable extends AbstractEvent<TriangleVariable> {

  private final Logger logger = LoggerFactory.getLogger(getClass());

  private final Map<String, Trade> tradeDataMap = new HashMap<>();
  private final Map<String, Tick> marketPriceTickMap = new HashMap<>();
  private final Map<String, Balance> accountDataMap = new HashMap<>();

  private AtomicReference<String> activeQwOrderId = new AtomicReference<>(StringUtils.EMPTY);

  private Map<String, Map<String, String>> triangleOrderTree = new HashMap<>();
  private final AtomicInteger orderIdAtomicCount = new AtomicInteger(0);

  private double marketBuySize = Double.MIN_NORMAL;
  private double marketSellSize = Double.MIN_NORMAL;

  private double posBuySize = Double.MIN_NORMAL;
  private double negBuySize = Double.MIN_NORMAL;

  private double posSellSize = Double.MIN_NORMAL;
  private double negSellSize = Double.MIN_NORMAL;

  private double posBuyHedgeAmount = Double.MIN_NORMAL;
  private double negBuyHedgeAmount = Double.MIN_NORMAL;

  private double posSellHedgeAmount = Double.MIN_NORMAL;
  private double negSellHedgeAmount = Double.MIN_NORMAL;

  public Map<String, Trade> tradeDataMap() {
    return tradeDataMap;
  }

  public Map<String, Tick> marketPriceTickMap() {
    return marketPriceTickMap;
  }

  public Map<String, Balance> accountDataMap() {
    return accountDataMap;
  }

  public String activeQwOrderId() {
    return activeQwOrderId.get();
  }

  public TriangleVariable activeQwOrderId(AtomicReference<String> activeQwOrderId) {
    this.activeQwOrderId = activeQwOrderId;
    return this;
  }

  public Map<String, Map<String, String>> triangleOrderTree() {
    return triangleOrderTree;
  }

  public TriangleVariable triangleOrderTree(Map<String, Map<String, String>> triangleOrderTree) {
    this.triangleOrderTree = triangleOrderTree;
    return this;
  }

  public double marketBuySize() {
    return marketBuySize;
  }

  public TriangleVariable marketBuySize(double marketBuySize) {
    this.marketBuySize = marketBuySize;
    return this;
  }

  public double marketSellSize() {
    return marketSellSize;
  }

  public TriangleVariable marketSellSize(double marketSellSize) {
    this.marketSellSize = marketSellSize;
    return this;
  }

  public double posBuySize() {
    return posBuySize;
  }

  public TriangleVariable posBuySize(double posBuySize) {
    this.posBuySize = posBuySize;
    return this;
  }

  public double negBuySize() {
    return negBuySize;
  }

  public TriangleVariable negBuySize(double negBuySize) {
    this.negBuySize = negBuySize;
    return this;
  }

  public double posSellSize() {
    return posSellSize;
  }

  public TriangleVariable posSellSize(double posSellSize) {
    this.posSellSize = posSellSize;
    return this;
  }

  public double negSellSize() {
    return negSellSize;
  }

  public TriangleVariable negSellSize(double negSellSize) {
    this.negSellSize = negSellSize;
    return this;
  }

  public double posBuyHedgeAmount() {
    return posBuyHedgeAmount;
  }

  public TriangleVariable posBuyHedgeAmount(double posBuyHedgeAmount) {
    this.posBuyHedgeAmount = posBuyHedgeAmount;
    return this;
  }

  public double negBuyHedgeAmount() {
    return negBuyHedgeAmount;
  }

  public TriangleVariable negBuyHedgeAmount(double negBuyHedgeAmount) {
    this.negBuyHedgeAmount = negBuyHedgeAmount;
    return this;
  }

  public double posSellHedgeAmount() {
    return posSellHedgeAmount;
  }

  public TriangleVariable posSellHedgeAmount(double posSellHedgeAmount) {
    this.posSellHedgeAmount = posSellHedgeAmount;
    return this;
  }

  public double negSellHedgeAmount() {
    return negSellHedgeAmount;
  }

  public TriangleVariable negSellHedgeAmount(double negSellHedgeAmount) {
    this.negSellHedgeAmount = negSellHedgeAmount;
    return this;
  }

  public void setActiveQwOrderId(String activeQwOrderId) {
    this.activeQwOrderId.set(activeQwOrderId);
  }

  public void resetActiveQwOrderId() {
    try {
      logger.warn("Reset stacktrace:{}", new Exception().getStackTrace());
    } catch (Exception e) {
      //
    }
    this.activeQwOrderId.set(StringUtils.EMPTY);
  }

  public int orderIdAtomicCount() {
    return orderIdAtomicCount.getAndIncrement();
  }

  public void resetOrderIdAtomicCount() {
    this.orderIdAtomicCount.set(0);
  }
}

