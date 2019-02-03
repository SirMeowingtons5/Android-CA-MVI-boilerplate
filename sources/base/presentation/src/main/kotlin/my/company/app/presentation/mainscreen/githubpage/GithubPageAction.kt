package my.company.app.presentation.mainscreen.githubpage

import my.company.app.presentation.base.BaseAction

sealed class GithubPageAction: BaseAction {
    object InitialAction: GithubPageAction()
    object LoadTopUsersAction: GithubPageAction()
}