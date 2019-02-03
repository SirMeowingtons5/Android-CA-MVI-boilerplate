package my.company.app.domain.usecase.implementation

import kotlinx.coroutines.*
import my.company.app.domain.model.GithubUser
import my.company.app.domain.usecase.GetGithubTopUsersUseCase

/**
 * Temporary stub until data layer is implemented
 */
class FetchGithubTopUsers: GetGithubTopUsersUseCase {
    override suspend fun get(): List<GithubUser> {
        return withContext(Dispatchers.Main) {
            delay(3 * 1000)
            val res = ArrayList<GithubUser>().apply {
                add(GithubUser("octocat", 1, "https://avatars1.githubusercontent.com/u/583231?s=400&v=4", "https://api.github.com/users/octocat"))
                add(GithubUser("sirmeowingtons5", 34872618, "https://avatars1.githubusercontent.com/u/34872618?s=460&v=4", "https://github.com/SirMeowingtons5"))
                add(GithubUser("zerotwoone", 16340616, "https://avatars2.githubusercontent.com/u/16340616?s=460&v=4", "https://github.com/zerotwoone"))
                add(GithubUser("terrakok", 3532155, "https://avatars1.githubusercontent.com/u/3532155?s=460&v=4", "https://github.com/terrakok"))
                add(GithubUser("elizarov", 478679, "https://avatars1.githubusercontent.com/u/478679?s=460&v=4", "https://github.com/elizarov"))
            }
            res
        }
    }
}