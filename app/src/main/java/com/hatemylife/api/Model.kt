package com.hatemylife.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Model(
    @Expose
    @SerializedName("full_name")
    val title: String,
)
