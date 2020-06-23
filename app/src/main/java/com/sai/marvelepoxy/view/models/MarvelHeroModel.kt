package com.sai.marvelepoxy.view.models

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
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
    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash) var clickListener: View.OnClickListener? = null

    override fun bind(holder: MarvelHolder) {
        holder.marvelHeroNameTextView.text = name
        holder.marvelHeroImageView.load(imageUrl) {
            transformations(RoundedCornersTransformation())
        }
        holder.marvelHeroNameTextView.setBackgroundColor(Color.parseColor(backgroundColor))

        clickListener?.let {
            holder.marvelhHeroCardView.setOnClickListener(it)
        }
    }

    override fun unbind(holder: MarvelHolder) {
        holder.marvelhHeroCardView.setOnClickListener(null)
    }
}


class MarvelHolder: KotlinHolder() {
    val marvelhHeroCardView by bind<CardView>(R.id.marvel_hero_card_view)
    val marvelHeroImageView by bind<ImageView>(R.id.marvel_hero_image_view)
    val marvelHeroNameTextView by bind<TextView>(R.id.marvel_hero_name_text_view)
}
