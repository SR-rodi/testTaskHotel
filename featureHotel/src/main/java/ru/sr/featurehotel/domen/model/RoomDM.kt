package ru.sr.featurehotel.domen.model

class RoomDM(
    val id: Int,
    val images: List<String>,
    val name: String,
    val peculiarities: List<String>,
    val price: Int,
    val pricePer: String
)