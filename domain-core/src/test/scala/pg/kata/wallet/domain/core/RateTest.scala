package pg.kata.wallet.domain.core

import org.scalatest.{FlatSpec, Matchers}
import pg.kata.wallet.domain.boundaries.api._
import pg.kata.wallet.domain.boundaries.spi.{ConversionRate, Exchanges}

class RateTest extends FlatSpec with Matchers {
  "A wallet" should "have same amount for same currency rating" in {
    // Given
    val wallet = Wallet(List(Stock(StockQuantity(5), PETROLEUM)))
    val exchanges: Exchanges = (_: StockType, _: Currency) => ConversionRate(1)

    val rate = Rate(exchanges)

    // When
    val amount = rate.fromTo(EUR)(wallet)

    // Then
    amount should equal(Amount(Price(5), EUR))
  }

  "A wallet" should "have amount converted" in {
    // Given
    val wallet = Wallet(List(Stock(StockQuantity(5), PETROLEUM)))
    val exchanges: Exchanges = (_: StockType, _: Currency) => ConversionRate(0.9)
    val rate = Rate(exchanges)

    // When
    val amount = rate.fromTo(USD)(wallet)

    // Then
    amount should equal(Amount(Price(5 * 0.9), USD))
  }

  "A wallet" should "have a value from all stocks" in {
    // Given
    val wallet = Wallet(List(Stock(StockQuantity(5), PETROLEUM), Stock(StockQuantity(10), DOLLARS)))
    val exchanges: Exchanges = (_: StockType, _: Currency) => ConversionRate(100)
    val rate = Rate(exchanges)

    // When
    val amount = rate.fromTo(USD)(wallet)

    // Then
    amount should equal(Amount(Price(5 * 100 + 10 * 100), USD))
  }
}
