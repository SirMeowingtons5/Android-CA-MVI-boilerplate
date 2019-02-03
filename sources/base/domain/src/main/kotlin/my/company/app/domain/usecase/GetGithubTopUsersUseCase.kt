package my.company.app.domain.usecase

import my.company.app.domain.model.GithubUser

interface GetGithubTopUsersUseCase{
    suspend fun get(): List<GithubUser>
}