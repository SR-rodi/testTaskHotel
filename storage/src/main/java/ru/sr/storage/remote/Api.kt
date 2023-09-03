package ru.sr.storage.remote

import retrofit2.http.GET
import ru.sr.storage.remote.dto.hotel.HotelDto
import ru.sr.storage.remote.dto.room.RoomsDto

interface Api {

    @GET("/v3/35e0d18e-2521-4f1b-a575-f0fe366f66e3")
    suspend fun getHotelInfo(): HotelDto

    @GET("v3/f9a38183-6f95-43aa-853a-9c83cbb05ecd")
    suspend fun getRoomInfo():RoomsDto

    @GET("v3/e8868481-743f-4eb2-a0d7-2bc4012275c8")
    suspend fun getBookingInfo():RoomsDto
}