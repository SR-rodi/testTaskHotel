package ru.sr.featurehotel.domen.useCase.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.sr.featurehotel.domen.model.BookingDM
import ru.sr.featurehotel.domen.repository.HotelRepository
import ru.sr.featurehotel.domen.useCase.GetBookingUseCase

internal class GetBookingUseCaseImpl(
    private val hotelRepository: HotelRepository
) : GetBookingUseCase {
    override suspend fun invoke(): Result<BookingDM> {
        return withContext(Dispatchers.IO) {
            hotelRepository.getBookingInfo()
        }
    }
}