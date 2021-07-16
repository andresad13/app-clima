package com.andresad13.clima_prueba_bold.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ServicesWeather (

 @SerializedName("consolidated_weather")  var Weather: WeatherModel)