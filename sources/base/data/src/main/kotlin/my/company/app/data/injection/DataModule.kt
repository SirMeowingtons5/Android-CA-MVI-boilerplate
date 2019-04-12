package my.company.app.data.injection

import my.company.app.data.remote.GithubGateway
import my.company.app.data.remote.implementation.GithubGatewayImpl
import my.company.app.data.remote.rest.GithubRestApi
import okhttp3.OkHttpClient
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val DataModule = module {
    single {
        OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .build()
    }

    single {
        Retrofit.Builder()
                .baseUrl("https://api.myjson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(get())
                .build()
                .create(GithubRestApi::class.java)
    }

    single { GithubGatewayImpl(get()) } bind GithubGateway::class
}