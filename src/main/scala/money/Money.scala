package money

object Money {
  def dollar(amount: Int): Money = new Dollar(amount, currency = "USD")

  def franc(amount: Int): Money = new Franc(amount, currency = "CHF")
}

abstract class Money(protected val amount: Int, val currency: String) {
  override def equals(obj: Any): Boolean = {
    obj match {
      case that: Money if that.getClass == this.getClass =>
        this.amount == that.amount
      case _ => super.equals(obj)
    }
  }

  def *(multiplier: Int): Money
}
