package com.plcoding.weatherapp.domain.weather

import java.nio.DoubleBuffer
import java.time.LocalDateTime

data class WeatherData(
    //Contains specific hour's weather data.

    val time : LocalDateTime,
    val temperatureCelcius: Double,
    val pressure: Double,
    val windSpeed: Double,
    val humidity: Double,
    val weatherType: WeatherType
)
