package com.xronos.common;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTool {
  public static void setLevel(String lev) {
    Logger root = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
    Level level = Level.toLevel(lev, Level.INFO);
    root.setLevel(level);
  }
}
