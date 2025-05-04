package com.example.model

data class LocalizedData(
    val attachments: List<Attachment>,
    val text: TextData,
    val urls: List<UrlData>
) 