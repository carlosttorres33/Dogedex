package com.carlostorres.dogedex.data.models

data class DogResponse(
    val data: Data,
    val is_success: Boolean,
    val message: String
)