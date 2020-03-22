package ru.geekbrains.poplib.mvp.model.entity

import android.os.Parcel
import android.os.Parcelable

//https://api.github.com/users/googlesamples/repos
data class GithubRepository(
    val id: String,
    val name: String,
    val forksCount: Int
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeInt(forksCount)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GithubRepository> {
        override fun createFromParcel(parcel: Parcel): GithubRepository {
            return GithubRepository(parcel)
        }

        override fun newArray(size: Int): Array<GithubRepository?> {
            return arrayOfNulls(size)
        }
    }
}