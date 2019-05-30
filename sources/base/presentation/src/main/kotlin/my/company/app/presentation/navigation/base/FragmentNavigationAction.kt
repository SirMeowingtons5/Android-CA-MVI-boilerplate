package my.company.app.presentation.navigation.base

import android.support.v4.app.Fragment

interface FragmentNavigationAction{
    fun provideFragment(): Fragment
}