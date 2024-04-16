import androidx.annotation.Keep

import com.google.gson.annotations.SerializedName
import com.rohitjakhar.imageloading.domain.model.PhotoModel

class PhotosDto : ArrayList<PhotosDto.PhotosDtoItem>() {
    @Keep
    data class PhotosDtoItem(
        @SerializedName("alt_description")
        val altDescription: String? = null,
        @SerializedName("alternative_slugs")
        val alternativeSlugs: AlternativeSlugs? = null,
        @SerializedName("asset_type")
        val assetType: String? = null,
        @SerializedName("blur_hash")
        val blurHash: String? = null,
        @SerializedName("breadcrumbs")
        val breadcrumbs: List<Any?>? = null,
        @SerializedName("color")
        val color: String? = null,
        @SerializedName("created_at")
        val createdAt: String? = null,
        @SerializedName("current_user_collections")
        val currentUserCollections: List<Any?>? = null,
        @SerializedName("description")
        val description: String? = null,
        @SerializedName("height")
        val height: Int? = null,
        @SerializedName("id")
        val id: String? = null,
        @SerializedName("liked_by_user")
        val likedByUser: Boolean? = null,
        @SerializedName("likes")
        val likes: Int? = null,
        @SerializedName("links")
        val links: Links? = null,
        @SerializedName("promoted_at")
        val promotedAt: String? = null,
        @SerializedName("slug")
        val slug: String? = null,
        @SerializedName("sponsorship")
        val sponsorship: Any? = null,
        @SerializedName("topic_submissions")
        val topicSubmissions: TopicSubmissions? = null,
        @SerializedName("updated_at")
        val updatedAt: String? = null,
        @SerializedName("urls")
        val urls: Urls? = null,
        @SerializedName("user")
        val user: User? = null,
        @SerializedName("width")
        val width: Int? = null
    ) {
        @Keep
        data class AlternativeSlugs(
            @SerializedName("de")
            val de: String? = null,
            @SerializedName("en")
            val en: String? = null,
            @SerializedName("es")
            val es: String? = null,
            @SerializedName("fr")
            val fr: String? = null,
            @SerializedName("it")
            val `it`: String? = null,
            @SerializedName("ja")
            val ja: String? = null,
            @SerializedName("ko")
            val ko: String? = null,
            @SerializedName("pt")
            val pt: String? = null
        )

        @Keep
        data class Links(
            @SerializedName("download")
            val download: String? = null,
            @SerializedName("download_location")
            val downloadLocation: String? = null,
            @SerializedName("html")
            val html: String? = null,
            @SerializedName("self")
            val self: String? = null
        )

        @Keep
        data class TopicSubmissions(
            @SerializedName("architecture-interior")
            val architectureInterior: ArchitectureInterior? = null,
            @SerializedName("3d-renders")
            val dRenders: DRenders? = null,
            @SerializedName("film")
            val film: Film? = null,
            @SerializedName("street-photography")
            val streetPhotography: StreetPhotography? = null,
            @SerializedName("travel")
            val travel: Travel? = null,
            @SerializedName("wallpapers")
            val wallpapers: Wallpapers? = null
        ) {
            @Keep
            data class ArchitectureInterior(
                @SerializedName("status")
                val status: String? = null
            )

            @Keep
            data class DRenders(
                @SerializedName("status")
                val status: String? = null
            )

            @Keep
            data class Film(
                @SerializedName("status")
                val status: String? = null
            )

            @Keep
            data class StreetPhotography(
                @SerializedName("approved_on")
                val approvedOn: String? = null,
                @SerializedName("status")
                val status: String? = null
            )

            @Keep
            data class Travel(
                @SerializedName("approved_on")
                val approvedOn: String? = null,
                @SerializedName("status")
                val status: String? = null
            )

            @Keep
            data class Wallpapers(
                @SerializedName("status")
                val status: String? = null
            )
        }

        @Keep
        data class Urls(
            @SerializedName("full")
            val full: String? = null,
            @SerializedName("raw")
            val raw: String? = null,
            @SerializedName("regular")
            val regular: String? = null,
            @SerializedName("small")
            val small: String? = null,
            @SerializedName("small_s3")
            val smallS3: String? = null,
            @SerializedName("thumb")
            val thumb: String? = null
        )

        @Keep
        data class User(
            @SerializedName("accepted_tos")
            val acceptedTos: Boolean? = null,
            @SerializedName("bio")
            val bio: String? = null,
            @SerializedName("first_name")
            val firstName: String? = null,
            @SerializedName("for_hire")
            val forHire: Boolean? = null,
            @SerializedName("id")
            val id: String? = null,
            @SerializedName("instagram_username")
            val instagramUsername: String? = null,
            @SerializedName("last_name")
            val lastName: String? = null,
            @SerializedName("links")
            val links: Links? = null,
            @SerializedName("location")
            val location: String? = null,
            @SerializedName("name")
            val name: String? = null,
            @SerializedName("portfolio_url")
            val portfolioUrl: String? = null,
            @SerializedName("profile_image")
            val profileImage: ProfileImage? = null,
            @SerializedName("social")
            val social: Social? = null,
            @SerializedName("total_collections")
            val totalCollections: Int? = null,
            @SerializedName("total_illustrations")
            val totalIllustrations: Int? = null,
            @SerializedName("total_likes")
            val totalLikes: Int? = null,
            @SerializedName("total_photos")
            val totalPhotos: Int? = null,
            @SerializedName("total_promoted_illustrations")
            val totalPromotedIllustrations: Int? = null,
            @SerializedName("total_promoted_photos")
            val totalPromotedPhotos: Int? = null,
            @SerializedName("twitter_username")
            val twitterUsername: String? = null,
            @SerializedName("updated_at")
            val updatedAt: String? = null,
            @SerializedName("username")
            val username: String? = null
        ) {
            @Keep
            data class Links(
                @SerializedName("followers")
                val followers: String? = null,
                @SerializedName("following")
                val following: String? = null,
                @SerializedName("html")
                val html: String? = null,
                @SerializedName("likes")
                val likes: String? = null,
                @SerializedName("photos")
                val photos: String? = null,
                @SerializedName("portfolio")
                val portfolio: String? = null,
                @SerializedName("self")
                val self: String? = null
            )

            @Keep
            data class ProfileImage(
                @SerializedName("large")
                val large: String? = null,
                @SerializedName("medium")
                val medium: String? = null,
                @SerializedName("small")
                val small: String? = null
            )

            @Keep
            data class Social(
                @SerializedName("instagram_username")
                val instagramUsername: String? = null,
                @SerializedName("paypal_email")
                val paypalEmail: Any? = null,
                @SerializedName("portfolio_url")
                val portfolioUrl: String? = null,
                @SerializedName("twitter_username")
                val twitterUsername: String? = null
            )
        }
    }
}

fun PhotosDto.toPhotoModels(): List<PhotoModel> {
    val list = mutableListOf<PhotoModel>()
    this.forEach {
        if (it.id != null && it.urls?.regular != null)
            list.add(PhotoModel(id = it.id, photoUrl = it.urls.regular))
    }
    return list
}