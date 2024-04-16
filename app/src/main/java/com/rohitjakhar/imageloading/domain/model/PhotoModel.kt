package com.rohitjakhar.imageloading.domain.model

import androidx.annotation.Keep

@Keep
data class PhotoModel(
    val photoUrl: String,
    val id: String
)
