package my.company.app.presentation.mainscreen

import my.company.app.presentation.base.BaseViewState

sealed class MainscreenViewState: BaseViewState{
    object Loaded: MainscreenViewState()
}