package ru.sr.featurehotel.presentation.hotel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.sr.adapter.RecyclerViewDelegateAdapter
import ru.sr.adapter.adapterDelegate
import ru.sr.featurehotel.databinding.ItemDescriptionHotelBinding
import ru.sr.featurehotel.databinding.ItemTagBinding
import ru.sr.featurehotel.databinding.ItemTitleHotelBinding
import ru.sr.featurehotel.presentation.model.DescriptionHotel
import ru.sr.featurehotel.presentation.model.Hotel
import ru.sr.featurehotel.presentation.model.HotelInfo

fun hotelDelegate() = adapterDelegate<HotelInfo, Hotel, ItemTitleHotelBinding>({ parent ->
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
    adapterDelegate<HotelInfo, DescriptionHotel, ItemDescriptionHotelBinding>({ parent ->
        ItemDescriptionHotelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }) {
        bind {
            binding.description.text = item.description
            val testAdapter = TestAdapter(item.peculiarities)
            binding.tags.adapter = testAdapter
        }
    }

fun tag() =
    adapterDelegate<Any, String, ItemTagBinding>({ parent ->
        ItemTagBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }) {
        bind {

            binding.text.text = item

        }
    }

class HotelAdapter :
    RecyclerViewDelegateAdapter<HotelInfo>() {
    init {
        addDelegate(hotelDelegate())
        addDelegate(hotelDescriptionDelegate())
    }
}

class TestAdapter(private val items:List<String>) :
    RecyclerView.Adapter<TestViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
      return  TestViewHolder(ItemTagBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.bind(item = items[position])
    }
}

class TestViewHolder(private val binding: ItemTagBinding):RecyclerView.ViewHolder(binding.root){

    fun bind(item:String){
        binding.text.text = item
    }
}