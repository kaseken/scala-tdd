package money

import org.scalatest.funsuite.AnyFunSuite

class MoneySuite extends AnyFunSuite {
  test("multiplication") {
    val five = Money.dollar(5)
    assert(five * 2 == Money.dollar(10))
    assert(five * 3 == Money.dollar(15))
  }

  test("equality") {
    assert(Money.dollar(5) == Money.dollar(5))
    assert(!(Money.dollar(5) == Money.dollar(6)))
    assert(!(Money.dollar(5) == Money.franc(5)))
  }

  test("currency") {
    assert(Money.dollar(1).currency == "USD")
    assert(Money.franc(1).currency == "CHF")
  }

  test("simple addition") {
    val five = Money.dollar(5)
    val sum = five + five
    val bank = new Bank()
    val reduced = bank.reduce(sum, "USD")
    assert(reduced == Money.dollar(10))
  }
}
