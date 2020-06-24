package com.sai.marvelepoxy.view.models

import android.graphics.Color
import android.widget.ImageView
import android.widget.TextView
import coil.api.load
import coil.size.Scale
import coil.transform.RoundedCornersTransformation
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.sai.marvelepoxy.R

@EpoxyModelClass(layout = R.layout.detail_series_layout)
abstract class MarvelDetailSeriesModel: EpoxyModelWithHolder<MarvelDetailSeriesHolder>() {

    @EpoxyAttribute lateinit var imageUrl: String
    @EpoxyAttribute lateinit var movieDescription: String
    @EpoxyAttribute lateinit var backgroundColor: String

    override fun bind(holder: MarvelDetailSeriesHolder) {
        holder.detailSeriesImageView.load(imageUrl) {
            transformations(RoundedCornersTransformation())
            scale(Scale.FILL)
        }
        holder.detailSeriesTextView.text = movieDescription
        holder.detailSeriesTextView.setBackgroundColor(Color.parseColor(backgroundColor))
    }
}

class MarvelDetailSeriesHolder: KotlinHolder() {
    val detailSeriesImageView by bind<ImageView>(R.id.detail_series_image_view)
    val detailSeriesTextView by bind<TextView>(R.id.detail_series_text_view)
}
