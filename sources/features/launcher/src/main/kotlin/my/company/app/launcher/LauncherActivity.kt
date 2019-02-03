package my.company.app.launcher

import android.os.Bundle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import my.company.app.presentation.basic.BasicActivity
import my.company.app.presentation.launcher.LauncherIntent
import my.company.app.presentation.launcher.LauncherViewModel
import my.company.app.presentation.navigation.MainscreenNavigationAction
import my.company.app.presentation.navigation.Screens
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.commands.Forward

class LauncherActivity : BasicActivity<LauncherViewModel>() {
    private val intentChannel = Channel<LauncherIntent>()
    private val mainscreenNavigationAction : MainscreenNavigationAction by inject()

    override val navigator = Navigator { commands ->
        commands.forEach {
            when (it) {
                is Forward -> {
                    finish()
                    when (it.screen) {
                        is Screens.Mainscreen.Mainscreen ->{
                            startActivity(mainscreenNavigationAction.provideIntent(this))
                        }
                    }
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.processIntents(intentChannel)
        GlobalScope.launch(Dispatchers.Main){
            intentChannel.send(LauncherIntent.InitialIntent)
        }
    }

    override fun onDestroy() {
        intentChannel.close()
        super.onDestroy()

    }
}
