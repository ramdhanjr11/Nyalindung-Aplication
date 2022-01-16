package com.muramsyah.nyalindungaplication.data.source.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_wilayah")
data class Wilayah(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    val id: Int,
    @ColumnInfo(name = "Nama_Wilayah")
    val namaWilayah: String,
    @ColumnInfo(name = "Luas_Wilayah")
    val luasWilayah: Int,
    @ColumnInfo(name = "Jumlah_Penduduk")
    val jumlahPenduduk: Int,
    @ColumnInfo(name = "Kepadatan_Penduduk")
    val kepadatanPenduduk: Double
)
