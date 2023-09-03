package ru.sr.featurehotel.data.repository

import ru.sr.featurehotel.data.mapper.toDomain
import ru.sr.featurehotel.domen.repository.HotelRepository
import ru.sr.featurehotel.domen.model.BookingDM
import ru.sr.featurehotel.domen.model.HotelDM
import ru.sr.featurehotel.domen.model.RoomDM
import ru.sr.storage.remote.HotelApi

internal class HotelRepositoryImpl(
    private val hotelApi: HotelApi
) : HotelRepository {
    override suspend fun getHotelInfo(): Result<HotelDM> {
        return kotlin.runCatching {
            hotelApi.getHotelInfo().toDomain()
        }.onSuccess { hotelDto ->
            Result.success(hotelDto)
        }.onFailure {
            Result.failure<HotelDM>(it)
        }
    }

    override suspend fun getRooms(): Result<List<RoomDM>> {
        return kotlin.runCatching {
            hotelApi.getRoomInfo().rooms.map { roomDto ->
                roomDto.toDomain()
            }
        }.onSuccess { rooms ->
            Result.success(rooms)
        }.onFailure {
            Result.failure<List<RoomDM>>(it)
        }
    }

    override suspend fun getBookingInfo(): Result<BookingDM> {
        return kotlin.runCatching {
            hotelApi.getBookingInfo().toDomain()
        }.onSuccess { booking ->
            Result.success(booking)
        }.onFailure {
            Result.failure<BookingDM>(it)
        }
    }
}