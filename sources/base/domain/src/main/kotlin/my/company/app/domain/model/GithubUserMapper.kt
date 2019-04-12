package my.company.app.domain.model

import my.company.app.data.model.GithubUserEntity

class GithubUserMapper {
    fun fromEntity(entity: GithubUserEntity): GithubUser{
        return GithubUser(entity.login, entity.id, entity.avatar, entity.url)
    }
}