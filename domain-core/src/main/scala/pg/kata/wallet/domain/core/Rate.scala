package pg.kata.wallet.domain.core

import pg.kata.wallet.domain.boundaries.api.{Amount, Currency, Price, Stock, Value, Wallet, Rate => RateAPI}
import pg.kata.wallet.domain.boundaries.spi.Exchanges

final class Rate(exchanges: Exchanges) extends RateAPI {
  override def to(to: Currency): Wallet => Amount = { wallet =>
    val price = wallet.stocks.foldLeft(0d)((acc: Double, stock: Stock) => {
      acc + stock.quantity.value * exchanges.convert(stock.StockType, to).rate
    })
    Amount(Price(price), to)
  }
}

object Rate {
  def apply(exchanges: Exchanges): Rate = new Rate(exchanges)
}
