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

  test("test + returns sum") {
    val five = Money.dollar(5)
    val sum = five + five
    assert(five == sum.augend)
    assert(five == sum.addend)
  }

  test("reduce money") {
    val bank = new Bank()
    val result = bank.reduce(Money.dollar(1), "USD")
    assert(result == Money.dollar(1))
  }

  test("reduce sum") {
    val sum = new Sum(Money.dollar(3), Money.dollar(4))
    val bank = new Bank()
    val result = bank.reduce(sum, "USD")
    assert(result == Money.dollar(7))
  }

  test("reduce money different currency") {
    val bank = new Bank()
    bank.addRate("CHF", "USD", 2)
    val result = bank.reduce(Money.franc(2), "USD")
    assert(result == Money.dollar(1) )
  }

  test("identical rate") {
    assert(1 == new Bank().rate("USD", "USD"))
  }

  test("mixed addition") {
    val fiveBucks = Money.dollar(5)
    val tenFrancs = Money.franc(10)
    val bank = new Bank
    bank.addRate("CHF", "USD", 2)
    val result = bank.reduce(fiveBucks + tenFrancs, "USD")
    assert(result == Money.dollar(10))
  }
}
