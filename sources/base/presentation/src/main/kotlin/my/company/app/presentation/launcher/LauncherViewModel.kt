package my.company.app.presentation.launcher

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.launch
import my.company.app.presentation.basic.IntentViewModel
import ru.terrakok.cicerone.Router

class LauncherViewModel(private val router: Router) : IntentViewModel<LauncherIntent, LauncherViewState>() {
    override fun processIntents(intents: ReceiveChannel<LauncherIntent>) {
        GlobalScope.launch(Dispatchers.Main) {
            for (intent in intents) {
                when (intentToAction(intent)) {
                    is LauncherAction.InitialAction-> {
                        router.navigateTo(screenProvider.Mainscreen())
                    }
                }
            }
        }
    }

    private fun intentToAction(intent: LauncherIntent): LauncherAction =
            when (intent) {
                is LauncherIntent.InitialIntent -> LauncherAction.InitialAction
            }


}