package my.company.app.data.remote

import my.company.app.data.model.GithubUserEntity

interface GithubGateway{
    suspend fun getGithubTopUsers(): List<GithubUserEntity>
}