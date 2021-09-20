package money

class Dollar(private val amount: Int) {
  def times(multiplier: Int): Dollar = {
    new Dollar(amount * multiplier)
  }

  override def equals(obj: Any): Boolean = {
    obj match {
      case that: Dollar => this.amount == that.amount
      case _ => super.equals(obj)
    }
  }
}
