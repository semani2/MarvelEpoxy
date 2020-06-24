package com.sai.marvelepoxy.view.controllers

import com.airbnb.epoxy.TypedEpoxyController
import com.sai.marvelepoxy.model.Poster
import com.sai.marvelepoxy.view.models.marvelDetailHeader
import com.sai.marvelepoxy.view.models.marvelDetailsTextSection
import java.util.*

class MarvelDetailController(private val detailBackCallback: IDetailBackCallback): TypedEpoxyController<Poster>() {

    interface IDetailBackCallback {
        fun onBackClicked()
    }

    override fun buildModels(data: Poster?) {
        data?.let { poster ->
            marvelDetailHeader {
                id(poster.id)
                name(poster.name)
                quote(poster.quote)
                imageUrl(poster.poster)
                backClickListener { _, _, _, _ -> detailBackCallback.onBackClicked() }
            }

            marvelDetailsTextSection {
                id(UUID.randomUUID().toString())
            }
        }
    }
}
