package my.company.app.data.repository.mapper

import my.company.app.data.repository.model.GithubUserEntity
import my.company.app.domain.model.GithubUser

internal class GithubUserMapper {
    fun fromEntity(entity: GithubUserEntity): GithubUser {
        return GithubUser(entity.login, entity.id, entity.avatar, entity.url)
    }
}