package my.company.app.data.gateway

import my.company.app.data.repository.GithubRepository
import my.company.app.domain.gateway.GithubGateway
import my.company.app.domain.entity.GithubUser

internal class GithubGatewayImpl(private val githubRepository: GithubRepository): GithubGateway {
    override suspend fun getGithubTopUsers(): List<GithubUser>{
        return githubRepository.getTopUsers()
    }
}