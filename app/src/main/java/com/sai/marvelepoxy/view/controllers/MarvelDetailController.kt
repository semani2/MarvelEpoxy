package com.sai.marvelepoxy.view.controllers

import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.epoxy.carousel
import com.sai.marvelepoxy.model.Poster
import com.sai.marvelepoxy.view.models.MarvelDetailSeriesModel_
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

            val seriesModels = poster.details.map { details ->
                MarvelDetailSeriesModel_()
                    .id(details.id)
                    .imageUrl(details.poster)
                    .movieDescription(details.plot)
                    .backgroundColor(poster.color)
            }

            carousel {
                id("series")
                padding(Carousel.Padding.dp(8, 4, 8, 16, 8))
                hasFixedSize(true)
                models(seriesModels)
            }
        }
    }
}
