package ru.sr.storage.remote.dto.hotel

import com.google.gson.annotations.SerializedName

class HotelDto(
    @SerializedName("about_the_hotel") val aboutHotel: AboutTheHotelDto,
    @SerializedName("adress") val address: String,
    @SerializedName("id") val id: Int,
    @SerializedName("image_urls") val image: List<String>,
    @SerializedName("minimal_price") val minimalPrice: Int,
    @SerializedName("name") val name: String,
    @SerializedName("price_for_it") val price: String,
    @SerializedName("rating") val rating: Int,
    @SerializedName("rating_name") val ratingName: String
)