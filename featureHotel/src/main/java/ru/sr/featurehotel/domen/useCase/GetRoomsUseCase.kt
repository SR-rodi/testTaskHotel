package ru.sr.featurehotel.domen.useCase

import ru.sr.featurehotel.domen.model.RoomDM

internal interface GetRoomsUseCase {
    suspend operator fun invoke():Result<List<RoomDM>>
}