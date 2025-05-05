package com.example.listing

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Currency
import java.util.Locale

data class RealEstateItem(
    val id: String,
    val title: String,
    val pricing: Money,
    val thumbnailUrls: List<String>,
    val address: String,
    val bookmarked: Boolean,
    val latitude: Double? = null,
    val longitude: Double? = null,
)

data class RealEstateUiState(
    val realEstateList: List<RealEstateItem> = emptyList(),
)

data class Money(
    val amount: BigDecimal,
    val currencyCode: String = "CHF",
) {
    fun toAmountDisplay(): String {
        val format =
            NumberFormat.getCurrencyInstance(Locale.GERMANY)
        val currency = Currency.getInstance(currencyCode)
        format.currency = currency

        format.maximumFractionDigits = 0

        return format.format(amount).replace("CHF", "₣") // Manual replace if default symbol isn't ₣
    }
}