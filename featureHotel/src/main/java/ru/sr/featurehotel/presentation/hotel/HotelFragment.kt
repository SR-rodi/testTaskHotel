package ru.sr.featurehotel.presentation.hotel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.BaseFragment
import ru.sr.featurehotel.R
import ru.sr.featurehotel.databinding.FragmentHotelBinding
import ru.sr.featurehotel.presentation.hotel.adapter.HotelAdapter
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
                binding.nextButton.setOnClickListener {
                    findNavController().navigate(R.id.action_hotelFragment_to_roomFragment)
                }
            }

            HotelState.Error -> {}
            HotelState.Loading -> {}
        }
    }
}