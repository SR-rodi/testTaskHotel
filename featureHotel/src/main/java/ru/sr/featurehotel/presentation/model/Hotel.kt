package ru.sr.featurehotel.presentation.model

import ru.sr.featurehotel.domen.model.HotelDM

class Hotel(
    val id: Int = -1,
    val description: String = "",
    val peculiarities: List<String> = emptyList(),
    val address: String = "",
    val images: List<String> = emptyList(),
    val minPrice: Int = -1,
    val name: String = "",
    val price: String = "",
    val rating: Int = -1,
    val ratingName: String = ""
) {

    companion object{
        fun fromDomain(domainModel: HotelDM): Hotel {
           return Hotel(
                id = domainModel.id,
                description = domainModel.description,
                peculiarities = domainModel.peculiarities,
                address = domainModel.address,
                images = domainModel.images,
                minPrice = domainModel.minPrice,
                name = domainModel.name,
                price = domainModel.price,
                rating = domainModel.rating,
                ratingName = domainModel.ratingName
            )
        }
    }


}