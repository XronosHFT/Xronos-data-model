package io.github.xronoshft.constants;

/**
 * @author Shawn
 * 
 * 
 */
public enum OffsetEnum {
  NONE("NONE"),
  OPEN("开"),
  CLOSE("平"),
  CLOSETODAY("平今"),
  CLOSEYESTERDAY("平昨");
  String value;

  OffsetEnum(String value) {
    this.value = value;
  }
}
