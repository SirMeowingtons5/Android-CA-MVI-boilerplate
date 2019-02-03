package my.company.app.presentation.base

import kotlinx.coroutines.channels.ReceiveChannel

interface BaseViewModel<I : BaseIntent, S : BaseViewState> {

    fun processIntents(intents: ReceiveChannel<I>)

    fun states(): ReceiveChannel<S>


}