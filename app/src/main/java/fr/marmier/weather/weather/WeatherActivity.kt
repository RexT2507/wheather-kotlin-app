package fr.marmier.weather.weather

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

/**
 * WeatherActivity is a activity that contain weatherFragment for display weather detail of a city
 *
 */
class WeatherActivity : AppCompatActivity() {

    /**
     * we initialize the activity with a WeatherFragment
     *
     * @param savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction().replace(android.R.id.content, WeatherFragment.newInstance()).commit()
        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}