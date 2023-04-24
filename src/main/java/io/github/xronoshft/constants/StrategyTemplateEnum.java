package io.github.xronoshft.constants;

public enum StrategyTemplateEnum {

  TRIANGLE(
      "",//TriangleArbitrage.class.getName(),
      "", //TODO
      "三角套利"
  );

  String strategy;
  String param;
  String displayLabel;
  String basicGeneratorParam;

  StrategyTemplateEnum(String strategy, String param, String displayLabel) {
    this.strategy = strategy;
    this.param = param;
    this.displayLabel = displayLabel;
  }

  public String getStrategy() {
    return strategy;
  }

  public String getParam() {
    return param;
  }

  public String getDisplayLabel() {
    return displayLabel;
  }
}
