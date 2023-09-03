package ru.sr.featurehotel.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.sr.featurehotel.data.repository.HotelRepositoryImpl
import ru.sr.featurehotel.domen.repository.HotelRepository
import ru.sr.featurehotel.domen.useCase.GetBookingUseCase
import ru.sr.featurehotel.domen.useCase.GetHotelUseCase
import ru.sr.featurehotel.domen.useCase.GetRoomsUseCase
import ru.sr.featurehotel.domen.useCase.impl.GetBookingUseCaseImpl
import ru.sr.featurehotel.domen.useCase.impl.GetHotelUseCaseImpl
import ru.sr.featurehotel.domen.useCase.impl.GetRoomsUseCaseImpl
import ru.sr.featurehotel.presentation.booking.BookingViewModel
import ru.sr.featurehotel.presentation.hotel.HotelViewModel
import ru.sr.featurehotel.presentation.room.RoomViewModel

fun featureHotelModule() = listOf(repositoryModule(),useCaseModule(),hotelViewModelModule())

private fun repositoryModule() = module {
    singleOf(::HotelRepositoryImpl){bind<HotelRepository>()}
}

private fun useCaseModule() = module {

    singleOf(::GetBookingUseCaseImpl){bind<GetBookingUseCase>()}
    singleOf(::GetRoomsUseCaseImpl){bind<GetRoomsUseCase>()}
    singleOf(::GetHotelUseCaseImpl){bind<GetHotelUseCase>()}
}

private fun hotelViewModelModule() = module {
    viewModelOf(::BookingViewModel)
    viewModelOf(::HotelViewModel)
    viewModelOf(::RoomViewModel)
}