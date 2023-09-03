package ru.sr

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(any: Any) {
    Glide.with(this)
        .load(any)
        .into(this)
}