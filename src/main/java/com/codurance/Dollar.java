package com.codurance;

public class Dollar extends Money {

  private final String currency;

  public Dollar(int amount) {
    this.amount = amount;
    this.currency = "USD";
  }

  public Money times(int multiplier) {
    return new Dollar(amount * multiplier);
  }

  public String currency() {
    return this.currency;
  }
}
