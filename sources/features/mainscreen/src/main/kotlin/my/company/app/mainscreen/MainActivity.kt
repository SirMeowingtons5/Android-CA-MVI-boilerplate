package  my.company.app.mainscreen

import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import my.company.app.coreui.basic.BasicActivity
import my.company.app.presentation.mainscreen.MainscreenIntent
import my.company.app.presentation.mainscreen.MainscreenViewModel
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : BasicActivity<MainscreenViewModel>() {

    private val intentChannel = Channel<MainscreenIntent>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.processIntents(intentChannel)
        sendIntent(MainscreenIntent.InitialIntent)
    }

    override val navigator: Navigator = SupportAppNavigator(this, R.id.frameLayout)

    override fun onDestroy() {
        intentChannel.close()
        super.onDestroy()
    }

    private fun sendIntent(intent: MainscreenIntent){
        GlobalScope.launch {
            intentChannel.send(intent)
        }
    }
}
