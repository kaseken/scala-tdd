package money

import sun.reflect.generics.reflectiveObjects.NotImplementedException

object Money {
  def dollar(amount: Int): Money = new Money(amount, currency = "USD")

  def franc(amount: Int): Money = new Money(amount, currency = "CHF")
}

class Money(val amount: Int, val currency: String) extends Expression {
  override def equals(obj: Any): Boolean = {
    obj match {
      case that: Money if that.currency == this.currency =>
        this.amount == that.amount
      case _ => super.equals(obj)
    }
  }

  def *(multiplier: Int): Expression = new Money(amount * multiplier, currency)

  def +(that: Expression): Sum = new Sum(this, that)

  def reduce(bank: Bank, to: String): Money = {
    new Money(amount / bank.rate(currency, to), to)
  }
}

class Sum(val augend: Expression, val addend: Expression) extends Expression {
  def +(that: Expression): Expression = {
    throw new NotImplementedException
  }

  def reduce(bank: Bank, to: String): Money = {
    new Money(augend.reduce(bank, to).amount + addend.reduce(bank, to).amount, to)
  }
}

