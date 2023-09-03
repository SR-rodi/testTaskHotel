package ru.sr.featurehotel.domen.repository

import ru.sr.featurehotel.domen.model.BookingDM
import ru.sr.featurehotel.domen.model.HotelDM
import ru.sr.featurehotel.domen.model.RoomDM

internal interface HotelRepository {

    suspend fun getHotelInfo(): Result<HotelDM>

    suspend fun getRooms(): Result<List<RoomDM>>

    suspend fun getBookingInfo(): Result<BookingDM>
}

