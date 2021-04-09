package fr.marmier.weather.city

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import fr.marmier.weather.R
import fr.marmier.weather.databinding.ItemCityBinding

/**
 * TODO
 *
 * @property cities
 * @property cityListener
 */
class CityAdapter(private val cities: List<City>, private val cityListener: CityAdapter.CityItemListener) : RecyclerView.Adapter<CityAdapter.ViewHolder>(),
    View.OnClickListener {

    interface CityItemListener {
        fun onCitySelected(city: City)
        fun onCityDeleted(city: City)
    }

    inner class ViewHolder (binding: ItemCityBinding) : RecyclerView.ViewHolder(binding.root){
        val cardView = binding.cardView!!
        val cityNameView = binding.name!!
        val deleteView = binding.delete!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  ViewHolder(binding)
    }

    /**
     * TODO
     *
     * @param holder
     * @param position
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val city = cities[position]
        with(holder){
            cardView.tag = city
            cardView.setOnClickListener(this@CityAdapter)
            cityNameView.text = city.name
            deleteView.tag = city
            deleteView.setOnClickListener(this@CityAdapter)
        }
    }

    override fun getItemCount(): Int = cities.size
    override fun onClick(v: View) {
        when (v.id) {
            R.id.card_view -> cityListener.onCitySelected(v.tag as City)
            R.id.delete -> cityListener.onCityDeleted(v.tag as City)
        }
    }
}