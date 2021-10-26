package com.xronos.constants;

/**
 * @author: Shawn
 * @Date: 10/17/2019
 * @Description:
 */
public enum ProductEnum {
  NONE("NONE"),
  EQUITY("股票"),
  FUTURES("期货"),
  OPTION("期权"),
  INDEX("指数"),
  FOREX("外汇"),
  SPOT("现货"),
  MARGIN("逐仓杠杆"),
  SUPER_MARGIN("全仓杠杆"),
  OTC("otc"),
  POINT("点卡"),
  ETF("ETF"),
  BOND("债券"),
  WARRANT("权证"),
  SPREAD("价差"),
  FUND("基金");

  String value;

  ProductEnum(String value) {
    this.value = value;
  }

  /**
   * 根据enum值解析
   */
  public static ProductEnum parseValue(String productValue) {
    try {
      for (ProductEnum value : ProductEnum.values()) {
        if (value.value.equals(productValue)) {
          return value;
        }
      }
    } catch (Exception ignored) {
    }
    return null;
  }

  /**
   * 根绝enum名解析
   */
  public static ProductEnum parseName(String productName) {
    try {
      return ProductEnum.valueOf(productName.toLowerCase());
    } catch (Exception e) {
      //
    }
    return null;
  }
}
