package com.andresad13.clima_prueba_bold.model

import com.google.gson.annotations.SerializedName

data class WeatherModel (
    val consolidated_weather:List<WeatherCity>
    )

data class WeatherCity(
    val weather_state_name:String,
    val applicable_date:String,
    val min_temp:Float,
    val max_temp:Float,
    val humidity:String
)