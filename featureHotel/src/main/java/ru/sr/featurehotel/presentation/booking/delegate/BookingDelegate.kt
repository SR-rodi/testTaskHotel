package ru.sr.featurehotel.presentation.booking.delegate

import android.content.ClipData.Item
import android.util.Log
import android.view.LayoutInflater
import androidx.core.view.isVisible
import ru.sr.adapter.adapterDelegate
import ru.sr.featurehotel.databinding.ItemSmalInfoHotelBinding
import ru.sr.featurehotel.databinding.ItemTourBinding
import ru.sr.featurehotel.databinding.ItemUserConnectionBinding
import ru.sr.featurehotel.databinding.ItemUserInfoBinding
import ru.sr.featurehotel.databinding.ItemUsersBinding
import ru.sr.featurehotel.presentation.hotel.adapter.BookingAdapter
import ru.sr.featurehotel.presentation.hotel.adapter.HotelAdapter
import ru.sr.featurehotel.presentation.model.HotelSmallInfo
import ru.sr.featurehotel.presentation.model.Tour
import ru.sr.featurehotel.presentation.model.User
import ru.sr.featurehotel.presentation.model.UserConnection
import ru.sr.featurehotel.presentation.model.Users

fun bookingDelegate() = adapterDelegate<Any, HotelSmallInfo, ItemSmalInfoHotelBinding>({ parent ->
    ItemSmalInfoHotelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
}) {

    bind {

        binding.hotelName.text = item.hotelName
        binding.ratingName.setRating(item.rating, item.ratingName)
        binding.address.text = item.hotelAddress

    }

}

fun tourDataDelegate() = adapterDelegate<Any, Tour, ItemTourBinding>({ parent ->
    ItemTourBinding.inflate(LayoutInflater.from(parent.context), parent, false)
}) {

    bind {

        binding.nutrition.text = item.nutrition
        binding.departure.text = item.departure
        binding.country.text = item.country
        binding.date.text = item.date
        binding.numberOfNights.text = item.numberOfNights
        binding.hotel.text = item.hotelName
        binding.room.text = item.room

    }

}

fun userConnectionDelegate() =
    adapterDelegate<Any, UserConnection, ItemUserConnectionBinding>({ parent ->
        ItemUserConnectionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }) {

        bind {
        }

    }

fun usersDelegate(onItemClick: (Int, Int) -> Unit) =
    adapterDelegate<Any, Users, ItemUsersBinding>({ parent ->
        ItemUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }) {

        bind {
            val adapter = BookingAdapter(
                onUserClick = { _, userId ->
                    onItemClick.invoke(absoluteAdapterPosition, userId)
                }
            ).apply {
                submitList(item.items)
            }
            Log.e("kart", item.items.size.toString())
            binding.usersRecycler.adapter = adapter
        }
    }

fun userDelegate(onItemClick: (Int,Int) -> Unit) =
    adapterDelegate<Any, User, ItemUserInfoBinding>({ parent ->
        ItemUserInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }) {

        binding.arrow.setOnClickListener {
            onItemClick.invoke(0,bindingAdapterPosition)
        }

        bind {
            binding.expandedUser.isVisible = item.isExpected
            binding.arrow.rotation = item.rotationArrow
        }
    }