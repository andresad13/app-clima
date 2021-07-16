package com.andresad13.clima_prueba_bold.view

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.andresad13.clima_prueba_bold.R
import com.andresad13.clima_prueba_bold.databinding.ActivityCityWeatherBinding
import com.andresad13.clima_prueba_bold.viewmodel.CityWeatherActivityViewModel
import org.jetbrains.annotations.NotNull

class CityWeatherActivity : AppCompatActivity() {
    lateinit var cityWeatherActivityViewModel: CityWeatherActivityViewModel
    private lateinit var binding: ActivityCityWeatherBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cityWeatherActivityViewModel = ViewModelProvider(this).get(CityWeatherActivityViewModel::class.java)
        val city_id = getIntent().getIntExtra("id_city",0)
        val city_name = getIntent().getStringExtra("name_city")
        binding.cityTitle.text = city_name
        cityWeatherActivityViewModel.GetWeather(city_id)!!.observe(this, Observer { serviceSetterGetter ->

            binding.progressCityDetail.visibility = View.GONE

            println(serviceSetterGetter.Weather.consolidated_weather)
            binding.dateToday.text = serviceSetterGetter.Weather.consolidated_weather[0].applicable_date
            binding.textWeatherStateToday.text = serviceSetterGetter.Weather.consolidated_weather[0].weather_state_name
                binding.imgWeatherStateToday.setImageResource(SetImage(serviceSetterGetter.Weather.consolidated_weather[0].weather_state_name))
            serviceSetterGetter.Weather.consolidated_weather[0].weather_state_name
            binding.textMintempDescToday.text = serviceSetterGetter.Weather.consolidated_weather[0].min_temp.toString()
            binding.textMaxtempDescToday.text = serviceSetterGetter.Weather.consolidated_weather[0].max_temp.toString()

            binding.dateTom.text = serviceSetterGetter.Weather.consolidated_weather[1].applicable_date
            binding.textWeatherStateTom.text = serviceSetterGetter.Weather.consolidated_weather[1].weather_state_name
            binding.imgWeatherStateTom.setImageResource(SetImage(serviceSetterGetter.Weather.consolidated_weather[1].weather_state_name))
            serviceSetterGetter.Weather.consolidated_weather[0].weather_state_name
            binding.textMintempDescTom.text = serviceSetterGetter.Weather.consolidated_weather[1].min_temp.toString()
            binding.textMaxtempDescTom.text = serviceSetterGetter.Weather.consolidated_weather[1].max_temp.toString()

            binding.dateTomtwo.text = serviceSetterGetter.Weather.consolidated_weather[2].applicable_date
            binding.textWeatherStateTomtwo.text = serviceSetterGetter.Weather.consolidated_weather[2].weather_state_name
            binding.imgWeatherStateTomtwo.setImageResource(SetImage(serviceSetterGetter.Weather.consolidated_weather[2].weather_state_name))
            serviceSetterGetter.Weather.consolidated_weather[0].weather_state_name
            binding.textMintempDescTomtwo.text = serviceSetterGetter.Weather.consolidated_weather[2].min_temp.toString()
            binding.textMaxtempDescTomtwo.text = serviceSetterGetter.Weather.consolidated_weather[2].max_temp.toString()
        })
    }
    fun SetImage( textImage: String): Int {
        var id_img = 0
        when (textImage){
            "Light Rain" ->  id_img = R.drawable.ic_rain
            "Heavy Rain" -> id_img = R.drawable.ic_rain
            "Showers" ->id_img = R.drawable.ic_rain
            "Clear" ->id_img = R.drawable.ic_sunny
            "Light Cloud" ->id_img = R.drawable.ic_cloudly
            "Heavy Cloud" ->id_img = R.drawable.ic_cloudly
        }
        return id_img
    }
    override fun onConfigurationChanged(@NotNull newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE) {
            binding.mainLayoutCity.orientation= LinearLayout.HORIZONTAL
            val params: LinearLayout.LayoutParams = binding.todayCard.getLayoutParams() as LinearLayout.LayoutParams
            params.height = ViewGroup.LayoutParams.MATCH_PARENT
            params.width = 0
            binding.todayCard.setLayoutParams(params)
            binding.tomCard.setLayoutParams(params)
            binding.tomtwoCard.setLayoutParams(params)

        } else if (newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {
            binding.mainLayoutCity.orientation= LinearLayout.VERTICAL
            val params: LinearLayout.LayoutParams = binding.todayCard.getLayoutParams() as LinearLayout.LayoutParams
            params.height = 0
            params.width = ViewGroup.LayoutParams.MATCH_PARENT
            binding.todayCard.setLayoutParams(params)
            binding.tomCard.setLayoutParams(params)
            binding.tomtwoCard.setLayoutParams(params)
        }
    }
}