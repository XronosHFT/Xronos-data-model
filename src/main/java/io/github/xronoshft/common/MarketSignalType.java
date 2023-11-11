package io.github.xronoshft.common;

public interface MarketSignalType {
  enum CAPITAL_INFLOW {
    _1_SEC,
    _10_SEC,
    _1_MIN,
    _15_MIN,
    _30_MIN,
    _1_H,
    _4_H,
    _8_H,
    _12_H,
    _24_H,
    ;

    public static String getName() {
      return CAPITAL_INFLOW.class.getSimpleName();
    }
  }
}
