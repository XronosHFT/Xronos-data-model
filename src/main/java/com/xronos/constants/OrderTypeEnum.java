package com.xronos.constants;


public enum OrderTypeEnum {

  NONE("NONE"),
  LIMIT("限价"),
  LIGHTNING("闪电下单"),
  MARKET("市价"),
  OPPONENT("对手价"),
  STOP("stop"),
  FAK("fak"),
  FOK("fok"), // 全部成交或立即取消单
  BLP("blp"),
  VWAP("vwap"),
  TWAP("twap"),
  POST_ONLY("post_only"), // 只做maker单
  IOC("ioc"), // 立即成交并取消剩余单
  SOR("sor"),
  OPTIMAL_LIMIT_IOC("optimal_limit_ioc"); // 市价委托立即成交并取消剩余（仅适用交割、永续）
  String value;

  OrderTypeEnum(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }
}
