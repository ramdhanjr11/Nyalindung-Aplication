package com.muramsyah.nyalindungaplication.di

import android.content.Context
import androidx.room.Room
import com.muramsyah.nyalindungaplication.data.repository.NyalindungRepository
import com.muramsyah.nyalindungaplication.data.source.NyalindungDao
import com.muramsyah.nyalindungaplication.data.source.NyalindungDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext application: Context) = Room.databaseBuilder(
        application,
        NyalindungDatabase::class.java,
        "Nyalindung_db"
    ).createFromAsset("nyalindung.db").build()

    @Singleton
    @Provides
    fun provideDao(db: NyalindungDatabase) = db.nyalindungDao()

    @Singleton
    @Provides
    fun provideRepository(database: NyalindungDao) = NyalindungRepository(database)
}