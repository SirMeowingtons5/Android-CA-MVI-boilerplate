package my.company.app.app.injection

import my.company.app.presentation.launcher.LauncherViewModel
import my.company.app.presentation.mainscreen.MainscreenViewModel
import my.company.app.presentation.mainscreen.githubpage.GithubPageViewModel
import org.koin.android.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module

val ViewModelModule = module {
    viewModel<LauncherViewModel>()
    viewModel<MainscreenViewModel>()
    viewModel<GithubPageViewModel>()
}