package my.company.app.presentation.mainscreen.githubpage

import my.company.app.presentation.base.BaseViewState
import my.company.app.presentation.mainscreen.githubpage.model.GithubUserView

sealed class GithubPageViewState: BaseViewState{
    sealed class GithubUsersUiModel(val inProgress: Boolean = false,
                                    val users: List<GithubUserView>? = null): GithubPageViewState(){
        object InProgress: GithubUsersUiModel(true, null)
        object Failed: GithubUsersUiModel()
        data class Success(private val result: List<GithubUserView>): GithubUsersUiModel(false, result)
    }
}