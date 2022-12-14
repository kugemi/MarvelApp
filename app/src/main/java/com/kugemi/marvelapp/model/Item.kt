package com.kugemi.marvelapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Item(
    @SerializedName("name")
    val name: String,

    @SerializedName("resourceURI")
    val resourceURI: String
) : Serializable