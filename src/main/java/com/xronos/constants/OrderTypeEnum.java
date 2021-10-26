package com.xronos.constants;


public enum OrderTypeEnum {

  NONE("NONE"),
  LIMIT("限价"),
  LIGHTNING("闪电下单"),
  MARKET("市价"),
  OPPONENT("opponent"),
  STOP("STOP"),
  FAK("FAK"),
  FOK("FOK"),
  BLP("BLP"),
  VWAP("VWAP"),
  TWAP("TWAP"),
  SOR("SOR");
  String value;

  OrderTypeEnum(String value) {
    this.value = value;
  }
}
