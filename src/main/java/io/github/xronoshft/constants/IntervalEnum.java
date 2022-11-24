package io.github.xronoshft.constants;

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
  DAILY_2("d"),
  DAILY_3("d"),
  DAILY_5("d"),
  WEEKLY("w"),
  MONTH("m"),
  MONTH_3("3m"),
  MONTH_6("6m"),
  YEAR("y");

  String value;

  IntervalEnum(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }
}
