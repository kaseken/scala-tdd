package money

import org.scalatest.funsuite.AnyFunSuite


class MoneySuite extends AnyFunSuite {
  test("test Dollar multiplication") {
    val five = new Dollar(5)
    assert(five * 2 == new Dollar(10))
    assert(five * 3 == new Dollar(15))
  }

  test("equality") {
    assert(new Dollar(5) == new Dollar(5))
    assert(!(new Dollar(5) == new Dollar(6)))
    assert(new Franc(5) == new Franc(5))
    assert(!(new Franc(5) == new Franc(6)))
  }

  test("test Franc multiplication") {
    val five = new Franc(5)
    assert(five * 2 == new Franc(10))
    assert(five * 3 == new Franc(15))
  }
}
