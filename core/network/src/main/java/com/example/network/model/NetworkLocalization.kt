package com.example.network.model

import com.example.model.Localization
import kotlinx.serialization.Serializable

@Serializable(with = NetworkLocalizationSerializer::class)
data class NetworkLocalization(
    val primary: String,
    val locales: Map<String, NetworkLocalizedData>?
)

fun NetworkLocalization.asDomain(): Localization = Localization(
    primary = primary,
    locales = locales?.mapValues { it.value.asDomain() } ?: emptyMap()
) 