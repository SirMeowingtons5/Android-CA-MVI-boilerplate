package my.company.app.presentation.mainscreen.githubpage

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.launch
import my.company.app.domain.entity.GithubUser
import my.company.app.domain.usecase.GetGithubTopUsersUseCase
import my.company.app.presentation.basic.IntentViewModel
import my.company.app.presentation.mainscreen.githubpage.model.GithubUserView
import timber.log.Timber

class GithubPageViewModel(private val getGithubTopUsersUseCase: GetGithubTopUsersUseCase):
        IntentViewModel<GithubPageIntent, GithubPageViewState>() {

    override fun processIntents(intents: ReceiveChannel<GithubPageIntent>) {
        GlobalScope.launch(Dispatchers.Main){
            for(intent in intents){
                val action = intentToAction(intent)
                when (action){
                    is GithubPageAction.InitialAction ->{}
                    is GithubPageAction.LoadTopUsersAction ->{
                        Timber.d("Loading top users")
                        actor.send(GithubPageViewState.GithubUsersUiModel.InProgress)
                        try{
                            val res = GithubPageViewState
                                    .GithubUsersUiModel
                                    .Success(getGithubTopUsersUseCase.get()
                                            .map { mapFromEntity(it) })
                            actor.send(res)
                            Timber.d("Users loaded. Number: ${res.users?.size}")
                        }catch (e: Exception){
                            actor.send(GithubPageViewState.GithubUsersUiModel.Failed)
                        }
                    }
                }
            }
        }
    }


    private fun intentToAction(intent: GithubPageIntent): GithubPageAction{
        return when(intent){
            is GithubPageIntent.InitialIntent ->{
                GithubPageAction.InitialAction
            }
            is GithubPageIntent.LoadTopUsersIntent,
                GithubPageIntent.RefreshTopUsersIntent ->{
                GithubPageAction.LoadTopUsersAction
            }
        }
    }

    private fun mapFromEntity(type: GithubUser): GithubUserView {
        return GithubUserView(type.login, type.avatar, type.url)
    }
}