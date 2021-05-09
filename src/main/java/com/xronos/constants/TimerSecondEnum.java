package com.xronos.constants;

public enum TimerSecondEnum {

  ONE_SEC("1"),
  TEN_SEC("10");

  private final String secs;

  TimerSecondEnum(String secs) {
    this.secs = secs;
  }

  private String getValue() {
    return secs;
  }
}
