package ru.sr.featurehotel.presentation.booking

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.BaseViewModel
import ru.sr.featurehotel.domen.useCase.GetBookingUseCase
import ru.sr.featurehotel.presentation.model.HotelSmallInfo
import ru.sr.featurehotel.presentation.model.Tour
import ru.sr.featurehotel.presentation.model.User
import ru.sr.featurehotel.presentation.model.UserConnection
import ru.sr.featurehotel.presentation.model.Users
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
                    val users = Users(listOf(User(), User()))

                    val info = listOf(
                        HotelSmallInfo.fromDomain(bookingDM),
                        Tour.fromDomain(bookingDM),
                        UserConnection(),
                        users
                    )
                    updateState(
                        viewState.copy(booking = info)
                    )
                }.onFailure {
                    updateState(BookingState.Error)
                }
        }
    }

    fun onClickUser(bookingItemId: Int, userItemId: Int) {
        val items = viewState.booking.toMutableList()
        val users = items[bookingItemId] as? Users
        users?.let {
            val newUsers = users.items.toMutableList()
            val user = newUsers[userItemId]
            val rotation = if (user.isExpected) -90f else 90f
            val newUser = user.copy(isExpected = !user.isExpected, rotationArrow = rotation)
            newUsers[userItemId] = newUser
            items[bookingItemId] = users.copy(items = newUsers)
        }

        updateState(viewState.copy(booking = items))

    }
}

