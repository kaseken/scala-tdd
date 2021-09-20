package money

import org.scalatest.funsuite.AnyFunSuite


class MoneySuite extends AnyFunSuite {
  test("5 times 2 equals 10") {
    val five = new Dollar(5)
    assert(five.times(2) == new Dollar(10))
  }

  test("5 times 3 equals 15") {
    val five = new Dollar(5)
    assert(five.times(3) == new Dollar(15))
  }

  test("equality") {
    assert(new Dollar(5) == new Dollar(5))
    assert(!(new Dollar(5) == new Dollar(6)))
  }
}
