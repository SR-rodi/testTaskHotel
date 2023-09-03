package ru.sr.featurehotel.presentation.room

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.BaseFragment
import ru.sr.featurehotel.databinding.FragmentRoomBinding

class RoomFragment : BaseFragment<FragmentRoomBinding>() {

    private val viewModel by viewModel<RoomViewModel> ()

    override fun initBinding(inflater: LayoutInflater): FragmentRoomBinding {
        return FragmentRoomBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}