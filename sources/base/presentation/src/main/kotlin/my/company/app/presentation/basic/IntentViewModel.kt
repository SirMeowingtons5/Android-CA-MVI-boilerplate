package my.company.app.presentation.basic

import android.arch.lifecycle.ViewModel
import android.support.annotation.CallSuper
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import my.company.app.presentation.base.BaseIntent
import my.company.app.presentation.base.BaseViewModel
import my.company.app.presentation.base.BaseViewState
import my.company.app.presentation.navigation.ScreenProvider
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

abstract class IntentViewModel<I : BaseIntent, S : BaseViewState>
    : ViewModel(), BaseViewModel<I, S>, KoinComponent{

    protected val screenProvider: ScreenProvider by inject()

    protected val actor : Channel<S> = Channel()

    override fun states(): ReceiveChannel<S> = actor

    @CallSuper
    override fun onCleared() {
        actor.close()
    }
}