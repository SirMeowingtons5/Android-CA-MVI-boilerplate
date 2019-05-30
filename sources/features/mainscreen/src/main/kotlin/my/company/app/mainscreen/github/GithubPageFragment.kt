package my.company.app.mainscreen.github

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.fragment_github.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import my.company.app.mainscreen.R
import my.company.app.presentation.basic.BasicFragment
import my.company.app.presentation.mainscreen.githubpage.GithubPageIntent
import my.company.app.presentation.mainscreen.githubpage.GithubPageViewModel
import my.company.app.presentation.mainscreen.githubpage.GithubPageViewState
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.toast
import timber.log.Timber

class GithubPageFragment : BasicFragment<GithubPageViewModel>() {
    override val layoutId = R.layout.fragment_github
    private val intentChannel = Channel<GithubPageIntent>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.processIntents(intentChannel)
        subscribeForStateUpdates()
        recycler.layoutManager = LinearLayoutManager(this.context)
        sendIntent(GithubPageIntent.InitialIntent)
        loadButton.onClick {
            sendIntent(GithubPageIntent.LoadTopUsersIntent)
        }
    }

    private fun subscribeForStateUpdates() {
        GlobalScope.launch(Dispatchers.Main) {
            for (state in viewModel.states()) {
                when (state) {
                    is GithubPageViewState.GithubUsersUiModel -> {
                        when (state) {
                            is GithubPageViewState.GithubUsersUiModel.InProgress -> {
                                Timber.d("State: In progress")
                            }
                            is GithubPageViewState.GithubUsersUiModel.Success -> {
                                Timber.d("State: Success. Res number is: ${state.users?.size}")
                                state.users?.let { usersList ->
                                    recycler.adapter = GithubUsersAdapter(usersList) {
                                        toast("Link: ${it.url}")
                                    }
                                }
                            }
                            is GithubPageViewState.GithubUsersUiModel.Failed -> {
                                Timber.d("State: Failed")
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        intentChannel.close()
        super.onDestroyView()
    }

    private fun sendIntent(intent: GithubPageIntent) {
        GlobalScope.launch {
            Timber.d("Sending intent")
            intentChannel.send(intent)
        }
    }
}