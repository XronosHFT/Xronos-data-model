package io.github.xronoshft.constants;

/**
 * @author Shawn
 * 
 * 
 */
public enum CurrencyEnum {
  USD("USD"),
  HKD("HKD"),
  CNY("CNY");

  String value;

  CurrencyEnum(String value) {
    this.value = value;
  }
}
