package jp.co.archive_asia.rxjava_dagger2_practice.model

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Single
import jp.co.archive_asia.rxjava_dagger2_practice.network.CountriesApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CountriesService {

    private val api : CountriesApi = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
        .create(CountriesApi::class.java)

    fun getCountries(): Single<List<Country>> {
        return api.getCountries()
    }


    // 이게 rx2 방식인듯
   /* private val BASE_URL = "https://raw.githubusercontent.com"
    private val api : CountriesApi

    // init 말고 오브젝트로 만들어서 하는게 있음 그걸로 나중에 전환하기
    init {
        api = Retrofit.Builder()
            .baseUrl(BASE_URL) // "https://raw.githubusercontent.com" 추가 가능
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .create(CountriesApi::class.java)
    }*/



}