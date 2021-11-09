package com.xronos.constants;

/**
 * IntervalEnum of bar data.
 */

public enum IntervalEnum {
  NONE("NONE"),
  RUNTIME("runtime"),
  MINUTE_1("1m"),
  MINUTE_3("3m"),
  MINUTE_5("5m"),
  MINUTE_15("15m"),
  MINUTE_30("30m"),
  HOUR("1h"),
  HOUR_2("2h"),
  HOUR_4("4h"),
  HOUR_6("6h"),
  HOUR_12("12h"),
  DAILY("d"),
  WEEKLY("w"),
  MONTH("m"),
  YEAR("y");

  String value;

  IntervalEnum(String value) {
    this.value = value;
  }
}
