package ru.sr.featurehotel.presentation.hotel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.BaseFragment
import ru.sr.featurehotel.databinding.FragmentHotelBinding
import ru.sr.featurehotel.presentation.state.HotelState

class HotelFragment : BaseFragment<FragmentHotelBinding>() {

    private val viewModel by viewModel<HotelViewModel>()

    override fun initBinding(inflater: LayoutInflater): FragmentHotelBinding {
        return FragmentHotelBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        flowObserver(viewModel.viewState()) { state ->
            observeViewState(state as HotelState)
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun observeViewState(state: HotelState) {
        when (state) {
            is HotelState.Content -> {
                binding.hotelRecyclerView.adapter = HotelAdapter().apply {
                    submitList(state.items)
                }
            }

            HotelState.Error -> {}
            HotelState.Loading -> {}
        }
    }
}