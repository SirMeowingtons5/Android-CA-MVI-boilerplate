package my.company.app.presentation.navigation

import android.content.Context
import my.company.app.presentation.navigation.mainscreen.GithubPageNavigationAction
import my.company.app.presentation.navigation.mainscreen.MainscreenNavigationAction
import org.koin.standalone.KoinComponent
import ru.terrakok.cicerone.android.support.SupportAppScreen


class ScreenProvider(
        private val mainscreenNavigationAction: MainscreenNavigationAction,
        private val githubPageNavigationAction: GithubPageNavigationAction){

    inner class Mainscreen: SupportAppScreen(){
        override fun getActivityIntent(context: Context)
                = mainscreenNavigationAction.provideIntent(context)
    }

    inner class GithubPage: SupportAppScreen(){
        override fun getFragment()
                = githubPageNavigationAction.provideFragment()
    }
}