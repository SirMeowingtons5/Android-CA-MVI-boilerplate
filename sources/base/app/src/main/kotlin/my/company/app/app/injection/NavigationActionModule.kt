package my.company.app.app.injection

import my.company.app.mainscreen.injection.MainscreenNavigationActionImpl
import my.company.app.presentation.navigation.MainscreenNavigationAction
import org.koin.dsl.module.module

val NavigationActionModule = module{
    factory{ MainscreenNavigationActionImpl() } bind MainscreenNavigationAction::class
}