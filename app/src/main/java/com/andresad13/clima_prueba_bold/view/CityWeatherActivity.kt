package com.andresad13.clima_prueba_bold.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.andresad13.clima_prueba_bold.R
import com.andresad13.clima_prueba_bold.viewmodel.CityWeatherActivityViewModel
import com.andresad13.clima_prueba_bold.viewmodel.MainActivityViewModel

class CityWeatherActivity : AppCompatActivity() {

    lateinit var cityWeatherActivityViewModel: CityWeatherActivityViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_weather)

        cityWeatherActivityViewModel = ViewModelProvider(this).get(CityWeatherActivityViewModel::class.java)

        val city_id = getIntent().getIntExtra("id_city",0)
        val city_name = getIntent().getStringExtra("name_city")
        cityWeatherActivityViewModel.GetWeather(city_id)!!.observe(this, Observer { serviceSetterGetter ->

            println(serviceSetterGetter.Weather.consolidated_weather)

        })

    }
}