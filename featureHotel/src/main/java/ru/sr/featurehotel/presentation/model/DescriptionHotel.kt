package ru.sr.featurehotel.presentation.model

import ru.sr.featurehotel.domen.model.HotelDM

class DescriptionHotel(
    val description: String = "",
    val peculiarities: List<String> = emptyList(),
): HotelInfo {

    companion object {
        fun fromDomain(domainModel: HotelDM): DescriptionHotel {
            return DescriptionHotel(
                description = domainModel.description,
                peculiarities = domainModel.peculiarities
            )
        }
    }
}