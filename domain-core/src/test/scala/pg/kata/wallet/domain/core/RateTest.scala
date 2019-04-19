package pg.kata.wallet.domain.core

import org.scalatest.{FlatSpec, Matchers}
import pg.kata.wallet.domain.boundaries.api._
import pg.kata.wallet.domain.boundaries.spi.{ConversionRate, Exchanges}

class RateTest extends FlatSpec with Matchers {
  "A wallet rate" should "have same amount for same currency rating" in {
    // Given
    val wallet = Wallet(Stock(StockQuantity(5), PETROLEUM), EUR)
    val exchanges: Exchanges = (_: Currency, _: Currency) => ConversionRate(1)

    val rate = Rate(exchanges)

    // When
    val amount = rate.fromTo(EUR)(wallet)

    // Then
    amount should equal(Amount(5))
  }

  "A wallet rate" should "have amount converted" in {
    // Given
    val wallet = Wallet(Stock(StockQuantity(5), PETROLEUM), EUR)
    val exchanges: Exchanges = (_: Currency, _: Currency) => ConversionRate(0.9)
    val rate = Rate(exchanges)

    // When
    val amount = rate.fromTo(USD)(wallet)

    // Then
    amount should equal(Amount(5 * 0.9))
  }
}
