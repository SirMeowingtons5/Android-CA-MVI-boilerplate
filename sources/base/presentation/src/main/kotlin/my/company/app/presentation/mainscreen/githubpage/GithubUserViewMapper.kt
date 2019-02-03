package my.company.app.presentation.mainscreen.githubpage

import my.company.app.domain.model.GithubUser
import my.company.app.presentation.base.Mapper
import my.company.app.presentation.mainscreen.githubpage.model.GithubUserView

class GithubUserViewMapper: Mapper<GithubUser, GithubUserView>{
    override fun mapFromEntity(type: GithubUser): GithubUserView {
        return GithubUserView(type.login, type.avatar, type.url)
    }
}