package com.plcoding.weatherapp.data.repository

import com.plcoding.weatherapp.data.mappers.toWeatherInfo
import com.plcoding.weatherapp.data.remote.WeatherAPi
import com.plcoding.weatherapp.domain.repository.WeatherRepository
import com.plcoding.weatherapp.domain.util.Resource
import com.plcoding.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepoImp @Inject constructor (
    private val api: WeatherAPi
        ): WeatherRepository {


    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(data = api.getWeatherData(lat,long).toWeatherInfo())

        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message?: "An unknown error occured.")
        }
    }
}