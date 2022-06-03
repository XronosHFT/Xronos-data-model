package com.xronos.constants;

public enum WebsocketStatusEnum {
  NONE("NONE"),
  OPEN("开启"),
  LOGIN("登录"),
  CONNECTED("已连接"),
  RECONNECTING("重新连接中"),
  RECONNECTED("已重新连接"),
  CONNECTING("连接中"),
  CLOSING("关闭中"),
  CLOSED("关闭"),
  ERROR("错误");
  String value;

  WebsocketStatusEnum(String value){
    this.value = value;
  }
}
