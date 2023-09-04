package ru.sr.featurehotel.presentation.hotel.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import ru.sr.adapter.ListDelegateAdapter
import ru.sr.adapter.RecyclerViewDelegateAdapter
import ru.sr.featurehotel.presentation.booking.delegate.bookingDelegate
import ru.sr.featurehotel.presentation.booking.delegate.tourDataDelegate
import ru.sr.featurehotel.presentation.booking.delegate.userConnectionDelegate
import ru.sr.featurehotel.presentation.booking.delegate.userDelegate
import ru.sr.featurehotel.presentation.booking.delegate.usersDelegate
import ru.sr.featurehotel.presentation.model.Booking
import ru.sr.featurehotel.presentation.room.roomDelegate

class HotelAdapter(
    onClick: (Int) -> Unit = {},
    onUserClick: (Int, Int) -> Unit = { _, _ -> }
) :
    RecyclerViewDelegateAdapter<Any>() {
    init {
        addDelegate(hotelDelegate())
        addDelegate(hotelDescriptionDelegate())
        addDelegate(tagDelegate())
        addDelegate(roomDelegate(onClick))
  /*      addDelegate(bookingDelegate())
        addDelegate(tourDataDelegate())
        addDelegate(userConnectionDelegate())
        addDelegate(usersDelegate(onUserClick))*/
       // addDelegate(userDelegate(onUserClick))
    }
}

class BookingAdapter(
    onClick: (Int) -> Unit = {},
    onUserClick: (Int, Int) -> Unit = { _, _ -> }
    ): ListDelegateAdapter<Any>(BookingDiff()){

    init {
        addDelegate(bookingDelegate())
        addDelegate(tourDataDelegate())
        addDelegate(userConnectionDelegate())
        addDelegate(usersDelegate(onUserClick))
        addDelegate(userDelegate(onUserClick))
    }
}


class BookingDiff():DiffUtil.ItemCallback<Any>(){
    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        return false
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
      return  oldItem == newItem
    }

}