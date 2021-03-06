package com.example.android.marsphotos.network

import retrofit2.Retrofit
import com.squareup.moshi.Moshi
import retrofit2.http.GET
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


class MarsApiService {

    companion object {
        private const val BASE_URL =
            "https://android-kotlin-fun-mars-server.appspot.com"
    }






    object MarsApi {
        private val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        private val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()

        val RetrofitService : MarsApiService by lazy {
            MarsApi.retrofit.create(MarsApiService::class.java) }
    }


    interface MarsApiService {
        @GET("photos")
        suspend fun getPhotos(): List<MarsPhoto>
    }


}