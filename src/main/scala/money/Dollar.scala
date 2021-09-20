package money

class Dollar(amount: Int, currency: String) extends Money(amount, currency) {
  def *(multiplier: Int): Money = Money.dollar(amount * multiplier)
}
