package com.sai.marvelepoxy.data.persistence

import androidx.room.TypeConverter
import com.sai.marvelepoxy.model.PosterDetails
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.reflect.Type

class PosterDetailsConverter {

    @TypeConverter
    fun fromString(value: String): List<PosterDetails>? {
        return getMoshiAdapter().fromJson(value)
    }

    @TypeConverter
    fun fromList(list: List<PosterDetails>): String {
        return getMoshiAdapter().toJson(list)
    }

    private fun getMoshiAdapter(): JsonAdapter<List<PosterDetails>> {
        val moshi = Moshi.Builder().build()
        val type: Type = Types.newParameterizedType(
            MutableList::class.java,
            PosterDetails::class.java
        )
        return moshi.adapter(type)
    }
}
