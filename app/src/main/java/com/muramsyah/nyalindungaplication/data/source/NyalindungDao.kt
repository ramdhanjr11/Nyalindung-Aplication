package com.muramsyah.nyalindungaplication.data.source

import androidx.room.Dao
import androidx.room.Query
import com.muramsyah.nyalindungaplication.data.source.entity.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NyalindungDao {

    @Query("SELECT * FROM tb_wilayah")
    fun getAllWilayah() : Flow<List<Wilayah>>

    @Query("SELECT * FROM tb_kelahiran")
    fun getAllKelahiran() : Flow<List<Kelahiran>>

    @Query("SELECT * FROM tb_pjeniskelamin")
    fun getAllJenisKelamin() : Flow<List<PjenisKelamin>>

    @Query("SELECT * FROM tb_psumberair")
    fun getAllSumberAir() : Flow<List<PsumberAir>>

    @Query("SELECT * FROM tb_lahandesa")
    fun getAllLahanDesa() : Flow<List<LahanDesa>>

}