package com.andresad13.clima_prueba_bold.retrofit

import com.andresad13.clima_prueba_bold.model.CityModel
import com.andresad13.clima_prueba_bold.model.WeatherModel
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @GET("search/")
    fun getServices(
        @Query("query") str: String?
    ): Call<List<CityModel>>


    @GET()
    fun getWeather(@Url id: String? ):
            Call<WeatherModel>



}