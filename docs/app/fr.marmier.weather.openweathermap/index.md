//[app](../../index.md)/[fr.marmier.weather.openweathermap](index.md)



# Package fr.marmier.weather.openweathermap  


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="fr.marmier.weather.openweathermap/MainData///PointingToDeclaration/"></a>[MainData](-main-data/index.md)| <a name="fr.marmier.weather.openweathermap/MainData///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>data class [MainData](-main-data/index.md)(**temperature**: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), **pressure**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), **humidity**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))  <br><br><br>|
| <a name="fr.marmier.weather.openweathermap/OpenWeatherService///PointingToDeclaration/"></a>[OpenWeatherService](-open-weather-service/index.md)| <a name="fr.marmier.weather.openweathermap/OpenWeatherService///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>interface [OpenWeatherService](-open-weather-service/index.md)  <br>More info  <br>OpenWeatherService is a interface that allow to call open weather API services.  <br><br><br>|
| <a name="fr.marmier.weather.openweathermap/WeatherData///PointingToDeclaration/"></a>[WeatherData](-weather-data/index.md)| <a name="fr.marmier.weather.openweathermap/WeatherData///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>data class [WeatherData](-weather-data/index.md)(**description**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **icon**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))  <br><br><br>|
| <a name="fr.marmier.weather.openweathermap/WeatherWrapper///PointingToDeclaration/"></a>[WeatherWrapper](-weather-wrapper/index.md)| <a name="fr.marmier.weather.openweathermap/WeatherWrapper///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>data class [WeatherWrapper](-weather-wrapper/index.md)(**weather**: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[WeatherData](-weather-data/index.md)>, **main**: [MainData](-main-data/index.md))  <br><br><br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="fr.marmier.weather.openweathermap//mapOpenWeatherDataToWeather/#fr.marmier.weather.openweathermap.WeatherWrapper/PointingToDeclaration/"></a>[mapOpenWeatherDataToWeather](map-open-weather-data-to-weather.md)| <a name="fr.marmier.weather.openweathermap//mapOpenWeatherDataToWeather/#fr.marmier.weather.openweathermap.WeatherWrapper/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [mapOpenWeatherDataToWeather](map-open-weather-data-to-weather.md)(weatherWrapper: [WeatherWrapper](-weather-wrapper/index.md)): [Weather](../fr.marmier.weather.weather/-weather/index.md)  <br>More info  <br>mapOpenWeatherDataToWeather receive data with API format and transform to local format  <br><br><br>|

