package pg.kata.wallet.domain.boundaries.spi

import pg.kata.wallet.domain.boundaries.api.Currency

trait Exchanges {
  def convert(from: Currency, to: Currency): ConversionRate
}

case class ConversionRate(rate: Double)
