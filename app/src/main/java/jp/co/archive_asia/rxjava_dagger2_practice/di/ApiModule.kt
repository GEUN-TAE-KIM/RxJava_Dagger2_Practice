package jp.co.archive_asia.rxjava_dagger2_practice.di

import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import jp.co.archive_asia.rxjava_dagger2_practice.model.CountriesService
import jp.co.archive_asia.rxjava_dagger2_practice.network.CountriesApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {

    @Provides
    fun provideCountriesApi(): CountriesApi {

        return Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .create(CountriesApi::class.java)
    }

    @Provides
    fun provideCountriesService(): CountriesService {
        return CountriesService()
    }
}