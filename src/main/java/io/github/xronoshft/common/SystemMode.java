package io.github.xronoshft.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 系统启动模式:
 * Description:
 * 单机: 主要使用chronicle Q作为队列
 * 分布式: 使用redis push + rabbit MQ 作为系统队列
 * created at: 2023/4/9
 * creator: Shawn
 */
public enum SystemMode {
  /**
   * 单机
   */
  SINGLE,

  /**
   * 分布式
   */
  DISTRIBUTE;

  private static Map<String, SystemMode> initMap = new HashMap<>(2);

  static {
    initMap.put(SINGLE.name(), SINGLE);
    initMap.put(DISTRIBUTE.name(), DISTRIBUTE);
  }

  public static SystemMode getMode(String mode) {
    return initMap.get(mode);
  }
}
