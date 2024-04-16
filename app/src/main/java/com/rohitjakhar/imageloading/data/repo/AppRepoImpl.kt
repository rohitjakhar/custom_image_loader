package com.rohitjakhar.imageloading.data.repo

import com.rohitjakhar.imageloading.data.service.ApiService
import com.rohitjakhar.imageloading.domain.model.PhotoModel
import com.rohitjakhar.imageloading.utils.Resource
import com.rohitjakhar.imageloading.domain.repo.AppRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import toPhotoModels

class AppRepoImpl(
    private val apiService: ApiService = ApiService.retrofit,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : AppRepo {
    override suspend fun getImages(pageId: Int): Resource<List<PhotoModel>> = withContext(dispatcher) {
        try {
            val resp = apiService.getImages(pageId = pageId)
            if (resp.isSuccessful && resp.body().isNullOrEmpty().not()) {
                val images: List<PhotoModel> = resp.body()!!.toPhotoModels()
                if (images.isNotEmpty()) {
                    Resource.Success(images)
                } else {
                    Resource.Error(errorMessage = "Something Went Wrong!")
                }
            } else {
                Resource.Error(resp.message())
            }
        } catch (e: Exception) {
            Resource.Error(errorMessage = e.message ?: "Something Went Wrong!")
        }
    }
}