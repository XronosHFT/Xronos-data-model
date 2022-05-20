package com.xronos.constants;

public enum TimerTypeEnum {

  _1_SEC("1"),
  _10_SEC("10"),
  _1_MIN("60"),
  _15_MIN("900"),
  _30_MIN("1800"),
  _60_MIN("3600"),
  _240_MIN("14400");

  private final String secs;

  TimerTypeEnum(String secs) {
    this.secs = secs;
  }

  public String getValue() {
    return secs;
  }
}
