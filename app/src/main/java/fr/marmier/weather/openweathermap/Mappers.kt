package fr.marmier.weather.openweathermap

import fr.marmier.weather.weather.Weather

/**
 * mapOpenWeatherDataToWeather receive data with API format and transform to local format
 *
 * @param weatherWrapper
 * @return
 */
fun mapOpenWeatherDataToWeather(weatherWrapper: WeatherWrapper) : Weather {
    val weatherFirst = weatherWrapper.weather.first()
    return  Weather(
        description = weatherFirst.description,
        temperature = weatherWrapper.main.temperature,
        humidity = weatherWrapper.main.humidity,
        pressure = weatherWrapper.main.pressure,
        iconUrl = "https://openweathermap.org/img/wn/${weatherFirst.icon}.png"
    )
}