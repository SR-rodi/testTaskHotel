package ru.sr.coreui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import ru.sr.coreui.databinding.RatingLabelBinding

class RatingLabel @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private var binding: RatingLabelBinding? =
        RatingLabelBinding.inflate(LayoutInflater.from(context))

    init {
        addView(binding?.root)
    }

    fun setRating(ratingNumber:String,ratingName:String){
        binding?.ratingName?.text = ratingName
        binding?.ratingNumber?.text = ratingNumber
    }

    override fun onDetachedFromWindow() {
        binding = null
        super.onDetachedFromWindow()
    }
}