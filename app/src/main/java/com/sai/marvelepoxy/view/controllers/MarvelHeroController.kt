package com.sai.marvelepoxy.view.controllers

import com.airbnb.epoxy.TypedEpoxyController
import com.sai.marvelepoxy.model.Poster
import com.sai.marvelepoxy.view.models.marvelHero
import com.sai.marvelepoxy.view.models.marvelTitleImage
import com.sai.marvelepoxy.view.models.marvelTitleText
import java.util.*

class MarvelHeroController(private val callback: IControllerCallback): TypedEpoxyController<List<Poster>>() {

    interface IControllerCallback {
        fun onHeroClicked(poster: Poster)
    }

    override fun buildModels(data: List<Poster>?) {

        marvelTitleImage {
            id(UUID.randomUUID().toString())
        }

        marvelTitleText {
            id(UUID.randomUUID().toString())
            title("Select Your Marvel Hero")
        }

        data?.forEach { poster ->
            marvelHero {
                id(poster.id)
                name(poster.name)
                imageUrl(poster.poster)
                backgroundColor(poster.color)
                clickListener { _, _, _, _ ->
                    callback.onHeroClicked(poster)
                }
            }
        }
    }
}
