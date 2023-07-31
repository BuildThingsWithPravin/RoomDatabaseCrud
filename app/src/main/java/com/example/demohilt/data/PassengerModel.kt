package com.example.demohilt.data


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class PassengerModel(
    @SerializedName("data")
    var `data`: List<Data>,
    @SerializedName("totalPages")
    var totalPages: Int,
    @SerializedName("totalPassengers")
    var totalPassengers: Int,
    @SerializedName("info") val pageInfo: PageInfo,
) : Parcelable {
    @Parcelize
    data class Data(
        @SerializedName("airline")
        var airline: List<Airline>,
        @SerializedName("_id")
        var id: String,
        @SerializedName("name")
        var name: String,
        @SerializedName("trips")
        var trips: Int,
        @SerializedName("__v")
        var v: Int,
    ) : Parcelable {
        @Parcelize
        data class Airline(
            @SerializedName("country")
            var country: String,
            @SerializedName("established")
            var established: String,
            @SerializedName("head_quaters")
            var headQuaters: String,
            @SerializedName("_id")
            var _id: String,
            @SerializedName("id")
            var id: Int,
            @SerializedName("logo")
            var logo: String,
            @SerializedName("name")
            var name: String,
            @SerializedName("slogan")
            var slogan: String,
            @SerializedName("__v")
            var v: Int,
            @SerializedName("website")
            var website: String,
        ) : Parcelable
    }

    @Parcelize
    data class PageInfo(
        val count: Int,
        val pages: Int,
        val next: String,
        val prev: String?,
    ) : Parcelable
}