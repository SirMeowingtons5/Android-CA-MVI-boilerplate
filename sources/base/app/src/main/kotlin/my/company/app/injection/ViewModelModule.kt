package my.company.app.injection

import my.company.app.presentation.launcher.LauncherViewModel
import my.company.app.presentation.mainscreen.MainscreenViewModel
import org.koin.android.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module

val ViewModelModule = module {
    viewModel<LauncherViewModel>()
    viewModel<MainscreenViewModel>()
}