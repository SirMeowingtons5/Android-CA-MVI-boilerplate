package my.company.app.presentation.launcher

import my.company.app.presentation.base.BaseIntent

sealed class LauncherIntent : BaseIntent {
    object InitialIntent: LauncherIntent()
}