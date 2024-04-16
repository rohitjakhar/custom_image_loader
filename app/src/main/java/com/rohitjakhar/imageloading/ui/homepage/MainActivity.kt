package com.rohitjakhar.imageloading.ui.homepage

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.persistableBundleOf
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.rohitjakhar.imageloading.databinding.ActivityMainBinding
import com.rohitjakhar.imageloading.domain.model.PhotoModel
import com.rohitjakhar.imageloading.utils.Resource
import com.rohitjakhar.imageloading.utils.hide
import com.rohitjakhar.imageloading.utils.show
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val vm: MainViewModel by viewModels()
    private val mAdapter by lazy { MyAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRv()
        setData()
        handleError()
        handleMoreData()
        setMoreData()
    }

    private fun setMoreData() = with(binding){
        lifecycleScope.launch {
            vm.moreImageState.collectLatest {
                when (it) {
                    is Resource.Error -> {
                        btnLoadMore.show()
                        pbMore.hide()
                    }
                    Resource.Loading -> {
                        pbMore.show()
                        btnLoadMore.hide()
                    }
                    is Resource.Empty -> {
                        btnLoadMore.show()
                        pbMore.hide()
                    }
                    is Resource.Success -> {
                        updateList(it)
                        btnLoadMore.show()
                        pbMore.hide()
                    }
                }
            }
        }
    }

    private fun updateList(it: Resource.Success<List<PhotoModel>>) {
        val newList = mutableListOf<PhotoModel>()
        newList.addAll(mAdapter.currentList)
        newList.addAll(it.data)
        mAdapter.submitList(newList)
    }

    private fun handleMoreData() {
        binding.btnLoadMore.setOnClickListener {
            vm.getMoreImage()
        }
    }

    private fun handleError() {
        binding.btnRetry.setOnClickListener {
            vm.getImage()
        }
    }

    private fun setData() = with(binding) {
        lifecycleScope.launch {
            vm.imageState.collectLatest {
                when (it) {
                    is Resource.Error -> {
                        pbLoading.hide()
                        llError.show()
                        tvError.text = it.errorMessage
                        llSuccess.hide()
                    }

                    Resource.Loading -> {
                        pbLoading.show()
                        llError.hide()
                        llSuccess.hide()
                    }

                    is Resource.Success -> {
                        mAdapter.submitList(it.data)
                        pbLoading.hide()
                        llError.hide()
                        llSuccess.show()
                    }
                    is Resource.Empty -> {}
                }
            }

        }
    }

    private fun setupRv() = with(binding) {
        rvImages.layoutManager = GridLayoutManager(this@MainActivity, 2)
        rvImages.adapter = mAdapter
    }
}