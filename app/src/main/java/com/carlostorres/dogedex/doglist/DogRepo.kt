package com.carlostorres.dogedex.doglist

import com.carlostorres.dogedex.api.DogsApi.retrofitService
import com.carlostorres.dogedex.data.models.DogListResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogRepo {

    suspend fun downloadDogs() : List<DogListResponse>{
        return withContext(Dispatchers.IO){
            val dogListApiResponse = retrofitService.getAllDogs()
            dogListApiResponse.data.dogs
        }
    }

}