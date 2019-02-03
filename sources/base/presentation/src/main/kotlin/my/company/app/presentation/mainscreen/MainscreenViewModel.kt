package my.company.app.presentation.mainscreen

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.launch
import my.company.app.presentation.basic.IntentViewModel
import my.company.app.presentation.navigation.Screens
import ru.terrakok.cicerone.Router

class MainscreenViewModel(private val router: Router): IntentViewModel<MainscreenIntent, MainscreenViewState>() {

    override fun processIntents(intents: ReceiveChannel<MainscreenIntent>) {
        GlobalScope.launch(Dispatchers.Main){
            for(intent in intents){
                val action = intentToAction(intent)
                when(action){
                    is MainscreenAction.InitialAction ->{
                        router.newRootScreen(Screens.Mainscreen.GithubPage())
                    }
                }
            }
        }
    }

    private fun intentToAction(intent: MainscreenIntent): MainscreenAction{
        return when(intent){
            is MainscreenIntent.InitialIntent ->{
                MainscreenAction.InitialAction
            }
        }
    }
}