package ru

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<State : ViewState, ContentState : ContentViewState>(initViewState: Pair<ViewState, ContentState>) :
    ViewModel() {

    private val _viewState = MutableStateFlow(initViewState.first)
    protected var viewState: ContentState = initViewState.second
        private set

    fun viewState() = _viewState.asStateFlow()

    fun updateState(newState: ViewState) {
        if (newState is ContentViewState) viewState = newState as ContentState
        _viewState.value = newState
    }

}

interface ViewState
interface ContentViewState : ViewState