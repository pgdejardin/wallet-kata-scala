package pg.kata.wallet.domain.core

import pg.kata.wallet.domain.boundaries.api.{Amount, Currency, Wallet, Rate => RateAPI}
import pg.kata.wallet.domain.boundaries.spi.Exchanges

final class Rate(exchanges: Exchanges) extends RateAPI {
  override def fromTo(to: Currency)(implicit wallet: Wallet): Amount = {
    val rate = exchanges.convert(wallet.currency, to)
    Amount(rate.rate * wallet.stock.quantity.value)
  }
}

object Rate {
  def apply(exchanges: Exchanges): Rate = new Rate(exchanges)
}
