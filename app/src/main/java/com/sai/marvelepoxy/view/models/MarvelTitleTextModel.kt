package com.sai.marvelepoxy.view.models

import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.sai.marvelepoxy.R

@EpoxyModelClass(layout = R.layout.marvel_title_text_layout)
abstract class MarvelTitleTextModel: EpoxyModelWithHolder<MarvelTitleTextHolder>() {

    @EpoxyAttribute lateinit var title: String

    override fun bind(holder: MarvelTitleTextHolder) {
        holder.marvelTitleTextView.text = title
    }

    override fun getSpanSize(totalSpanCount: Int, position: Int, itemCount: Int): Int {
        return totalSpanCount
    }
}

class MarvelTitleTextHolder: KotlinHolder() {
    val marvelTitleTextView by bind<TextView>(R.id.title_text_view)
}
