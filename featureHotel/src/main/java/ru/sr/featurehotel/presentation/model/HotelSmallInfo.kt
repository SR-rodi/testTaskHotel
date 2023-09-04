package ru.sr.featurehotel.presentation.model

import ru.sr.featurehotel.domen.model.BookingDM

class HotelSmallInfo (
    val hotelAddress:String,
    val ratingName:String,
    val hotelName:String,
    val rating:String
):HotelInfo{
    companion object{
        fun fromDomain(domainModel: BookingDM): HotelSmallInfo {
          return  HotelSmallInfo(
                hotelAddress = domainModel.hotelAddress,
                ratingName = domainModel.ratingName,
                hotelName = domainModel.hotelName,
                rating = domainModel.ratingName
            )
        }
    }

}

