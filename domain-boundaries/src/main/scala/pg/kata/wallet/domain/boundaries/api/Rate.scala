package pg.kata.wallet.domain.boundaries.api

trait Rate {
  def fromTo(to: Currency)(implicit wallet: Wallet): Amount
}

case class Wallet(stocks: List[Stock])

case class Stock(quantity: StockQuantity, StockType: StockType)

case class StockQuantity(value: Int)

case class Amount(price: Price, currency: Currency)

case class Price(value: BigDecimal)

case class Value(amount: Amount, currency: Currency)

sealed trait StockType
case object PETROLEUM extends StockType
case object EURO extends StockType
case object DOLLARS extends StockType
case object BITCOIN extends StockType

sealed trait Currency

case object EUR extends Currency with StockType

case object USD extends Currency with StockType

case object JPY extends Currency with StockType

object Value {
  implicit class Extensions(value: Value) {}
}
