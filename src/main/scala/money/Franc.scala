package money

class Franc(amount: Int, currency: String) extends Money(amount, currency) {
  def *(multiplier: Int): Money = Money.franc(amount * multiplier)
}
