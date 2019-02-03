package my.company.app.presentation.basic

import android.arch.lifecycle.ViewModel
import android.support.annotation.CallSuper
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import my.company.app.presentation.base.BaseAction
import my.company.app.presentation.base.BaseIntent
import my.company.app.presentation.base.BaseViewModel
import my.company.app.presentation.base.BaseViewState

abstract class IntentViewModel<I : BaseIntent, S : BaseViewState> : ViewModel(), BaseViewModel<I, S>{
    protected val actor : Channel<S> = Channel()

    override fun states(): ReceiveChannel<S> = actor

    @CallSuper
    override fun onCleared() {
        actor.close()
    }
}