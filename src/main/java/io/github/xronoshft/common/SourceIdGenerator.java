package io.github.xronoshft.common;

import java.util.Random;

public class SourceIdGenerator {
  private static int id = 1;

  public static int getSourceId() {
    return (int) (Math.random() * 1000);
  }
}
