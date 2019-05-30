package my.company.app.domain.usecase.implementation

import kotlinx.coroutines.*
import my.company.app.domain.gateway.GithubGateway
import my.company.app.domain.entity.GithubUser
import my.company.app.domain.usecase.GetGithubTopUsersUseCase


internal class FetchGithubTopUsers(private val githubGateway: GithubGateway): GetGithubTopUsersUseCase {
    override suspend fun get(): List<GithubUser> {
        return withContext(Dispatchers.IO) {
            githubGateway.getGithubTopUsers()
        }
    }
}