package  my.company.app.mainscreen

import android.os.Bundle
import android.support.v4.app.Fragment
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import my.company.app.mainscreen.github.GithubPageFragment
import my.company.app.presentation.basic.BasicActivity
import my.company.app.presentation.mainscreen.MainscreenIntent
import my.company.app.presentation.mainscreen.MainscreenViewModel
import my.company.app.presentation.navigation.Screens
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.android.support.SupportAppScreen

class MainActivity : BasicActivity<MainscreenViewModel>() {

    private val intentChannel = Channel<MainscreenIntent>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.processIntents(intentChannel)
        sendIntent(MainscreenIntent.InitialIntent)
    }

    override val navigator = object : SupportAppNavigator(this, R.id.frameLayout){
        override fun createFragment(screen: SupportAppScreen): Fragment{
            return when(screen){
                is Screens.Mainscreen.GithubPage ->{
                    GithubPageFragment()
                }
                else ->{
                    throw RuntimeException("Can't create a screen: ${screen.screenKey}")
                }
            }
        }
    }

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
