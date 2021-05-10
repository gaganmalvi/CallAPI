package com.hatemylife.api
import retrofit2.Call
import retrofit2.http.GET
interface ApiInterface {
    @GET("repos")
    fun getPhotos(): Call<List<Model>>
}