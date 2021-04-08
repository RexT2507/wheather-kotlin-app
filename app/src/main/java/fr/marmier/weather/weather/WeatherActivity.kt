package fr.marmier.weather.weather

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class WeatherActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
//        super.onCreate(savedInstanceState, persistentState)
//        supportFragmentManager.beginTransaction().replace(android.R.id.content, WeatherFragment.newInstance()).commit()
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction().replace(android.R.id.content, WeatherFragment.newInstance()).commit()
    }

}