package my.company.app.data.remote.implementation

import my.company.app.data.model.GithubUserEntity
import my.company.app.data.remote.GithubGateway
import my.company.app.data.remote.rest.GithubRestApi

class GithubGatewayImpl(val githubRestApi: GithubRestApi): GithubGateway {
    override suspend fun getGithubTopUsers(): List<GithubUserEntity>{
        //TODO: use proper exception
        return githubRestApi.getTopUsers().execute().body() ?: throw Exception()
    }
}