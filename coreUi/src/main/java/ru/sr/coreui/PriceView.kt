package ru.sr.coreui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import ru.sr.coreui.databinding.HotelPriceViewBinding
import ru.sr.coreui.databinding.ViewPagerDotsBinding

class PriceView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private var binding: HotelPriceViewBinding? =
        HotelPriceViewBinding.inflate(LayoutInflater.from(context))

    init {
        addView(binding?.root)
    }

    fun setPrice(price: String, description: String, isVisiblePrefix: Boolean = true) {
        binding?.prefix?.isVisible = isVisiblePrefix
        binding?.price?.text = price
        binding?.description?.text = description
    }

    override fun onDetachedFromWindow() {
        binding = null
        super.onDetachedFromWindow()
    }

}