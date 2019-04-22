package pg.kata.wallet.infrastructure.spi.inmemory

import pg.kata.wallet.domain.boundaries.api._
import pg.kata.wallet.domain.boundaries.spi.{ConversionRate, Exchanges}

import scala.collection.concurrent.TrieMap

final class InMemoryExchanges extends Exchanges {

//  val stocksExchange: Map[StockType, Map[Currency, Double]] = Map(
  final val stocksExchange = new TrieMap[StockType, Map[Currency, Double]] +=
    (PETROLEUM -> Map(EUR -> 76.1235, USD -> 70.9876, JPY -> 1276.5674)) +=
    (BITCOIN -> Map(EUR -> 7650.7598, USD -> 5870.5512, JPY -> 5870.5512))

  override def convert(from: StockType, to: Currency): ConversionRate = {
    val exchange = stocksExchange.get(from) match {
      case Some(v) => v.get(to)
      case _       => None
    }
    exchange.fold({ ConversionRate(1) })({ v: Double =>
      ConversionRate(v)
    })
  }
}

object InMemoryExchanges {
  def apply(): InMemoryExchanges = new InMemoryExchanges()
}
