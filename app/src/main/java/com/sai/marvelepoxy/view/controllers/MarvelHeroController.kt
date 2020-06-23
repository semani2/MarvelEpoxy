package com.sai.marvelepoxy.view.controllers

import com.airbnb.epoxy.TypedEpoxyController
import com.sai.marvelepoxy.model.Poster
import com.sai.marvelepoxy.view.models.marvelHero
import com.sai.marvelepoxy.view.models.marvelTitleImage
import java.util.*

class MarvelHeroController: TypedEpoxyController<List<Poster>>() {
    override fun buildModels(data: List<Poster>?) {

        marvelTitleImage {
            id(UUID.randomUUID().toString())
        }

        data?.forEach { poster ->
            marvelHero {
                id(poster.id)
                name(poster.name)
                imageUrl(poster.poster)
                backgroundColor(poster.color)
            }
        }
    }
}
