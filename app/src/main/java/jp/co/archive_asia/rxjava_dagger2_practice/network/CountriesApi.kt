package jp.co.archive_asia.rxjava_dagger2_practice.network

import io.reactivex.rxjava3.core.Single
import jp.co.archive_asia.rxjava_dagger2_practice.model.Country
import retrofit2.http.GET

interface CountriesApi {

    @GET("DevTides/countries/master/countriesV2.json")
    fun getCountries(): Single<List<Country>>

}