package ru.sr.storage.remote.dto.room

import com.google.gson.annotations.SerializedName

class RoomDto(
  @SerializedName("id")  val id: Int,
  @SerializedName("image_urls")  val images: List<String>,
  @SerializedName("name")  val name: String,
  @SerializedName("peculiarities")  val peculiarities: List<String>,
  @SerializedName("price")  val price: Int,
  @SerializedName("price_per")  val pricePer: String
)