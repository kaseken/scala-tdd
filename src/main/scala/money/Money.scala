package money

object Money {
  def dollar(amount: Int): Money = new Money(amount, currency = "USD")

  def franc(amount: Int): Money = new Money(amount, currency = "CHF")
}

class Money(protected val amount: Int, val currency: String) extends Expression {
  override def equals(obj: Any): Boolean = {
    obj match {
      case that: Money if that.currency == this.currency =>
        this.amount == that.amount
      case _ => super.equals(obj)
    }
  }

  def *(multiplier: Int): Money = new Money(amount * multiplier, currency)

  def +(that: Money): Expression = {
    new Money(this.amount + that.amount, currency)
  }
}
