package com.sai.marvelepoxy.view.models

import android.graphics.Color
import android.widget.ImageView
import android.widget.TextView
import coil.api.load
import coil.transform.RoundedCornersTransformation
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.sai.marvelepoxy.R

@EpoxyModelClass(layout = R.layout.item_marvel_hero)
abstract class MarvelHeroModel: EpoxyModelWithHolder<MarvelHolder>() {

    @EpoxyAttribute lateinit var name: String
    @EpoxyAttribute lateinit var imageUrl: String
    @EpoxyAttribute lateinit var backgroundColor: String

    override fun bind(holder: MarvelHolder) {
        holder.marvelHeroNameTextView.text = name
        holder.marvelHeroImageView.load(imageUrl) {
            transformations(RoundedCornersTransformation())
        }
        holder.marvelHeroNameTextView.setBackgroundColor(Color.parseColor(backgroundColor))
    }
}


class MarvelHolder: KotlinHolder() {
    val marvelHeroImageView by bind<ImageView>(R.id.marvel_hero_image_view)
    val marvelHeroNameTextView by bind<TextView>(R.id.marvel_hero_name_text_view)
}
