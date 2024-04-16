package com.rohitjakhar.imageloading.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.rohitjakhar.imageloading.MyApp
import com.rohitjakhar.imageloading.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.lang.ref.SoftReference
import java.net.HttpURLConnection
import java.net.URL

private const val DISK_CACHE_SUBDIR = "thumbnails"

fun ImageView.loadImage(imageUrl: String, error: Drawable? = null, placeHolder: Drawable? = null) {
    AsyncImageLoader(
        imageUrl = imageUrl,
        targetView = this,
        placeHolder = placeHolder,
        error = error
    )
}

class AsyncImageLoader(
    val imageUrl: String,
    val targetView: ImageView,
    val placeHolder: Drawable?,
    val error: Drawable?
) {
    private val fileCache by lazy { MyApp.getImageFileCache() }
    private val job = CoroutineScope(Job())

    init {
        job.launch {
            loadImage()
        }
    }

    private suspend fun loadImage() {
        placeHolder?.let {
            withContext(Dispatchers.Main) {
                targetView.setImageDrawable(it)
            }
        }
        coroutineScope {
            val bitmap = fileCache?.getBitmapFromDiskCache(imageUrl) ?: getBitmapFromNetwork(imageUrl)
            delay(200)
            withContext(Dispatchers.Main) {
                bitmap?.let {
                    withContext(Dispatchers.Main) {
                        targetView.setImageBitmap(bitmap)
                    }
                } ?: targetView.setImageDrawable(error)
            }
        }
    }

    private suspend fun getBitmapFromNetwork(imageUrl: String): Bitmap? {
        return withContext(Dispatchers.IO) {
            runCatching {
                val url = URL(imageUrl)
                val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
                connection.doInput = true
                connection.connect()
                val input: InputStream = connection.inputStream
                val bitmap = BitmapFactory.decodeStream(input)
                fileCache?.saveBitmapToDiskCache(imageUrl, bitmap)
                bitmap
            }.getOrNull()
        }
    }
}

class MemoryCache {
    private val cache = mutableMapOf<String, SoftReference<Bitmap>>()

    operator fun get(id: String): Bitmap? {
        if (!cache.containsKey(id)) return null
        val ref = cache[id]!!
        return ref.get()
    }

    fun put(id: String, bitmap: Bitmap) {
        cache[id] = SoftReference(bitmap)
    }

    fun clear() {
        cache.clear()
    }
}

class FileCache(context: Context) {
    private val cacheDir = File(context.cacheDir, DISK_CACHE_SUBDIR)
    fun getBitmapFromDiskCache(imageUrl: String): Bitmap? {
        val cacheFile = File(cacheDir, imageUrl.hashCode().toString())
        if (cacheFile.exists()) {
            val inputStream = FileInputStream(cacheFile)
            return BitmapFactory.decodeStream(inputStream)
        }
        return null
    }

    fun saveBitmapToDiskCache(imageUrl: String, bitmap: Bitmap) {
        if (!cacheDir.exists()) {
            cacheDir.mkdirs()
        }
        val cacheFile = File(cacheDir, imageUrl.hashCode().toString())
        try {
            val outputStream = FileOutputStream(cacheFile)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
            outputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}