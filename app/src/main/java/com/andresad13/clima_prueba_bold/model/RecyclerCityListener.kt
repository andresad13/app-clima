package com.andresad13.clima_prueba_bold.model

import android.view.View

interface RecyclerCityListener {
    fun OnRecyclerCityItemClick(view: View, city: CityModel)
}