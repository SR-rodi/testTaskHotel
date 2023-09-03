package ru.sr.featurehotel.presentation.model

import ru.sr.featurehotel.domen.model.BookingDM

class Booking(
    val country: String = "",
    val departure: String = "",
    val fuelCharge: Int = -1,
    val horating: Int = -1,
    val hotelAddress: String = "",
    val hotelName: String = "",
    val id: Int = -1,
    val numberOfNights: Int = -1,
    val nutrition: String = "",
    val ratingName: String = "",
    val room: String = "",
    val serviceCharge: Int = -1,
    val tourDateStart: String = "",
    val tourDateStop: String = "",
    val tourPrice: Int = -1
) {

    companion object {
        fun fromDomain(domainModel: BookingDM): Booking {
            return Booking(
                country = domainModel.country,
                departure = domainModel.departure,
                fuelCharge = domainModel.fuelCharge,
                horating = domainModel.horating,
                hotelAddress = domainModel.hotelAddress,
                hotelName = domainModel.hotelName,
                id = domainModel.id,
                numberOfNights = domainModel.numberOfNights,
                nutrition = domainModel.nutrition,
                ratingName = domainModel.ratingName,
                room = domainModel.room,
                serviceCharge = domainModel.serviceCharge,
                tourDateStart = domainModel.tourDateStart,
                tourDateStop = domainModel.tourDateStop,
                tourPrice = domainModel.tourPrice
            )
        }
    }
}