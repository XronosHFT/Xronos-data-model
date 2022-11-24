package io.github.xronoshft.dto.adder;

public class IntegerAdder {
  private int value;

  public IntegerAdder(int initialValue) {
    this.value = initialValue;
  }

  public final int get() {
    return this.value;
  }

  public final void set(int newValue) {
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
