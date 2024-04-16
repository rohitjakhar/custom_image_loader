package com.rohitjakhar.imageloading.ui.homepage

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rohitjakhar.imageloading.utils.Resource
import com.rohitjakhar.imageloading.data.repo.AppRepoImpl
import com.rohitjakhar.imageloading.domain.model.PhotoModel
import com.rohitjakhar.imageloading.domain.repo.AppRepo
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val appRepo: AppRepo = AppRepoImpl()
) : ViewModel() {
    private var pageId: Int = 1
    private var _imageState: MutableStateFlow<Resource<List<PhotoModel>>> = MutableStateFlow(
        Resource.Loading
    )
    val imageState: StateFlow<Resource<List<PhotoModel>>> get() = _imageState.asStateFlow()
    private var _moreImageState: MutableStateFlow<Resource<List<PhotoModel>>> = MutableStateFlow(
        Resource.Empty(Unit)
    )
    val moreImageState: StateFlow<Resource<List<PhotoModel>>> get() = _moreImageState.asStateFlow()

    init {
        getImage()
    }

    fun getImage() {
        viewModelScope.launch {
            _imageState.emit(Resource.Loading)
            delay(400)
            _imageState.emit(appRepo.getImages(pageId))
        }
    }

    fun getMoreImage() {
        viewModelScope.launch {
            _moreImageState.emit(Resource.Loading)
            pageId++
            delay(400)
            _moreImageState.emit(appRepo.getImages(pageId))
        }
    }
}