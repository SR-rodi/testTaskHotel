package ru.sr.featurehotel.domen.useCase.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.sr.featurehotel.domen.model.HotelDM
import ru.sr.featurehotel.domen.repository.HotelRepository
import ru.sr.featurehotel.domen.useCase.GetHotelUseCase

internal class GetHotelUseCaseImpl(
    private val hotelRepository: HotelRepository
) : GetHotelUseCase {
    override suspend fun invoke(): Result<HotelDM> {
        return withContext(Dispatchers.IO) {
            hotelRepository.getHotelInfo()
        }
    }
}