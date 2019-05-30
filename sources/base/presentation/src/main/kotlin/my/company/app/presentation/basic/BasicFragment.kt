package my.company.app.presentation.basic

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.android.viewmodel.ext.android.viewModelByClass
import java.lang.reflect.ParameterizedType

abstract class BasicFragment<VM: IntentViewModel<*, *>> : Fragment() {
    @get:LayoutRes
    protected abstract val layoutId: Int

    private fun getClassByReflection(): Class<VM> =
            (javaClass.genericSuperclass as ParameterizedType)
                    .actualTypeArguments.first() as Class<VM>

    protected val viewModel: VM by viewModelByClass(getClassByReflection().kotlin)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId, container, false)
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel
    }
}
