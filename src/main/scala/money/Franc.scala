package money

class Franc(amount: Int) extends Money(amount) {
  def *(multiplier: Int) = new Franc(amount * multiplier)
}
