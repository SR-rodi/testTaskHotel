package ru.sr.featurehotel.presentation.state

import ru.ContentViewState
import ru.ViewState
import ru.sr.featurehotel.presentation.model.Hotel

sealed interface HotelState : ViewState {
    object Loading : HotelState
    object Error : HotelState
    data class Content(val hotel: Hotel = Hotel()) : HotelState, ContentViewState
}