package com.andresad13.clima_prueba_bold.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.andresad13.clima_prueba_bold.R
import com.andresad13.clima_prueba_bold.model.CityModel
import com.andresad13.clima_prueba_bold.model.RecyclerCityListener
import com.andresad13.clima_prueba_bold.view.CityWeatherActivity

 class ListCitiesAdapter(listaCities: List<CityModel>, private val  listenerCity: RecyclerCityListener) :
    RecyclerView.Adapter<ListCitiesAdapter.CitiesViewHolder>() {



    private val listaCities: List<CityModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitiesViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_city, null, false)
        return CitiesViewHolder(view)
    }
    override fun onBindViewHolder(holder: CitiesViewHolder, position: Int) {
        holder.name.setText(listaCities[position].title)
        holder.type.setText(listaCities[position].location_type)
        holder.itemView.setOnClickListener {
            listenerCity.OnRecyclerCityItemClick(holder.itemView, listaCities[position])
        }

    }
    override fun getItemCount(): Int {
        return listaCities.size
    }
    inner class CitiesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var type: TextView


        init {
            name = itemView.findViewById(R.id.city_name)
            type = itemView.findViewById(R.id.city_type)

        }


    }
    init {
        this.listaCities = listaCities
    }


}