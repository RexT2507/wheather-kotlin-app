package fr.marmier.weather

import android.app.Application
import fr.marmier.weather.openweathermap.OpenWeatherService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Main Class
 *
 */
class App : Application() {

    /**
     * We go through a companion in order to be able to continue instantiating it while keeping the constructor
     */
    companion object {

        lateinit var instance: App
            private set

        val database: Database by lazy {
            Database(instance)
        }

        /**
         * Creation of the http client
         */
        private val httpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        /**
         * Creation of the retrofit which uses the http client
         */
        private val retrofit = Retrofit.Builder()
            .client(httpClient)
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val weatherService: OpenWeatherService = retrofit.create(OpenWeatherService::class.java)
    }

    /**
     * Creation of the instance of the two previous methods
     *
     */
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}