package com.andresad13.clima_prueba_bold.repository

import androidx.lifecycle.MutableLiveData
import com.andresad13.clima_prueba_bold.model.ServicesWeather
import com.andresad13.clima_prueba_bold.model.WeatherModel
import com.andresad13.clima_prueba_bold.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object WeatherActivityRepository {
    val serviceSetterGetter = MutableLiveData<ServicesWeather>()

     fun getServicesApiCall(id: Int?): MutableLiveData<ServicesWeather> {


        val call = RetrofitClient.apiInterface.getWeather(id.toString())

        call.enqueue(object: Callback<WeatherModel> {
            override fun onFailure(call: Call<WeatherModel>, t: Throwable) {
                print("error")
            }
            override fun onResponse(
                call: Call<WeatherModel>,
                response: Response<WeatherModel>
            ) {
                val data = response.body()
                serviceSetterGetter.value = ServicesWeather(data!!)
            }
        })
        return serviceSetterGetter
    }
}