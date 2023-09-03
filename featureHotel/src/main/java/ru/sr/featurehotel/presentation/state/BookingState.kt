package ru.sr.featurehotel.presentation.state

import ru.ContentViewState
import ru.ViewState
import ru.sr.featurehotel.presentation.model.Booking

sealed interface BookingState : ViewState {
    object Loading : BookingState
    object Error : BookingState
    data class Content(
        val booking: Booking = Booking()
    ) : BookingState, ContentViewState
}