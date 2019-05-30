package my.company.app.domain.gateway

import my.company.app.domain.entity.GithubUser

interface GithubGateway{
    suspend fun getGithubTopUsers(): List<GithubUser>
}