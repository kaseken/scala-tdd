package money

class Dollar(val amount: Int) {
  def times(multiplier: Int): Dollar = {
    new Dollar(amount * multiplier)
  }

   def equals(that: Dollar): Boolean = {
    this.amount == that.amount
  }
}
