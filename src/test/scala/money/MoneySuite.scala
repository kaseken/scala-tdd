package money

import org.scalatest.funsuite.AnyFunSuite

class MoneySuite extends AnyFunSuite {
  test("test Dollar multiplication") {
    val five = Money.dollar(5)
    assert(five * 2 == Money.dollar(10))
    assert(five * 3 == Money.dollar(15))
  }

  test("equality") {
    assert(Money.dollar(5) == Money.dollar(5))
    assert(!(Money.dollar(5) == Money.dollar(6)))
    assert(Money.franc(5) == Money.franc(5))
    assert(!(Money.franc(5) == Money.franc(6)))
    assert(!(Money.dollar(5) == Money.franc(5)))
  }

  test("test Franc multiplication") {
    val five = Money.franc(5)
    assert(five * 2 == Money.franc(10))
    assert(five * 3 == Money.franc(15))
  }

  test("currency") {
    assert(Money.dollar(1).currency == "USD")
    assert(Money.franc(1).currency == "CHF")
  }
}
