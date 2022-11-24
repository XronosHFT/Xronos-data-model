package io.github.xronoshft.util;

import java.math.BigDecimal;

public class MathUtil {

  /**
   * 根据精度取值
   *
   * @param price
   * @param precision
   * @return
   */
  public static double getPriceDoubleByPrecision(double price, double precision) {
    price = price / precision;
    int priceInt = (int) price;
    return priceInt * precision;
  }

  /**
   * 根据精度取值
   *
   * @param price
   * @param precision
   * @return
   */
  public static String getPriceStringByPrecision(double price, double precision) {
    return String.valueOf(getPriceDoubleByPrecision(price, precision));
  }

  public static int getPrecisionInt(double precision) {
    double val = Math.log10(1 / precision);
    return (int) Math.round(val);
  }

  public static double maintainPrecision(double input) {
    return Math.round(input * 1e15) / 1e15;
  }

  public static void main(String[] args) {
  }
}
