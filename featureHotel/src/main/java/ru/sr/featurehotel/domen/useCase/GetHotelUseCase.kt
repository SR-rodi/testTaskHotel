package ru.sr.featurehotel.domen.useCase

import ru.sr.featurehotel.domen.model.HotelDM

internal interface GetHotelUseCase {
    suspend operator fun invoke():Result<HotelDM>
}