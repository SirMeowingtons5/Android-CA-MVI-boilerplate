package my.company.app.data.remote.rest

import my.company.app.data.model.GithubUserEntity
import retrofit2.Call
import retrofit2.http.GET

/**
 * Uses stub JSON located @ http://myjson.com/154gl0
 */
interface GithubRestApi{
    @GET("bins/154gl0")
    fun getTopUsers(): Call<List<GithubUserEntity>>
}