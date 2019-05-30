package my.company.app.domain.usecase

import my.company.app.domain.entity.GithubUser

interface GetGithubTopUsersUseCase{
    suspend fun get(): List<GithubUser>
}