package my.company.app.launcher

import android.os.Bundle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import my.company.app.coreui.basic.BasicActivity
import my.company.app.presentation.launcher.LauncherIntent
import my.company.app.presentation.launcher.LauncherViewModel
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class LauncherActivity : BasicActivity<LauncherViewModel>() {
    private val intentChannel = Channel<LauncherIntent>()

    override val navigator = SupportAppNavigator(this, R.id.frameLayout)

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
