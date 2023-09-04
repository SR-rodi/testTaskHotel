package ru.sr.featurehotel.presentation.hotel.adapter

import android.view.LayoutInflater
import androidx.core.view.setPadding
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import ru.sr.adapter.adapterDelegate
import ru.sr.featurehotel.R
import ru.sr.featurehotel.databinding.ItemDescriptionHotelBinding
import ru.sr.featurehotel.databinding.ItemTagBinding
import ru.sr.featurehotel.databinding.ItemTitleHotelBinding
import ru.sr.featurehotel.presentation.model.DescriptionHotel
import ru.sr.featurehotel.presentation.model.Hotel

fun hotelDelegate() = adapterDelegate<Any, Hotel, ItemTitleHotelBinding>({ parent ->
    ItemTitleHotelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
}) {
    bind {

        val adapter = PagerAdapter()
        adapter.setItems(item.images)
        binding.ViewPager.setAdapter(adapter = adapter as? RecyclerView.Adapter<RecyclerView.ViewHolder>)

        binding.ratingName.setRating(
            ratingNumber = item.rating.toString(),
            ratingName = item.ratingName
        )

        binding.hotelName.text = item.name
        binding.tags.text = item.address
        binding.price.setPrice(
            price = item.minPrice.toString(),
            description = item.priceForIt
        )
    }
}

fun hotelDescriptionDelegate() =
    adapterDelegate<Any, DescriptionHotel, ItemDescriptionHotelBinding>({ parent ->
        ItemDescriptionHotelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }) {



        bind {
            binding.description.text = item.description

            item.peculiarities.forEach{
                val chip  = Chip(binding.chipGroup.context) .apply {
                   chipBackgroundColor = binding.chipGroup.context.getColorStateList(ru.sr.coreui.R.color.chips_color)
                   setTextColor(binding.chipGroup.context.getColor(ru.sr.coreui.R.color.subtitle))
                   isCloseIconVisible = false
                   chipStrokeWidth = 0f
                   text = it
                }
                binding.chipGroup.addView(chip)
            }
        }
    }

fun tagDelegate() =
    adapterDelegate<Any, String, ItemTagBinding>({ parent ->
        ItemTagBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }) {
        bind {
            binding.text.text = item
        }
    }