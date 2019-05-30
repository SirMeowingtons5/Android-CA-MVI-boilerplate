package my.company.app.mainscreen.injection

import my.company.app.mainscreen.github.GithubPageFragment
import my.company.app.presentation.navigation.mainscreen.GithubPageNavigationAction

internal class GithubPageNavigationActionImpl: GithubPageNavigationAction {
    override fun provideFragment() = GithubPageFragment()
}