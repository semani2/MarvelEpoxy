package com.sai.marvelepoxy.view.models

import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.sai.marvelepoxy.R

@EpoxyModelClass(layout = R.layout.marvel_detail_text_section_layout)
abstract class MarvelDetailsTextSectionModel: EpoxyModelWithHolder<MarvelDetailTextSectionHolder>() {
}

class MarvelDetailTextSectionHolder: KotlinHolder()
