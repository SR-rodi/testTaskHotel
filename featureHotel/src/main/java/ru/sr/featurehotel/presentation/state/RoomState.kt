package ru.sr.featurehotel.presentation.state

import ru.ContentViewState
import ru.ViewState
import ru.sr.featurehotel.presentation.model.Room

sealed interface RoomState : ViewState {
    object Loading : RoomState
    object Error : RoomState
    data class Content(val rooms: List<Room> = emptyList()) : RoomState, ContentViewState

}