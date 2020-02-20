package com.qihoo.tbtool.bean
import com.google.gson.annotations.SerializedName


data class Timetamp(
    @SerializedName("api")
    val api: String,
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("ret")
    val ret: List<String>,
    @SerializedName("v")
    val v: String
)

data class Data(
    @SerializedName("t")
    val t: Long
)