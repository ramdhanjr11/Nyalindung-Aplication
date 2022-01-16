package com.muramsyah.nyalindungaplication.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.muramsyah.nyalindungaplication.data.source.entity.*

@Database(entities = [Wilayah::class, PsumberAir::class, PjenisKelamin::class, LahanDesa::class, Kelahiran::class], version = 1, exportSchema = true)
abstract class NyalindungDatabase : RoomDatabase() {
    abstract fun nyalindungDao() : NyalindungDao
}