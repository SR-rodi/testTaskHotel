package ru.sr.featurehotel.presentation.model

data class User(
    val firstName: String = "",
    val lastName: String = "",
    val birthDay: String = "",
    val nationality: String = "",
    val passportNumber: String = "",
    val passportTerm: String = "",
    val isExpected: Boolean = true,
    val rotationArrow: Float = 90F,
    val namePositionUser:String = "Первый турист"
)

data class Users(
    val items: List<User>
) : HotelInfo
