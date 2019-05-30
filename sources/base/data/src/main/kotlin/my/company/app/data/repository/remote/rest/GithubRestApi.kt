package my.company.app.data.repository.remote.rest

import my.company.app.data.repository.model.GithubUserEntity
import retrofit2.Call
import retrofit2.http.GET

/**
 * Uses stub JSON located @ http://myjson.com/154gl0
 */
internal interface GithubRestApi{
    @GET("bins/154gl0")
    fun getTopUsers(): Call<List<GithubUserEntity>>
}