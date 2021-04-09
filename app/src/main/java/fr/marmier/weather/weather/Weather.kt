package fr.marmier.weather.weather

/**
 * @property description
 * @property temperature
 * @property humidity
 * @property pressure
 * @property iconUrl
 */
data class Weather (val description: String, val temperature: Float, val humidity: Int, val pressure: Int, val iconUrl: String)
