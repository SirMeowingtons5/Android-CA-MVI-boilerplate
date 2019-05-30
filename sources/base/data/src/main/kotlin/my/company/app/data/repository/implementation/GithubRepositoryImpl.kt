package my.company.app.data.repository.implementation

import my.company.app.data.repository.GithubRepository
import my.company.app.data.repository.mapper.GithubUserMapper
import my.company.app.data.repository.remote.rest.GithubRestApi
import my.company.app.domain.model.GithubUser

internal class GithubRepositoryImpl(private val githubRestApi: GithubRestApi): GithubRepository {
    private val mapper = GithubUserMapper()

    override fun getTopUsers(): List<GithubUser> {
        //TODO: use proper exception
        return githubRestApi.getTopUsers().execute().body()?.map { mapper.fromEntity(it) } ?: throw Exception()
    }

}