package com.xronos.util;

import com.xronos.constants.ContractTypeEnum;
import com.xronos.constants.DirectionEnum;
import com.xronos.constants.ExchangeEnum;
import com.xronos.constants.LongOrShortEnum;
import com.xronos.constants.XronosConstant;
import org.apache.commons.lang3.StringUtils;

/**
 * 跨模块公用工具类
 */
public class ToolUtil {

  private ToolUtil() {
  }

  /**
   * 获取balance key
   *
   * @param asset
   * @param exchangeEnum
   * @param accountId
   * @return
   */
  public static String getBalanceKey(String asset, ExchangeEnum exchangeEnum, String accountId) {
    return String.join(XronosConstant.DOT_SEPARATOR, asset, exchangeEnum.name(), accountId).toLowerCase();
  }

  /**
   * 获取contract key
   *
   * @param symbol
   * @param exchangeEnum
   * @return
   */
  public static String getContractKey(String symbol, ExchangeEnum exchangeEnum) {
    return (symbol.replace("/", "-") + XronosConstant.DOT_SEPARATOR + exchangeEnum.name()).toLowerCase();
  }


  /**
   * 获取仓位的key
   *
   * @param symbol
   * @param exchange
   * @param direction
   * @param contractType
   * @param accountId
   * @return
   */
  public static String getPositionKey(String symbol, ExchangeEnum exchange, DirectionEnum direction, ContractTypeEnum contractType, String accountId) {
    return String.join(XronosConstant.DOT_SEPARATOR, symbol, exchange.name(), direction.name(), contractType.name(), accountId).toLowerCase();
  }

  /**
   * 获取账户key
   *
   * @param exchange
   * @param accountId
   * @return
   */
  public static String getAccountKey(ExchangeEnum exchange, String accountId, String symbol) {
    return String.join(XronosConstant.DOT_SEPARATOR, exchange.name(), accountId, symbol).toLowerCase();
  }

  /**
   * 获取策略唯一名
   *
   * @param accountId
   * @param contract
   * @param longOrShort
   * @param strategyName
   * @param exchange
   * @return
   */
  public static String getStrategyUnionName(ExchangeEnum exchange, String accountId, String contract, String strategyName, LongOrShortEnum longOrShort) {
    return String.join(XronosConstant.UNDERLINE_SEPARATOR, exchange.name(), accountId, covertToLocalContractName(contract), strategyName, longOrShort.getCode()).toLowerCase();
  }

  private static String covertToLocalContractName(String contract) {
    if (StringUtils.isBlank(contract)) {
      return contract;
    }
    return contract.replace("/", XronosConstant.UNDERLINE_SEPARATOR);
  }


  /**
   * 获取联合key
   *
   * @param keys
   * @return
   */
  public static String getUnionKey(String... keys) {
    final StringBuilder sb = new StringBuilder();
    for (String key : keys) {
      sb.append(key);
    }
    return sb.toString();
  }
}
