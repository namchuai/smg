package com.example.model

data class Localization(
    val primary: String,
    val locales: Map<String, LocalizedData>
)
