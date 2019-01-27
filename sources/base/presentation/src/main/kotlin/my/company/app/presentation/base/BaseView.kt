package my.company.app.presentation.base

import kotlinx.coroutines.channels.SendChannel

interface BaseView<I : BaseIntent, in S : BaseViewState> {
    fun intents(): SendChannel<I>

    fun render(state: S)
}