package com.muramsyah.nyalindungaplication.data.repository

import com.muramsyah.nyalindungaplication.data.source.NyalindungDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NyalindungRepository @Inject constructor(private val nyalindungDao: NyalindungDao) {

    fun getAllWilayah() = nyalindungDao.getAllWilayah()

    fun getAllKelahiran() = nyalindungDao.getAllKelahiran()

    fun getAllLahanDesa() = nyalindungDao.getAllLahanDesa()

    fun getAllJenisKelamin() = nyalindungDao.getAllJenisKelamin()

    fun getAllSumberAir() = nyalindungDao.getAllSumberAir()

}