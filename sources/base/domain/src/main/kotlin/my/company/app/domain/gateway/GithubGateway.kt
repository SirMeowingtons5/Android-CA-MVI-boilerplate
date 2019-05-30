package my.company.app.domain.gateway

import my.company.app.domain.model.GithubUser

interface GithubGateway{
    suspend fun getGithubTopUsers(): List<GithubUser>
}