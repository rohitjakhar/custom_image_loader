package com.rohitjakhar.imageloading.domain.repo

import com.rohitjakhar.imageloading.domain.model.PhotoModel
import com.rohitjakhar.imageloading.utils.Resource

interface AppRepo {
    suspend fun getImages(pageId: Int): Resource<List<PhotoModel>>
}