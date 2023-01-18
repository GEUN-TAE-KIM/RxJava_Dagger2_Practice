package jp.co.archive_asia.rxjava_dagger2_practice.model

import com.google.gson.annotations.SerializedName

data class Country(

    @SerializedName("name")
    val countryName: String?,

    @SerializedName("capital")
    val capital: String?,

    @SerializedName("flagPNG")
    val flag: String?,
)