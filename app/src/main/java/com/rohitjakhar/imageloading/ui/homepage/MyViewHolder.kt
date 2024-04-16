package com.rohitjakhar.imageloading.ui.homepage

import android.content.Context
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.rohitjakhar.imageloading.R
import com.rohitjakhar.imageloading.databinding.ItemImageBinding
import com.rohitjakhar.imageloading.domain.model.PhotoModel
import com.rohitjakhar.imageloading.utils.loadImage

class MyViewHolder(private val itemImageBinding: ItemImageBinding) :
    RecyclerView.ViewHolder(itemImageBinding.root) {
    private val context: Context = itemImageBinding.root.context
    fun bind(photoModel: PhotoModel) {
        itemImageBinding.ivImage.loadImage(
            photoModel.photoUrl,
            placeHolder = AppCompatResources.getDrawable(context, R.drawable.outline_placeholder),
            error = AppCompatResources.getDrawable(context, R.drawable.outline_error)
        )
    }
}