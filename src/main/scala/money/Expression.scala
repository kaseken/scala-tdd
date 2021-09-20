package money

trait Expression {
  def +(that: Expression): Expression
  def *(multiplier: Int): Expression
  def reduce(bank: Bank, to: String): Money
}
