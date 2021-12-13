package co.com.ceiba.mobile.pruebadeingreso.data.models.users_models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class UsersModel(

    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String?,
    @SerializedName("username") val username: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("phone") val phone: String?,
    @SerializedName("website") val website: String?
    //@SerializedName("address") val address: Address

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(username)
        parcel.writeString(email)
        parcel.writeString(phone)
        parcel.writeString(website)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UsersModel> {
        override fun createFromParcel(parcel: Parcel): UsersModel {
            return UsersModel(parcel)
        }

        override fun newArray(size: Int): Array<UsersModel?> {
            return arrayOfNulls(size)
        }
    }

}