package co.com.ceiba.mobile.pruebadeingreso.data.models.posts_models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class PostsModel(
    @SerializedName("id") val id: Int,
    @SerializedName("userId") val userId: Int,
    @SerializedName("title") val title: String?,
    @SerializedName("body") val body: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(userId)
        parcel.writeString(title)
        parcel.writeString(body)
    }

    companion object CREATOR : Parcelable.Creator<PostsModel> {
        override fun createFromParcel(parcel: Parcel): PostsModel {
            return PostsModel(parcel)
        }

        override fun newArray(size: Int): Array<PostsModel?> {
            return arrayOfNulls(size)
        }
    }

}