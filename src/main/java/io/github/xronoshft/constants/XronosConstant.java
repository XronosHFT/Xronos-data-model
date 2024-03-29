package io.github.xronoshft.constants;

import java.io.File;

public class XronosConstant {
  public static final String UNDERLINE_SEPARATOR = "_";
  public static final String DOT_SEPARATOR = ".";
  public static final String QUESTION_MARK = "?";
  public static final String EQUATION = "=";
  public static final String AND = "&";
  public static final int LEVER_RATE_1 = 1;
  public static final int LEVER_RATE_5 = 5;
  public static final int LEVER_RATE_10 = 5;
  public static final int LEVER_RATE_20 = 5;
  public static final int LEVER_RATE_30 = 5;
  public static final int LEVER_RATE_50 = 5;
  public static final int LEVER_RATE_70 = 5;
  public static final int LEVER_RATE_100 = 5;
  public static final int LEVER_RATE_125 = 5;

  public static String PING = "ping";
  public static String PONG = "pong";

  /***================核心持久化Map配置===============***/
  public static String CORE_MAP_PATH = "coreMap/";

  static {
    CORE_MAP_PATH = System.getProperty("sharePath", "") + CORE_MAP_PATH;
    File file = new File(CORE_MAP_PATH);
    if (!file.exists()) {
      file.mkdirs();
    }
  }
  public static String BACKTEST_MAP_TEMP_STRATEGY_PATH = "BackTestTrade/TempData/Strategy/";
  public static String BACKTEST_MAP_TEMP_EXCHANGE_PATH = "BackTestTrade/TempData/Exchange/";
  public static String BACKTEST_MAP_BASIC_STRATEGY_PATH = "BackTestTrade/BasicData/Strategy/";

  public static int TRADE_MAP_SIZE = 100_000;
  public static String TRADE_MAP_NAME = "Trade";
  public static String TRADE_MAP_PATH = CORE_MAP_PATH + "Trade.dat";
  public static String BACKTEST_TRADE_MAP_STRATEGY_PATH = BACKTEST_MAP_TEMP_STRATEGY_PATH + "Trade.dat";
  public static String BACKTEST_TRADE_MAP_EXCHANGE_PATH = BACKTEST_MAP_TEMP_EXCHANGE_PATH + "Trade.dat";

  public static int BALANCE_MAP_SIZE = 200;
  public static String BALANCE_MAP_NAME = "Balance";
  public static String BALANCE_MAP_PATH = CORE_MAP_PATH + "Balance.dat";
  public static String BACKTEST_BALANCE_MAP_STRATEGY_PATH = BACKTEST_MAP_TEMP_STRATEGY_PATH + "Balance.dat";
  public static String BACKTEST_BALANCE_MAP_EXCHANGE_PATH = BACKTEST_MAP_TEMP_EXCHANGE_PATH + "ExchangeBalance.dat";

  public static int POSITION_MAP_SIZE = 200;
  public static String POSITION_MAP_NAME = "Position";
  public static String POSITION_MAP_PATH = CORE_MAP_PATH + "Position.dat";
  public static String BACKTEST_POSITION_MAP_STRATEGY_PATH = BACKTEST_MAP_TEMP_STRATEGY_PATH + "Position.dat";
  public static String BACKTEST_POSITION_MAP_EXCHANGE_PATH = BACKTEST_MAP_TEMP_EXCHANGE_PATH + "ExchangePosition.dat";

  public static int ACCOUNT_MAP_SIZE = 100;
  public static String ACCOUNT_MAP_NAME = "Account";
  public static String ACCOUNT_MAP_PATH = CORE_MAP_PATH + "Account.dat";
  public static String BACKTEST_ACCOUNT_MAP_STRATEGY_PATH = BACKTEST_MAP_TEMP_STRATEGY_PATH + "Account.dat";
  public static String BACKTEST_ACCOUNT_MAP_EXCHANGE_PATH = BACKTEST_MAP_TEMP_EXCHANGE_PATH + "Account.dat";

  public static int ACTIVEORDER_MAP_SIZE = 10_000;
  public static String ACTIVEORDER_MAP_NAME = "ActiveOrder";
  public static String ACTIVEORDER_MAP_PATH = CORE_MAP_PATH + "ActiveOrder.dat";
  public static String BACKTEST_ACTIVEORDER_MAP_STRATEGY_PATH = BACKTEST_MAP_TEMP_STRATEGY_PATH + "ActiveOrder.dat";
  public static String BACKTEST_ACTIVEORDER_MAP_EXCHANGE_PATH = BACKTEST_MAP_TEMP_EXCHANGE_PATH + "ActiveOrder.dat";

  public static int INACTIVEORDER_MAP_SIZE = 100_000;
  public static String INACTIVEORDER_MAP_NAME = "InactiveOrder";
  public static String INACTIVEORDER_MAP_PATH = CORE_MAP_PATH + "InactiveOrder.dat";
  public static String BACKTEST_INACTIVEORDER_MAP_STRATEGY_PATH = BACKTEST_MAP_TEMP_STRATEGY_PATH + "InactiveOrder.dat";

  public static int CONTRACT_MAP_SIZE = 10_000;
  public static String CONTRACT_MAP_NAME = "Contract";
  public static String CONTRACT_MAP_PATH = CORE_MAP_PATH + "Contract.dat";
  public static String BACKTEST_CONTRACT_MAP_STRATEGY_PATH = BACKTEST_MAP_BASIC_STRATEGY_PATH + "Contract.dat";

  public static int IDEMPOTENT_MAP_SIZE = 100_000;
  public static String IDEMPOTENT_MAP_NAME = "Idempotent";
  public static String IDEMPOTENT_MAP_PATH = CORE_MAP_PATH + "Idempotent.dat";
  public static String BACKTEST_IDEMPOTENT_MAP_STRATEGY_PATH = BACKTEST_MAP_TEMP_STRATEGY_PATH + "Idempotent.dat";

}
