package com.andresad13.clima_prueba_bold.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andresad13.clima_prueba_bold.adapters.ListCitiesAdapter
import com.andresad13.clima_prueba_bold.databinding.ActivityMainBinding
import com.andresad13.clima_prueba_bold.model.CityModel
import com.andresad13.clima_prueba_bold.model.RecyclerCityListener
import com.andresad13.clima_prueba_bold.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity(), RecyclerCityListener {
    lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var binding:ActivityMainBinding
    private var listaCity: List<CityModel>? = null
    private  var recyclerViewCities: RecyclerView? = null
    private lateinit var adapter: ListCitiesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        recyclerViewCities = binding.recyclerCities

        recyclerViewCities!!.setLayoutManager(LinearLayoutManager(this))



        binding.editCity.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun afterTextChanged(p0: Editable?) {
                if(!binding.editCity.text.toString().isEmpty())
                setListCities(binding.editCity.text.toString())
            }
        })

    }

    fun setListCities(str: String) {
        mainActivityViewModel.GetCities(str)!!.observe(this, Observer { serviceSetterGetter ->
            println(serviceSetterGetter.Cities)

            listaCity = serviceSetterGetter.Cities
            adapter = listaCity?.let { ListCitiesAdapter(it, this) }!!
            recyclerViewCities!!.setAdapter(adapter)
            adapter.notifyDataSetChanged()
        })
    }

    override fun OnRecyclerCityItemClick(view: View, city: CityModel) {
        val intent = Intent(this,CityWeatherActivity::class.java)
        intent.putExtra("id_city",city.woeid)
        intent.putExtra("name_city",city.title)
        startActivity(intent)
    }

}