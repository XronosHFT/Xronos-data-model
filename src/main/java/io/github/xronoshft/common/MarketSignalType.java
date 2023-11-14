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
    _3_D,
    _5_D,
    _7_D,
    _15_D,
    _30_D,
    ;

    public static String getName() {
      return CAPITAL_INFLOW.class.getSimpleName();
    }
  }
}
