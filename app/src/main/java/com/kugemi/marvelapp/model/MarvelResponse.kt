package com.kugemi.marvelapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MarvelResponse(
    @SerializedName("attributionHTML")
    val attributionHTML: String,

    @SerializedName("attributionText")
    val attributionText: String,

    @SerializedName("code")
    val code: Int,

    @SerializedName("copyright")
    val copyright: String,

    @SerializedName("data")
    val data: Data,

    @SerializedName("etag")
    val etag: String,

    @SerializedName("status")
    val status: String
) : Serializable