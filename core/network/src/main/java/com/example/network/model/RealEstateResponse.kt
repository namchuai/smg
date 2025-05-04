import kotlinx.serialization.Serializable

@Serializable
data class RealEstateResponse(
    val items: List<String>
)