package com.andresad13.clima_prueba_bold.retrofit

import com.andresad13.clima_prueba_bold.model.CityModel
import kotlinx.coroutines.Deferred
import org.json.JSONArray
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("search/")

    fun getServices(
        @Query("query") str: String?
    ): Call<List<CityModel>>



}