package ru.sr.featurehotel.presentation.room

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.BaseViewModel
import ru.sr.featurehotel.domen.useCase.GetRoomsUseCase
import ru.sr.featurehotel.presentation.model.Room
import ru.sr.featurehotel.presentation.state.RoomState

internal class RoomViewModel(
    private val getRoomsUseCase: GetRoomsUseCase
) : BaseViewModel<RoomState, RoomState.Content>(initViewState = RoomState.Loading to RoomState.Content()) {

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            updateState(RoomState.Loading)
            getRoomsUseCase.invoke()
                .onSuccess { roomsDm ->
                    val rooms = roomsDm.map { roomDM ->
                        Room.fromDomain(roomDM)
                    }
                    updateState(viewState.copy(rooms = rooms))
                }
                .onFailure {
                    updateState(RoomState.Error)
                }
        }

    }

}

