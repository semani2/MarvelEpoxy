package com.sai.marvelepoxy.data.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sai.marvelepoxy.model.Poster

@Database(entities = [Poster::class], version = 1)
@TypeConverters(value = [PosterDetailsConverter::class])
abstract class AppDatabase : RoomDatabase() {

    abstract fun posterDao(): PosterDao
}
