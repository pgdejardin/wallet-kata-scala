package pg.kata.wallet.domain.core

import org.scalatest.{FlatSpec, Matchers}
import pg.kata.wallet.domain.boundaries.api._

class RateTest extends FlatSpec with Matchers {
  "A wallet rate" should "have same amount for same currency rating" in {
    // Given
    val wallet = Wallet(Stock(StockQuantity(5), PETROLEUM), EUR)
    val rate = Rate()

    // When
    val amount = rate.fromTo(EUR)(wallet)

    // Then
    amount should equal(Amount(5))
  }
}
