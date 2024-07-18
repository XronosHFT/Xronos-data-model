package io.github.xronoshft.constants;

/**
 * 用数字定义日志
 * 高三位定义日志类型
 * 低四位定义具体的日志
 *
 * Description:
 * created at: 2023/12/8
 * creator: Shawn
 */
public enum LogProtocolEnum {

  ORDER_SUBMITTING(100_0001, "订单提交中"),
  ORDER_SUBMITTED(100_0002, "订单已提交"),
  ORDER_TRADED(100_0003, "订单已交易"),
  ORDER_CANCEL(100_0004, "订单已取消"),
  ORDER_REJECT(100_0005, "订单被拒绝"),

  TRADE_TRADED(102_0001, "交易成功"),
  TRADE_REJECTED(102_0002, "交易拒绝"),
  TRADE_FAILED(102_0003, "交易失败"),

  POSITION_UPDATE(103_0001, "仓位更新"),

  ;


  private int code;

  private String msg;

  LogProtocolEnum(int i, String msg) {

  }
}
