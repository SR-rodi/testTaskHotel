package ru.sr.featurehotel.data.mapper

import ru.sr.featurehotel.domen.model.BookingDM
import ru.sr.featurehotel.domen.model.HotelDM
import ru.sr.featurehotel.domen.model.RoomDM
import ru.sr.storage.remote.dto.booking.BookingDto
import ru.sr.storage.remote.dto.hotel.HotelDto
import ru.sr.storage.remote.dto.room.RoomDto

internal fun HotelDto.toDomain(): HotelDM {
    return HotelDM(
        id = this.id,
        description = this.aboutHotel.description,
        peculiarities = this.aboutHotel.peculiarities,
        address = this.address,
        images = this.image,
        minPrice = this.minimalPrice,
        name = this.name,
        priceForIt = this.priceForIt,
        rating = this.rating,
        ratingName = this.ratingName
    )
}

internal fun RoomDto.toDomain(): RoomDM {
    return RoomDM(
        id = this.id,
        images = this.images,
        name = this.name,
        peculiarities = this.peculiarities,
        price = this.price,
        pricePer = this.pricePer
    )
}

internal fun BookingDto.toDomain(): BookingDM {
    return BookingDM(
        country = this.country,
        departure = this.departure,
        fuelCharge = this.fuelCharge,
        horating = this.horating,
        hotelAddress = this.hotelAddress,
        hotelName = this.hotelName,
        id = this.id,
        numberOfNights = this.numberOfNights,
        nutrition = this.nutrition,
        ratingName = this.ratingName,
        room = this.room,
        serviceCharge = this.serviceCharge,
        tourDateStart = this.tourDateStart,
        tourDateStop = this.tourDateStop,
        tourPrice = this.tourPrice
    )
}