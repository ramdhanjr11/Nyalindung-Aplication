package com.muramsyah.nyalindungaplication.data.source.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_kelahiran")
data class Kelahiran(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    val id: Int,
    @ColumnInfo(name = "Nama_Wilayah")
    val namaWilayah: String,
    @ColumnInfo(name = "Jumlah_Kelahiran")
    val jumlahKelahiran: Int,
    @ColumnInfo(name = "Jumlah_Kematian")
    val jumlahKematian: Int
)
