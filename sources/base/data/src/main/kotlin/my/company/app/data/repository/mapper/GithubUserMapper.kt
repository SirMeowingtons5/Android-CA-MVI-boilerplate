package my.company.app.data.repository.mapper

import my.company.app.data.repository.model.RemoteGithubUser
import my.company.app.domain.entity.GithubUser

internal class GithubUserMapper {
    fun fromEntity(entity: RemoteGithubUser): GithubUser {
        return GithubUser(entity.login, entity.id, entity.avatar, entity.url)
    }
}