package com.yalantis.coreui.utils

import android.databinding.BindingAdapter
import android.databinding.BindingConversion
import android.view.View
import android.widget.ImageView

/**
 * This file stands for listing functions that are needed to bind specific data to a common views
 */

//@BindingAdapter("url")
//fun loadImage(imageView: ImageView, url: String?) {
//    Picasso.get()
//            .load(url)
//            .placeholder(R.drawable.ic_launcher_background)
//            .into(imageView)
//}

@BindingConversion
fun booleanToVisibility(visible: Boolean): Int {
    return if (visible) View.VISIBLE else View.GONE
}