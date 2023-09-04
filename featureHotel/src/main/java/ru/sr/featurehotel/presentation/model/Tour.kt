package ru.sr.featurehotel.presentation.model

import ru.sr.featurehotel.domen.model.BookingDM

class Tour(
    val departure: String,
    val country: String,
    val date: String,
    val numberOfNights: String,
    val hotelName: String,
    val nutrition: String,
    val room: String,
) : HotelInfo {
    companion object {
        fun fromDomain(domainModel: BookingDM): Tour {
            return Tour(
                country = domainModel.country,
                departure = domainModel.departure,
                date = domainModel.tourDateStart + "-" + domainModel.tourDateStop,
                numberOfNights = domainModel.numberOfNights.toString(),
                hotelName = domainModel.hotelName,
                nutrition = domainModel.nutrition,
                room = domainModel.room
            )
        }
    }
}