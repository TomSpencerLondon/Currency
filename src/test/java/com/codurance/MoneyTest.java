package com.codurance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MoneyTest {

  @Test
  void testMultiplication() {
    assertEquals(Money.dollar(10), Money.dollar(5).times(2));
    assertEquals(Money.dollar(15), Money.dollar(5).times(3));
  }

  @Test
  void testSimpleAddition() {
    final Money five = Money.dollar(5);
    final Expression sum = five.plus(five);
    final Bank bank = new Bank();
    Money reduced = bank.reduce(sum, "USD");
    assertEquals(Money.dollar(10), reduced);
  }

  @Test
  void testPlusReturnsSum() {
    final Money five = Money.dollar(5);
    final Expression result = five.plus(five);
    Sum sum = (Sum) result;

    assertEquals(five, sum.augend);
    assertEquals(five, sum.addend);
  }

  @Test
  void testReduceSum() {
    Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
    final Bank bank = new Bank();
    final Money result = bank.reduce(sum, "USD");
    assertEquals(Money.dollar(7), result);
  }

  @Test
  void testCurrency() {
    assertEquals("USD", Money.dollar(1).currency());
    assertEquals("CHF", Money.franc(1).currency());
  }

  @Test
  void testDifferentClassEquality() {
    assertTrue(new Money(10, "CHF").equals(new Franc(10, "CHF")));
  }

  @Test
  void testEquality() {
    assertTrue(Money.dollar(5).equals(Money.dollar(5)));
    assertFalse(Money.dollar(5).equals(Money.dollar(6)));
    assertFalse(Money.franc(5).equals(Money.dollar(5)));
  }
}
