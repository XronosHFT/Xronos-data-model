package io.github.xronoshft.constants;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum StatusEnum {

  NONE("NONE"),
  SUBMITTING("提交中"),      // active
  SUBMITTED("已提交"),      // active
  NOT_TRADED("未成交"),       // active
  PARTIAL_TRADED("部分成交"),    // active
  CANCELLING("撤单中"),      // active
  ALL_TRADED("全部成交"),
  PARTIAL_CANCELED("部分撤单"),   // active
  CANCELED("已撤销"),
  REJECTED("拒单"),
  CLOSED("订单关闭");
  String value;

  StatusEnum(String value) {
    this.value = value;
  }

  private static Map<String, StatusEnum> initMap = new HashMap<>();

  static {
    for (StatusEnum value : StatusEnum.values()) {
      initMap.put(value.name(), value);
    }
  }

  public static boolean isActive(StatusEnum status) {
    return SUBMITTING.equals(status) || SUBMITTED.equals(status) || NOT_TRADED.equals(status)
        || PARTIAL_TRADED.equals(status) || CANCELLING.equals(status) || PARTIAL_CANCELED.equals(status);
  }

  public static StatusEnum getStatus(String name) {
    StatusEnum statusEnum = initMap.get(name);
    if (Objects.nonNull(statusEnum)) {
      return statusEnum;
    }
    return StatusEnum.NONE;
  }
}
