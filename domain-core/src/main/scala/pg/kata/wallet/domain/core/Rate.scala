package pg.kata.wallet.domain.core

import pg.kata.wallet.domain.boundaries.api.{Amount, Currency, Wallet, Rate => RateAPI}

final class Rate extends RateAPI {
  override def fromTo(to: Currency)(implicit wallet: Wallet): Amount =
    Amount(wallet.stock.quantity.value)
}

object Rate {
  def apply(): Rate = new Rate()
}
