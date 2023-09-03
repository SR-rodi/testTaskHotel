package ru.sr.storage.remote.dto.room

import com.google.gson.annotations.SerializedName

class RoomsDto(
   @SerializedName("rooms") val rooms: List<RoomDto>
)