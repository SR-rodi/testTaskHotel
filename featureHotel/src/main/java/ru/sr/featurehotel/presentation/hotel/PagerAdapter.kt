package ru.sr.featurehotel.presentation.hotel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.sr.featurehotel.databinding.ItemPagerHotelBinding
import ru.sr.load

class PagerAdapter : RecyclerView.Adapter<HotelViewHolder>() {

    private var items: List<String> = emptyList()
    fun setItems(listItems: List<String>) {
        items = listItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        return HotelViewHolder.create(parent)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        holder.bind(items[position])
    }
}

class HotelViewHolder(
    private val binding: ItemPagerHotelBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: String) {
        binding.image.load(item)
    }

    companion object {
        fun create(parent: ViewGroup): HotelViewHolder {
            return HotelViewHolder(
                binding = ItemPagerHotelBinding
                    .inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
            )

        }
    }
}