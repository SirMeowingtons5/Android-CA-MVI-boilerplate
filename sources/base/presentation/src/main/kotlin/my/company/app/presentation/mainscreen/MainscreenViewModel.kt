package my.company.app.presentation.mainscreen

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.launch
import my.company.app.presentation.basic.IntentViewModel
import ru.terrakok.cicerone.Router

class MainscreenViewModel(private val router: Router): IntentViewModel<MainscreenIntent, MainscreenViewState>() {
    override val actor: Channel<MainscreenViewState> = Channel()

    fun reduce(action: MainscreenIntent, state: MainscreenViewState): MainscreenViewState {
        return MainscreenViewState.Loaded
    }

    override fun processIntents(intents: ReceiveChannel<MainscreenIntent>) {
        GlobalScope.launch(Dispatchers.Main){
            for(intent in intents){
                when(intent){
                    is MainscreenIntent.InitialIntent ->{

                    }
                }
            }
        }
    }

    override fun states(): ReceiveChannel<MainscreenViewState> {
        return actor
    }
}