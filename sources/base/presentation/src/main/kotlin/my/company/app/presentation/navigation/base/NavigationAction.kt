package my.company.app.presentation.navigation.base

import android.content.Context
import android.content.Intent

interface NavigationAction {
    fun provideIntent(context: Context): Intent
}