package ru.sr.featurehotel.presentation.hotel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.BaseFragment
import ru.sr.featurehotel.databinding.FragmentHotelBinding

class HotelFragment : BaseFragment<FragmentHotelBinding>() {

    private val viewModel by viewModel<HotelViewModel>()

    override fun initBinding(inflater: LayoutInflater): FragmentHotelBinding {
        return FragmentHotelBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}