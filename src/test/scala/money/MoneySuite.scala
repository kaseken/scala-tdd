package money

import org.scalatest.funsuite.AnyFunSuite


class MoneySuite extends AnyFunSuite {
  test("5 times 2 equals 10") {
    val five = new Dollar(5)
    val ten = five.times(2)
    assert(ten.amount == 10)
  }

  test("5 times 3 equals 15") {
    val five = new Dollar(5)
    val fifteen = five.times(3)
    assert(fifteen.amount == 15)
  }

  test("equality") {
    assert(new Dollar(5).equals(new Dollar(5)))
    assert(!new Dollar(5).equals(new Dollar(6)))
  }
}
