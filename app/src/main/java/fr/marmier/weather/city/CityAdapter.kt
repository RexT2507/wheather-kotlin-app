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
 *  CityAdapter is an class that allow to display each item of a list of city with good data and manage the click event.
 *
 * @property cities is a list of cities
 * @property cityListener is a interface that allow to trigger event
 */
class CityAdapter(private val cities: List<City>, private val cityListener: CityAdapter.CityItemListener) : RecyclerView.Adapter<CityAdapter.ViewHolder>(),
    View.OnClickListener {

    /**
     * CityItemListener is a interface that allow to trigger deleted and selected click event
     *
     */
    interface CityItemListener {
        fun onCitySelected(city: City)
        fun onCityDeleted(city: City)
    }

    /**
     * ViewHolder recover referencies to different part of the view
     *
     * @constructor
     *
     *
     * @param binding contain all part of the layout
     */
    inner class ViewHolder (binding: ItemCityBinding) : RecyclerView.ViewHolder(binding.root){
        val cardView = binding.cardView!!
        val cityNameView = binding.name!!
        val deleteView = binding.delete!!
    }

    /**
     * Here we bind the layout
     *
     * @param parent
     * @param viewType
     * @return
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  ViewHolder(binding)
    }

    /**
     * On the bind of ViewHolder we attach the click event to actions and inialize text
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

    /**
     * Function that allow to calculate the size of the list
     *
     * @return size of cities
     */
    override fun getItemCount(): Int = cities.size

    /**
     * Redirect to the good action delete or selected in function of what is clicked
     *
     * @param v view clicked
     */
    override fun onClick(v: View) {
        when (v.id) {
            R.id.card_view -> cityListener.onCitySelected(v.tag as City)
            R.id.delete -> cityListener.onCityDeleted(v.tag as City)
        }
    }
}