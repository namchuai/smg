package com.example.network.model

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.jsonObject

object NetworkLocalizationSerializer : KSerializer<NetworkLocalization> {
    private val stringSerializer = String.serializer()
    private val localizedDataSerializer = NetworkLocalizedData.serializer()

    override val descriptor = buildClassSerialDescriptor("NetworkLocalization") {
        element<String>("primary")
    }

    override fun serialize(encoder: Encoder, value: NetworkLocalization) {
        val jsonEncoder = encoder as? JsonEncoder
            ?: throw SerializationException("This serializer can only be used with Json")
        val jsonObject = buildJsonObject {
            put("primary", JsonPrimitive(value.primary))
            value.locales?.forEach { (key, localeData) ->
                put(key, jsonEncoder.json.encodeToJsonElement(localizedDataSerializer, localeData))
            }
        }
        jsonEncoder.encodeJsonElement(jsonObject)
    }

    override fun deserialize(decoder: Decoder): NetworkLocalization {
        val jsonDecoder = decoder as? JsonDecoder
            ?: throw SerializationException("This serializer can only be used with Json")
        val jsonObject = jsonDecoder.decodeJsonElement().jsonObject

        var primary: String? = null
        val locales = mutableMapOf<String, NetworkLocalizedData>()

        jsonObject.forEach { (key, element) ->
            when (key) {
                "primary" -> primary =
                    jsonDecoder.json.decodeFromJsonElement(stringSerializer, element)

                else -> {
                    // Assume any other key is a locale identifier
                    val localeData =
                        jsonDecoder.json.decodeFromJsonElement(localizedDataSerializer, element)
                    locales[key] = localeData
                }
            }
        }

        return NetworkLocalization(
            primary = primary
                ?: throw SerializationException("Missing 'primary' field in NetworkLocalization"),
            locales = locales.ifEmpty { null } // Keep consistent with nullable type if map ends up empty
        )
    }
} 