package ru.sr.featurehotel.presentation.booking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.BaseFragment
import ru.sr.featurehotel.databinding.FragmentBookingBinding

class BookingFragment : BaseFragment<FragmentBookingBinding>() {

    private val viewModel by viewModel<BookingViewModel>()

    override fun initBinding(inflater: LayoutInflater): FragmentBookingBinding {
        return FragmentBookingBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}