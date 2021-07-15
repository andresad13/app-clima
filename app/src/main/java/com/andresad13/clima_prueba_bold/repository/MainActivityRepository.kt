package com.andresad13.clima_prueba_bold.repository

import androidx.lifecycle.MutableLiveData
import com.andresad13.clima_prueba_bold.model.CityModel
import com.andresad13.clima_prueba_bold.model.ServicesSetterGetter
import com.andresad13.clima_prueba_bold.retrofit.ApiInterface
import com.andresad13.clima_prueba_bold.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepository {
    val serviceSetterGetter = MutableLiveData<ServicesSetterGetter>()

    fun getServicesApiCall(str: String): MutableLiveData<ServicesSetterGetter> {


        val call = RetrofitClient.apiInterface.getServices(str)

        call.enqueue(object: Callback<List<CityModel>> {
            override fun onFailure(call: Call<List<CityModel>>, t: Throwable) {
            }
            override fun onResponse(
                call: Call<List<CityModel>>,
                response: Response<List<CityModel>>
            ) {
                val data = response.body()
                serviceSetterGetter.value = ServicesSetterGetter(data!!)
            }
        })
        return serviceSetterGetter
    }
}