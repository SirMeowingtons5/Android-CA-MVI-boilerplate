package my.company.app.mainscreen.injection

import my.company.app.presentation.navigation.mainscreen.GithubPageNavigationAction
import my.company.app.presentation.navigation.mainscreen.MainscreenNavigationAction
import org.koin.dsl.module.module

val MainscreenModule = module{
    factory { MainscreenNavigationActionImpl() } bind MainscreenNavigationAction::class
    factory { GithubPageNavigationActionImpl() } bind GithubPageNavigationAction::class
}