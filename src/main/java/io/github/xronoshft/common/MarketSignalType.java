package io.github.xronoshft.common;

import lombok.Getter;

public interface MarketSignalType {

  @Getter
  enum CAPITAL_INFLOW {
    _1_SEC(1, "S"),
    _10_SEC(10, "S"),
    _1_MIN(1, "M"),
    _15_MIN(15, "M"),
    _30_MIN(30, "M"),
    _1_H(1, "H"),
    _4_H(4, "H"),
    _8_H(8, "H"),
    _12_H(12, "H"),
    _24_H(24, "H"),
    _3_D(3, "D"),
    _5_D(5, "D"),
    _7_D(7, "D"),
    _15_D(15, "D"),
    _30_D(30, "D"),
    _60_D(60, "D"),
    _120_D(120, "D"),
    _180_D(180, "D"),
    ;

    private final int num;

    private final String unit;

    CAPITAL_INFLOW(int num, String unit) {
      this.num = num;
      this.unit = unit;
    }

    public static String getName() {
      return CAPITAL_INFLOW.class.getSimpleName();
    }
    public String getSignalTypeName() {
      return getName() + this.name();
    }

    public static CAPITAL_INFLOW getSignalType(String signalTypeName) {
      for (CAPITAL_INFLOW value : values()) {
        String name = value.name();
        if (name.equals(signalTypeName)) {
          return value;
        }
      }
      throw new RuntimeException("not signal type matched");
    }
  }

  public static void main(String[] args) {
    String signalTypeName = CAPITAL_INFLOW._15_MIN.getSignalTypeName();
    System.out.println(signalTypeName);
  }
}
