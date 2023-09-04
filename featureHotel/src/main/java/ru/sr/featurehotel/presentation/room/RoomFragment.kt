package ru.sr.featurehotel.presentation.room

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.BaseFragment
import ru.ViewState
import ru.sr.featurehotel.R
import ru.sr.featurehotel.databinding.FragmentRoomBinding
import ru.sr.featurehotel.presentation.hotel.adapter.HotelAdapter
import ru.sr.featurehotel.presentation.state.RoomState

class RoomFragment : BaseFragment<FragmentRoomBinding>() {

    private val viewModel by viewModel<RoomViewModel>()

    override fun initBinding(inflater: LayoutInflater): FragmentRoomBinding {
        return FragmentRoomBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbarTitle.text = "Test"

        flowObserver(viewModel.viewState()) { state ->
            stateObserver(state as RoomState)
        }

        binding.toolBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun stateObserver(state: RoomState) {
        when (state) {
            is RoomState.Content -> {
                binding.recyclerView.adapter = HotelAdapter(onClick = {
                    findNavController().navigate(R.id.action_roomFragment_to_bookingFragment)
                }).apply { submitList(state.rooms) }
            }

            RoomState.Error -> {

            }

            RoomState.Loading -> {

            }
        }
    }
}