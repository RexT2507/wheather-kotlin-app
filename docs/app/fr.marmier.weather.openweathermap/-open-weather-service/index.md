//[app](../../../index.md)/[fr.marmier.weather.openweathermap](../index.md)/[OpenWeatherService](index.md)



# OpenWeatherService  
 [androidJvm] interface [OpenWeatherService](index.md)

OpenWeatherService is a interface that allow to call open weather API services.

   


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="fr.marmier.weather.openweathermap/OpenWeatherService/getWeather/#kotlin.String#kotlin.String/PointingToDeclaration/"></a>[getWeather](get-weather.md)| <a name="fr.marmier.weather.openweathermap/OpenWeatherService/getWeather/#kotlin.String#kotlin.String/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>@(value = data/2.5/weather?units=metric&lang=fr)  <br>  <br>abstract fun [getWeather](get-weather.md)(@(value = q)cityName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), @(value = appid)apiKey: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = API_KEY): <[WeatherWrapper](../-weather-wrapper/index.md)>  <br>More info  <br>getWeather is a function that call a service that give weather of a city with it name  <br><br><br>|

