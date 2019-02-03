package my.company.app.presentation.mainscreen.githubpage

import my.company.app.presentation.base.BaseIntent

sealed class GithubPageIntent: BaseIntent {
    object InitialIntent: GithubPageIntent()
    object LoadTopUsersIntent: GithubPageIntent()
    object RefreshTopUsersIntent: GithubPageIntent()
}