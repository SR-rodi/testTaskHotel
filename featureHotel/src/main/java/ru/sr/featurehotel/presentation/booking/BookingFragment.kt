package ru.sr.featurehotel.presentation.booking

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.BaseFragment
import ru.sr.featurehotel.databinding.FragmentBookingBinding
import ru.sr.featurehotel.presentation.hotel.adapter.BookingAdapter
import ru.sr.featurehotel.presentation.hotel.adapter.HotelAdapter
import ru.sr.featurehotel.presentation.state.BookingState

class BookingFragment : BaseFragment<FragmentBookingBinding>() {

    private val viewModel by viewModel<BookingViewModel>()

    override fun initBinding(inflater: LayoutInflater): FragmentBookingBinding {
        return FragmentBookingBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        flowObserver(viewModel.viewState()) { state ->
            stateObserver(state as BookingState)
        }
    }

    private fun stateObserver(state: BookingState) {
        when (state) {
            is BookingState.Content -> {

                val adapter = BookingAdapter(
                    onUserClick = { bookingItemId, userItemId ->
                        viewModel.onClickUser(bookingItemId, userItemId)
                    },
                ).apply {
                    submitList(state.booking)
                }

                binding.recyclerView.adapter = adapter

            }

            BookingState.Error -> {

            }

            BookingState.Loading -> {

            }
        }
    }

}