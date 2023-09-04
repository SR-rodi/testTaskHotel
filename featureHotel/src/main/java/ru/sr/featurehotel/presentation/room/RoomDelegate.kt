package ru.sr.featurehotel.presentation.room

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView

import com.google.android.material.chip.Chip
import ru.sr.adapter.adapterDelegate
import ru.sr.featurehotel.databinding.ItemRoomBinding
import ru.sr.featurehotel.presentation.hotel.adapter.PagerAdapter
import ru.sr.featurehotel.presentation.model.Room

fun roomDelegate(onClick: (Int) -> Unit) = adapterDelegate<Any, Room, ItemRoomBinding>({ parent ->
    ItemRoomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
}) {

    binding.nextButton.setOnClickListener{
        onClick(bindingAdapterPosition)
    }

    bind {

        val adapter = PagerAdapter().apply {
            setItems(item.images)
        }

        binding.ViewPager.setAdapter(adapter as? RecyclerView.Adapter<RecyclerView.ViewHolder>)

        item.peculiarities.forEach {
            val chip = Chip(binding.chipGroup.context).apply {
                chipBackgroundColor =
                    binding.chipGroup.context.getColorStateList(ru.sr.coreui.R.color.chips_color)
                setTextColor(binding.chipGroup.context.getColor(ru.sr.coreui.R.color.subtitle))
                isCloseIconVisible = false
                chipStrokeWidth = 0f
                text = it
            }
            binding.chipGroup.addView(chip)
        }

        binding.title.text = item.name
        binding.price.setPrice(
            price = item.price.toString(),
            description = item.pricePer,
            isVisiblePrefix = false
        )

    }
}