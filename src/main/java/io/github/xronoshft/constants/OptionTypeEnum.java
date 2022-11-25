package io.github.xronoshft.constants;

/**
 * @author Shawn
 * 
 * 
 */
public enum OptionTypeEnum {
  NONE("NONE"),
  CALL("看涨期权"),
  PUT("看跌期权");
  String value;

  OptionTypeEnum(String value) {
    this.value = value;
  }
}
