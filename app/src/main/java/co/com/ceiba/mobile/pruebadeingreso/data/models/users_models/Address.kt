package co.com.ceiba.mobile.pruebadeingreso.data.models.users_models

import com.google.gson.annotations.SerializedName

class Address(

    @SerializedName("street") val street: String,
    @SerializedName("suite") val suite: String,
    @SerializedName("city") val city: String,
    @SerializedName("zipcode") val zipcode: String,
    @SerializedName("geo") val geo: Geo

    )