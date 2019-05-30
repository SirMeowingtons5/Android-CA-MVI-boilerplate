package my.company.app.presentation.mainscreen

import my.company.app.presentation.base.BaseAction

internal sealed class MainscreenAction: BaseAction {
    object InitialAction: MainscreenAction()
}