package ru.sr.featurehotel.domen.useCase

import ru.sr.featurehotel.domen.model.BookingDM

internal interface GetBookingUseCase {
    suspend operator fun invoke():Result<BookingDM>
}