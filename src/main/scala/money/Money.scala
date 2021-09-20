package money

abstract class Money(protected val amount: Int) {
  override def equals(obj: Any): Boolean = {
    obj match {
      case that: Money => this.amount == that.amount
      case _ => super.equals(obj)
    }
  }
}
