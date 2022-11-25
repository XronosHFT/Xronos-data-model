package io.github.xronoshft.constants;

/**
 * Here are the strategy template params, the enum element name should align with param property file name.
 * There are four params should be set.
 * 1. Strategy class path name
 * 2. Strategy runtime param setting.
 * 3. Strategy generator param, generator need to generate basic strategy param on generator page.
 * 4. Strategy template name, this name will display on page.
 *
 * @author Shawn
 * 
 * 
 */
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
