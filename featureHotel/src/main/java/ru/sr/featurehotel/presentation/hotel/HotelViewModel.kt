package ru.sr.featurehotel.presentation.hotel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.BaseViewModel
import ru.sr.featurehotel.domen.useCase.GetHotelUseCase
import ru.sr.featurehotel.presentation.model.DescriptionHotel
import ru.sr.featurehotel.presentation.model.Hotel
import ru.sr.featurehotel.presentation.state.HotelState

internal class HotelViewModel(
    private val getHotelUseCase: GetHotelUseCase
) : BaseViewModel<HotelState, HotelState.Content>(HotelState.Loading to HotelState.Content()) {

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            updateState(HotelState.Loading)
            getHotelUseCase.invoke()
                .onSuccess { hotelDM ->
                    val items =
                        listOf(Hotel.fromDomain(hotelDM), DescriptionHotel.fromDomain(hotelDM))
                    updateState(
                        viewState.copy(items = items)
                    )
                }
                .onFailure {
                    updateState(HotelState.Error)
                }
        }

    }
}

