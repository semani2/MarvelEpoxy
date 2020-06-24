package com.sai.marvelepoxy.view.models

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import coil.api.load
import coil.size.Scale
import coil.transform.RoundedCornersTransformation
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.sai.marvelepoxy.R
import java.util.*

@EpoxyModelClass(layout = R.layout.marvel_detail_header_layout)
abstract class MarvelDetailHeaderModel: EpoxyModelWithHolder<MarvelDetailHeaderModel.MarvelDetailHeaderHolder>() {

    @EpoxyAttribute lateinit var name: String
    @EpoxyAttribute lateinit var quote: String
    @EpoxyAttribute lateinit var imageUrl: String
    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash) var backClickListener: View.OnClickListener? = null

    override fun bind(holder: MarvelDetailHeaderHolder) {
        holder.detailBackButton.setOnClickListener(backClickListener)
        holder.marvelDetailImageView.load(imageUrl) {
            transformations(RoundedCornersTransformation())
            scale(Scale.FILL)
        }
        holder.marvelDetailQuoteTextView.text = quote.toUpperCase(Locale.ROOT)
        holder.marvelDetailNameTextView.text = name
    }

    class MarvelDetailHeaderHolder: KotlinHolder() {
        val detailBackButton by bind<ImageButton>(R.id.detail_back_image_button)
        val marvelDetailImageView by bind<ImageView>(R.id.detail_header_image_view)
        val marvelDetailQuoteTextView by bind<TextView>(R.id.detail_header_text_view)
        val marvelDetailNameTextView by bind<TextView>(R.id.detail_name_text_view)
    }
}
