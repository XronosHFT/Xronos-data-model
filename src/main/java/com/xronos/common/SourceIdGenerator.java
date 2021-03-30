package com.xronos.common;

public class SourceIdGenerator {
  private static int id = 1;

  public static int getSourceId() {
    return id++;
  }
}
