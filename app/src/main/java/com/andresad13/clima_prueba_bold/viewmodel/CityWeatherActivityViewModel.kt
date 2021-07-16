package com.andresad13.clima_prueba_bold.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andresad13.clima_prueba_bold.model.ServicesWeather
import com.andresad13.clima_prueba_bold.repository.WeatherActivityRepository

class CityWeatherActivityViewModel : ViewModel(){

    var servicesLiveData: MutableLiveData<ServicesWeather>? = null

     fun GetWeather(id: Int?): LiveData<ServicesWeather>? {
        servicesLiveData = WeatherActivityRepository.getServicesApiCall(id)
        return servicesLiveData
    }

}