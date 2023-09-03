package ru.sr.featurehotel.domen.useCase.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.sr.featurehotel.domen.model.RoomDM
import ru.sr.featurehotel.domen.repository.HotelRepository
import ru.sr.featurehotel.domen.useCase.GetRoomsUseCase

internal class GetRoomsUseCaseImpl(
    private val hotelRepository: HotelRepository
) : GetRoomsUseCase {
    override suspend fun invoke(): Result<List<RoomDM>> {
        return withContext(Dispatchers.IO) {
            hotelRepository.getRooms()
        }
    }
}