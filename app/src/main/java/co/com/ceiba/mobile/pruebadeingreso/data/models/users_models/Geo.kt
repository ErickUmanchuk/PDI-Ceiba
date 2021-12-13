package co.com.ceiba.mobile.pruebadeingreso.data.models.users_models

import com.google.gson.annotations.SerializedName

class Geo(

    @SerializedName("lat") val lat: String,
    @SerializedName("lng") val lng: String

)