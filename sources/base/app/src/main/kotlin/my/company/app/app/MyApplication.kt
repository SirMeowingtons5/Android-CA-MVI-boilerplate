package my.company.app.app

import android.app.Application
import my.company.app.domain.injection.DomainModule
import my.company.app.app.injection.RouterModule
import my.company.app.presentation.inject.ViewModelModule
import my.company.app.data.injection.DataModule
import my.company.app.mainscreen.injection.MainscreenModule
import my.company.app.presentation.inject.PresentationModule
import org.koin.android.BuildConfig
import org.koin.android.ext.android.startKoin
import timber.log.Timber

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, koinModules)
        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }

    companion object {
        val koinModules = listOf(RouterModule, MainscreenModule, ViewModelModule, PresentationModule, DomainModule, DataModule)
    }
}