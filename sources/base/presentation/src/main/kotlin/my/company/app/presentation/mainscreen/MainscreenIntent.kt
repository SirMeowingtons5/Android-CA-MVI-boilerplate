package my.company.app.presentation.mainscreen

import my.company.app.presentation.base.BaseIntent

sealed class MainscreenIntent : BaseIntent{
    object InitialIntent: MainscreenIntent()
}