package my.company.app.mainscreen.injection

import android.content.Context
import android.content.Intent
import my.company.app.mainscreen.MainActivity
import my.company.app.presentation.navigation.MainscreenNavigationAction
import my.company.app.presentation.utils.intentFor

class MainscreenNavigationActionImpl : MainscreenNavigationAction {
    override fun provideIntent(context: Context): Intent = intentFor<MainActivity>(context)
}