package ru.sr.featurehotel.presentation.state

import ru.ContentViewState
import ru.ViewState
import ru.sr.featurehotel.presentation.model.DescriptionHotel
import ru.sr.featurehotel.presentation.model.Hotel
import ru.sr.featurehotel.presentation.model.HotelInfo

sealed interface HotelState : ViewState {
    object Loading : HotelState
    object Error : HotelState
    data class Content(val items: List<HotelInfo> = emptyList()) : HotelState, ContentViewState
}