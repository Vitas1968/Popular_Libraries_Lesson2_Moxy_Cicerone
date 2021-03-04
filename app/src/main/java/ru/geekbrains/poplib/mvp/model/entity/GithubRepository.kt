package ru.geekbrains.poplib.mvp.model.entity

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//https://api.github.com/users/googlesamples/repos
@Parcelize
data class GithubRepository(
    val id: String,
    val name: String,
    val forksCount: Int
): Parcelable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GithubRepository

        if (id != other.id) return false
        return true
    }
}