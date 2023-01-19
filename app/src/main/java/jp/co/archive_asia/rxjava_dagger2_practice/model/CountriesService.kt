package jp.co.archive_asia.rxjava_dagger2_practice.model

import io.reactivex.rxjava3.core.Single
import jp.co.archive_asia.rxjava_dagger2_practice.di.DaggerApiComponent
import jp.co.archive_asia.rxjava_dagger2_practice.network.CountriesApi
import javax.inject.Inject

class CountriesService {

    @Inject
    lateinit var api : CountriesApi

    init {
        DaggerApiComponent.create().inject(this)
    }

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