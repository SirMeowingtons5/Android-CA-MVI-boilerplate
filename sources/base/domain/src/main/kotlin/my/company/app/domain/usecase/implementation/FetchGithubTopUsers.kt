package my.company.app.domain.usecase.implementation

import kotlinx.coroutines.*
import my.company.app.data.remote.GithubGateway
import my.company.app.domain.model.GithubUser
import my.company.app.domain.model.GithubUserMapper
import my.company.app.domain.usecase.GetGithubTopUsersUseCase

/**
 * Temporary stub until data layer is implemented
 */
class FetchGithubTopUsers(private val githubGateway: GithubGateway): GetGithubTopUsersUseCase {
    private val userMapper = GithubUserMapper()
    override suspend fun get(): List<GithubUser> {
        return withContext(Dispatchers.IO) {
            githubGateway.getGithubTopUsers().map { userMapper.fromEntity(it) }
        }
    }
}