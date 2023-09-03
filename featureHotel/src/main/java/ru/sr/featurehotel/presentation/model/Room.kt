package ru.sr.featurehotel.presentation.model

import ru.sr.featurehotel.domen.model.RoomDM

class Room(
    val id: Int = -1,
    val images: List<String> = emptyList(),
    val name: String = "",
    val peculiarities: List<String> = emptyList(),
    val price: Int = -1,
    val pricePer: String = ""
) {

    companion object {
        fun fromDomain(domainModel: RoomDM): Room {
            return Room(
                id = domainModel.id,
                images = domainModel.images,
                name = domainModel.name,
                peculiarities = domainModel.peculiarities,
                price = domainModel.price,
                pricePer = domainModel.pricePer
            )
        }
    }
}