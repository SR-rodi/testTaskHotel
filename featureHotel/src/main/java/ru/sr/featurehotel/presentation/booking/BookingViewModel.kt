package ru.sr.featurehotel.presentation.booking

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.BaseViewModel
import ru.sr.featurehotel.domen.useCase.GetBookingUseCase
import ru.sr.featurehotel.presentation.model.Booking
import ru.sr.featurehotel.presentation.state.BookingState

internal class BookingViewModel(
    private val getBookingUseCase: GetBookingUseCase
) : BaseViewModel<BookingState, BookingState.Content>(initViewState = BookingState.Loading to BookingState.Content()) {

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            updateState(BookingState.Loading)
            getBookingUseCase.invoke()
                .onSuccess { bookingDM ->
                    updateState(
                        viewState.copy(
                            booking = Booking.fromDomain(bookingDM)
                        )
                    )
                }.onFailure {
                    updateState(BookingState.Error)
                }
        }
    }
}

