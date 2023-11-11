package io.github.xronoshft.constants;

import io.github.xronoshft.common.MarketSignalType;

public class Test {

  public static void main(String[] args) {
    String name = MarketSignalType.CAPITAL_INFLOW.getName();
    System.out.println(name);
    String name1 = MarketSignalType.CAPITAL_INFLOW._1_MIN.name();
    System.out.println(name1);
  }
}
