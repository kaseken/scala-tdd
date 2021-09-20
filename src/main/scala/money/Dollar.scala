package money

class Dollar(amount: Int) extends Money(amount) {
  def *(multiplier: Int) = new Dollar(amount * multiplier)
}
