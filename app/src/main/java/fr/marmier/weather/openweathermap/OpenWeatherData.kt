package fr.marmier.weather.openweathermap

import com.google.gson.annotations.SerializedName

/**
 * @property weather
 * @property main
 */
data class WeatherWrapper(val weather: Array<WeatherData>, val main: MainData)

/**
 * @property description
 * @property icon
 */
data class WeatherData(val description: String, val icon: String)

/**
 * @property temperature
 * @property pressure
 * @property humidity
 */
data class MainData(@SerializedName("temp") val temperature: Float, val pressure: Int, val humidity: Int)
