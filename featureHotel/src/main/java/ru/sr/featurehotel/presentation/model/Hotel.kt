package ru.sr.featurehotel.presentation.model

import ru.sr.featurehotel.domen.model.HotelDM

class Hotel(
    val id: Int = -1,
    val address: String = "",
    val images: List<String> = emptyList(),
    val minPrice: Int = -1,
    val name: String = "",
    val priceForIt: String = "",
    val rating: Int = -1,
    val ratingName: String = ""
):HotelInfo {

    companion object {
        fun fromDomain(domainModel: HotelDM): Hotel {
            return Hotel(
                id = domainModel.id,
                address = domainModel.address,
                images = domainModel.images,
                minPrice = domainModel.minPrice,
                name = domainModel.name,
                priceForIt = domainModel.priceForIt,
                rating = domainModel.rating,
                ratingName = domainModel.ratingName
            )
        }
    }
}

