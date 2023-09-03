package ru.sr.storage.remote.dto.hotel

import com.google.gson.annotations.SerializedName

class AboutTheHotelDto(
    @SerializedName("description") val description: String,
    @SerializedName("peculiarities") val peculiarities: List<String>
)