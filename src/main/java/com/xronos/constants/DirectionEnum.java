package com.xronos.constants;

/**
 * @author: Shawn
 * @Date: 10/16/2019
 * @Description:
 */
public enum DirectionEnum {
  NONE("NONE"),
  BUY("buy"),
  SELL("sell"),
  NET("净");

  String value;

  DirectionEnum(String value) {
    this.value = value;
  }
}
