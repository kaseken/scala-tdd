package money

import scala.collection.mutable

case class Pair(from: String, to: String)

class Bank {
  private val rates = new mutable.HashMap[Pair, Int]()
  def reduce(source: Expression, to: String): Money = source.reduce(this, to)

  def addRate(from: String, to: String, rate: Int): Option[Int] = {
    rates.put(Pair(from, to), rate)
  }

  def rate(from: String, to: String): Int = {
    if (from == to) 1 else rates.getOrElse(Pair(from, to), 1) // FIXME
  }
}
