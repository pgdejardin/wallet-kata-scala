package pg.kata.wallet

import pg.kata.wallet.domain.boundaries.api.{BITCOIN, EUR, PETROLEUM, Stock, StockQuantity, Wallet}
import pg.kata.wallet.domain.core.Rate
import pg.kata.wallet.infrastructure.spi.inmemory.InMemoryExchanges

object Application extends App {
  val exchangeAdapter = InMemoryExchanges()
  val rateService = Rate(exchangeAdapter)

  val wallet = Wallet(
    List(
      Stock(StockQuantity(5), PETROLEUM),
      Stock(StockQuantity(0.5643), BITCOIN)
    ))
  val value = rateService.to(EUR)(wallet)

  println(s"The wallet has a value of ${value.price} in ${value.currency}")
}
