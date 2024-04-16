package com.rohitjakhar.imageloading.utils

import android.view.View
import androidx.core.view.isVisible

fun View.show() {
    isVisible = true
}

fun View.hide() {
    isVisible = false
}