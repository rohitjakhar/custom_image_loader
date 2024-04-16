package com.rohitjakhar.imageloading

import android.app.Application
import com.rohitjakhar.imageloading.utils.FileCache
import java.lang.ref.WeakReference

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        diskCache = WeakReference(FileCache(this))
    }
    companion object {
        private lateinit var diskCache: WeakReference<FileCache>
        fun getImageFileCache() = diskCache.get()
    }
}