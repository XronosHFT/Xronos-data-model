package com.xronos.constants;

public enum LongOrShortEnum {
  LONG("long"),
  SHORT("short");

  private final String code;

  LongOrShortEnum(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }
}
