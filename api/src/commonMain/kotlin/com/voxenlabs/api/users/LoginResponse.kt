import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val accessToken: String,
)
