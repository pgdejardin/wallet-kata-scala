package pg.kata.wallet.domain.boundaries.api

trait Rate {
  def fromTo(from: Currency, to: Currency)(implicit wallet: Wallet): Amount
}

case class Wallet(stock: Stock, currency: Currency)

case class Stock(quantity: StockQuantity, StockType: StockType)

case class StockQuantity(value: Int)

case class Amount(value: BigDecimal)

sealed trait StockType
case object PETROLEUM extends StockType
case object EURO extends StockType
case object DOLLARS extends StockType
case object BITCOIN extends StockType

sealed trait Currency
case object EUR extends Currency
case object USD extends Currency
case object JPY extends Currency
