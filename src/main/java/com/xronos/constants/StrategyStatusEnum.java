package com.xronos.constants;

public enum StrategyStatusEnum {
  NONE("NONE"),
  START("开始"),
  STOP("退出"),
  RUNNING("运行中"),
  PAUSE("已暂停");
  String value;

  StrategyStatusEnum(String value){
    this.value = value;
  }
}
