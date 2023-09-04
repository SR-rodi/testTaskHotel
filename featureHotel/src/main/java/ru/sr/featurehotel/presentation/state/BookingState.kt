package ru.sr.featurehotel.presentation.state

import ru.ContentViewState
import ru.ViewState
import ru.sr.featurehotel.presentation.model.Booking
import ru.sr.featurehotel.presentation.model.HotelInfo

sealed interface BookingState : ViewState {
    object Loading : BookingState
    object Error : BookingState
    data class Content(
        val booking: List<HotelInfo> = emptyList()
    ) : BookingState, ContentViewState
}