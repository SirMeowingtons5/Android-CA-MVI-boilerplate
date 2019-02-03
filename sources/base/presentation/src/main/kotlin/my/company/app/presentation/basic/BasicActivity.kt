package my.company.app.presentation.basic

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v7.app.AppCompatActivity
import kotlinx.coroutines.channels.Channel
import my.company.app.presentation.base.BaseIntent
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModelByClass
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import java.lang.reflect.ParameterizedType

abstract class BasicActivity<VM: IntentViewModel<*, *>>: AppCompatActivity() {
    private fun getClassByReflection(): Class<VM> =
            (javaClass.genericSuperclass as ParameterizedType)
                    .actualTypeArguments.first() as Class<VM>

    protected val viewModel : VM by viewModelByClass(getClassByReflection().kotlin)

    protected val navigationHolder: NavigatorHolder by inject()

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel
    }

    @CallSuper
    override fun onResume() {
        super.onResume()
        navigationHolder.setNavigator(navigator)
    }

    @CallSuper
    override fun onPause() {
        super.onPause()
        navigationHolder.removeNavigator()
    }

    protected abstract val navigator: Navigator
}