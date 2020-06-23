package com.sai.marvelepoxy.view.models

import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.sai.marvelepoxy.R

@EpoxyModelClass(layout = R.layout.marvel_hero_title_image_layout)
abstract class MarvelTitleImageModel: EpoxyModelWithHolder<MarvelTitleImageHolder>() {

    override fun getSpanSize(totalSpanCount: Int, position: Int, itemCount: Int): Int {
        return totalSpanCount
    }
}

class MarvelTitleImageHolder: KotlinHolder() {
}
