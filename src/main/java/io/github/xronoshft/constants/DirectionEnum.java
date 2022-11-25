package io.github.xronoshft.constants;

/**
 * @author Shawn
 */
public enum DirectionEnum {
  NONE("NONE"),
  BUY("buy"), // 多
  SELL("sell"), // 空
  NET("net"); // 净

  String value;

  DirectionEnum(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }
}
