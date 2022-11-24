package io.github.xronoshft.constants;

import lombok.Getter;

@Getter
public enum TopicTypeEnum {

  HEART_BEAT("心跳包");

  private final String desc;

  TopicTypeEnum(String desc) {
    this.desc = desc;
  }
}
