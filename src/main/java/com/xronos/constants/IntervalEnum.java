package com.xronos.constants;

/**
 * IntervalEnum of bar data.
 */

public enum IntervalEnum {
  NONE("NONE"),
  RUNTIME("runtime"),
  MINUTE_1("1m"),
  MINUTE_5("5m"),
  MINUTE_15("15m"),
  MINUTE_30("30m"),
  HOUR("1h"),
  HOUR_4("4h"),
  DAILY("d"),
  WEEKLY("w"),
  MONTH("m");

  String value;

  IntervalEnum(String value) {
    this.value = value;
  }
}
