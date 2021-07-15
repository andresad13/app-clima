package com.andresad13.clima_prueba_bold.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andresad13.clima_prueba_bold.model.ServicesSetterGetter
import com.andresad13.clima_prueba_bold.repository.MainActivityRepository

class MainActivityViewModel : ViewModel() {


    var servicesLiveData: MutableLiveData<ServicesSetterGetter>? = null

    fun GetCities(str: String) : LiveData<ServicesSetterGetter>? {
        servicesLiveData = MainActivityRepository.getServicesApiCall(str)
        return servicesLiveData
    }

}