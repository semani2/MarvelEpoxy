package com.sai.marvelepoxy.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Poster(
    @PrimaryKey val id: Long,
    val name: String,
    val color: String,
    val quote: String,
    val poster: String,
    val details: List<PosterDetails>
)
