package com.carlostorres.dogedex.api

import com.carlostorres.dogedex.data.models.Data
import com.carlostorres.dogedex.data.models.DogListResponse
import com.carlostorres.dogedex.data.models.DogResponse
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val retrofit = Retrofit.Builder()
    .baseUrl("https://todogs.herokuapp.com/api/v1/")
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

interface ApiService{

    @GET("dogs")
    suspend fun getAllDogs(): DogResponse

}

object  DogsApi{
    val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}