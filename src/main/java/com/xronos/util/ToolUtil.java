package com.xronos.util;

import com.xronos.constants.ContractTypeEnum;
import com.xronos.constants.DirectionEnum;
import com.xronos.constants.ExchangeEnum;
import com.xronos.constants.ProductEnum;
import com.xronos.constants.XronosConstant;

/**
 * 跨模块公用工具类
 */
public class ToolUtil {

  /**
   * 获取balance key
   *
   * @param asset
   * @param exchangeEnum
   * @param productEnum
   * @return
   */
  public static String getBalanceKey(String asset, ExchangeEnum exchangeEnum) {
    return String.join(XronosConstant.DOT_SEPARATOR, asset, exchangeEnum.name()).toLowerCase();
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
   * @return
   */
  public static String getPositionKey(String symbol, ExchangeEnum exchange, DirectionEnum direction, ContractTypeEnum contractType) {
    return String.join(XronosConstant.DOT_SEPARATOR, symbol, exchange.name(), direction.name(), contractType.name()).toLowerCase();
  }
}
