package my.company.app.presentation.launcher

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.launch
import my.company.app.presentation.basic.IntentViewModel
import my.company.app.presentation.navigation.Screens
import ru.terrakok.cicerone.Router

class LauncherViewModel(private val router: Router): IntentViewModel<LauncherIntent, LauncherViewState>(){
    override fun processIntents(intents: ReceiveChannel<LauncherIntent>) {
        GlobalScope.launch(Dispatchers.Main){
            for (intent in intents){
                when(intent){
                    is LauncherIntent.InitialIntent ->{
                        router.navigateTo(Screens.Mainscreen.Mainscreen())
                    }
                }
            }
        }
    }

}