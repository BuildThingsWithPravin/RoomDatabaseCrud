/*
 * *
 *  * Created by Rafsan Ahmad on 17/08/22, 3:29 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *
 */

package com.example.demohilt.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GenericResponseArray<T>(
    @Expose
    @SerializedName("code")
    val code: String,
    @Expose
    @SerializedName("data")
    var `data`: MutableList<T>,
    @Expose
    @SerializedName("message")
    val message: Any
)

data class GenericResponseObject<T>(
    @Expose @SerializedName("code")
    val code: String,
    @Expose @SerializedName("data")
    var `data`: T,
    @Expose @SerializedName("message")
    val message: Any,
)