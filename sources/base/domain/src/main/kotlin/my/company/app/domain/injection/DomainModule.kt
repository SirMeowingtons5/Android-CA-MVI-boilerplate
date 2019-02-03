package my.company.app.domain.injection

import my.company.app.domain.usecase.GetGithubTopUsersUseCase
import my.company.app.domain.usecase.implementation.FetchGithubTopUsers
import org.koin.dsl.module.module

val DomainModule = module {
    factory { FetchGithubTopUsers() } bind GetGithubTopUsersUseCase::class
}