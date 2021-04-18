package com.xronos.dto.strategy.var;

import com.xronos.dto.AbstractEvent;


public class TriangleVariable extends AbstractEvent<TriangleVariable> {


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
}

