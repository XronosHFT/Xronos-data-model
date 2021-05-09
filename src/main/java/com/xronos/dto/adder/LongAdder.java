package com.xronos.dto.adder;

public class LongAdder {
  private long value;

  public LongAdder(long initialValue) {
    this.value = initialValue;
  }

  public final long get() {
    return this.value;
  }

  public final void set(long newValue) {
    this.value = newValue;
  }

  public final void increment() {
    value++;
  }

  public final void decrement() {
    value--;
  }

  public final void reset() {
    value = 0;
  }
}
