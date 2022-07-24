package com.xronos.util;

import com.alibaba.fastjson2.JSON;

public class JSONUtil {

  private JSONUtil() {
  }

  public static String toJSONString(Object obj) {
    return JSON.toJSONString(obj);
  }
}
