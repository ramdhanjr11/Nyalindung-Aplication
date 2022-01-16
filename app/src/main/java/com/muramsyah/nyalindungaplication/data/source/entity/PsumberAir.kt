package com.muramsyah.nyalindungaplication.data.source.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_psumberair")
data class PsumberAir(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    val id: Int,
    @ColumnInfo(name = "Nama_Wilayah")
    val namaWilayah: String,
    @ColumnInfo(name = "Sumur_Pompa")
    val sumurPompa: Int,
    @ColumnInfo(name = "Sumur")
    val sumur: Int,
    @ColumnInfo(name = "Mata_Air")
    val mataAir: Int
)
