package fr.marmier.weather.openweathermap

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "f2d3daff0513f992f92f1d8063731356"

interface OpenWeatherService {

    @GET("data/2.5/weather?units=metric&lang=fr")
    fun getWeather(@Query("q") cityName: String, @Query("appid") apiKey: String = API_KEY) : Call<WeatherWrapper>
}