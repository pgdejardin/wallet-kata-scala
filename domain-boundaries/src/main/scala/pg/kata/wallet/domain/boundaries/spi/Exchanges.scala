package pg.kata.wallet.domain.boundaries.spi

import pg.kata.wallet.domain.boundaries.api.{Currency, StockType}

trait Exchanges {
  def convert(from: StockType, to: Currency): ConversionRate
}

case class ConversionRate(rate: Double)
