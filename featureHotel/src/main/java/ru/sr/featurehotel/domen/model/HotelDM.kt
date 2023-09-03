package ru.sr.featurehotel.domen.model

class HotelDM (
    val id: Int,
    val description: String,
    val peculiarities: List<String>,
    val address: String,
    val images: List<String>,
    val minPrice: Int,
    val name: String,
    val price: String,
    val rating: Int,
    val ratingName: String
)