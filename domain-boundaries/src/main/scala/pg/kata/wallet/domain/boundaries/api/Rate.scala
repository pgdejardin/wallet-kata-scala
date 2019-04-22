package pg.kata.wallet.domain.boundaries.api

trait Rate {
  def to(to: Currency): Wallet => Amount
}

case class Wallet(stocks: List[Stock])

case class Stock(quantity: StockQuantity, StockType: StockType)

case class StockQuantity(value: Double)

case class Amount(price: Price, currency: Currency)

case class Price(value: BigDecimal)

sealed trait StockType
case object PETROLEUM extends StockType
case object EURO extends StockType
case object DOLLARS extends StockType
case object BITCOIN extends StockType

sealed trait Currency
case object EUR extends Currency with StockType
case object USD extends Currency with StockType
case object JPY extends Currency with StockType
