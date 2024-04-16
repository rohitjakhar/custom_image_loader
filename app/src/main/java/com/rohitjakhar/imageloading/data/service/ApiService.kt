package com.rohitjakhar.imageloading.data.service

import PhotosDto
import com.google.gson.Gson
import com.rohitjakhar.imageloading.BuildConfig
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("photos/")
    suspend fun getImages(
        @Query("page") pageId: Int,
        @Query("client_id") clientId: String = BuildConfig.KEY
    ): Response<PhotosDto>


    companion object {
        private const val baseURL = "https://api.unsplash.com/"
        val retrofit: ApiService = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
            .create(ApiService::class.java)
    }
}