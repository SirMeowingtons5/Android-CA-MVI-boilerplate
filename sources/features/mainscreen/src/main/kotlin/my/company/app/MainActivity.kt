package  my.company.app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import my.company.app.presentation.basic.BasicActivity
import my.company.app.presentation.mainscreen.MainscreenViewModel
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : BasicActivity<MainscreenViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override val navigator = Navigator{}
    /*override val navigator = SupportAppNavigator(this, R.id.frameLayout){

    }*/
}
