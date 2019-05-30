package my.company.app.presentation.inject

import my.company.app.presentation.navigation.ScreenProvider
import org.koin.dsl.module.module

val PresentationModule = module {
    single { ScreenProvider(get(), get()) }
}