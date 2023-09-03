package ru

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import androidx.viewbinding.ViewBindings
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import ru.sr.core.databinding.FragmentBaseBinding

abstract class BaseFragment<Binding : ViewBinding> : Fragment() {

    private var _binding: Binding? = null
    protected val binding get() = _binding!!

    abstract fun initBinding(inflater: LayoutInflater): Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return initBinding(inflater).root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}

abstract class BaseViewModel<State : ViewState, ContentState : ContentViewState>(initViewState: Pair<ViewState, ContentState>) :
    ViewModel() {

    private val _viewState = MutableStateFlow(initViewState.first)
    var viewState: ContentState = initViewState.second
        private set

    fun updateState(newState: ViewState) {
        if (newState is ContentViewState) viewState = newState as ContentState
        _viewState.value = newState

    }

}

interface ViewState
interface ContentViewState : ViewState