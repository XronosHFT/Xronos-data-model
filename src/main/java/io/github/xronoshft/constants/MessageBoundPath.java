package io.github.xronoshft.constants;

public class MessageBoundPath {
  private static String OUTBOUND_MESSAGE = "XronosOutbound";
  private static String OUTBOUND_HISTORICAL_MESSAGE = "XronosHistoricalOutbound";
  private static String INBOUND_MESSAGE = "XronosInbound";

  public static String getInBoundMessage(String prefix) {
    return prefix + INBOUND_MESSAGE;
  }

  public static String getOutBoundMessage(String prefix) {
    return prefix + OUTBOUND_MESSAGE;
  }
}
