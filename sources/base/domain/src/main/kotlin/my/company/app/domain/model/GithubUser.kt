package my.company.app.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Representation for a [GithubUser] fetched from an external layer data source
 */
data class GithubUser(val login: String,
                      val id: Int,
                      @SerializedName("avatar_url") val avatar: String,
                      @SerializedName("html_url") val url: String)