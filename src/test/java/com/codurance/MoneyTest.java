package com.codurance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MoneyTest {

  @Test
  void testMultiplication() {
    final Dollar five = new Dollar(5);

    five.times(2);

    assertEquals(10, five.amount);
  }
}
