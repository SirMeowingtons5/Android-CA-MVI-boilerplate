package my.company.app.presentation.launcher

import my.company.app.presentation.base.BaseViewState

sealed class LauncherViewState: BaseViewState {
    object Loaded: LauncherViewState()
}