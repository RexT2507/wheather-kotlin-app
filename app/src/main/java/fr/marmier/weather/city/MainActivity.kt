package fr.marmier.weather.city

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.marmier.weather.R
import fr.marmier.weather.weather.WeatherActivity
import fr.marmier.weather.weather.WeatherFragment


class MainActivity : AppCompatActivity(), CityFragment.CityFragmentListener {

    private lateinit var cityFragment: CityFragment
    private  var currentCity: City? = null


    /**
     * onCreate start the activity with cityFragment as first view
     *
     * @param savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cityFragment = supportFragmentManager.findFragmentById(R.id.city_fragment) as CityFragment
        cityFragment.listener = this
    }


    /**
     * onCitySelected modify the current city and call startActivity
     *
     * @param city
     */
    override fun onCitySelected(city: City) {
        currentCity = city
        startWeatherActivity(city)
    }

    /**
     * startWeatherActivity allow to start WeatherAtivity with the city past to parameters
     *
     * @param city
     */
    private fun startWeatherActivity(city: City) {
        val intent = Intent(this, WeatherActivity::class.java)
        intent.putExtra(WeatherFragment.EXTRA_CITY_NAME, city.name)
        startActivity(intent)
    }
}