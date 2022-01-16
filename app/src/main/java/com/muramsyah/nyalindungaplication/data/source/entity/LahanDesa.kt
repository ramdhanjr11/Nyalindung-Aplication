package com.muramsyah.nyalindungaplication.data.source.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_lahandesa")
data class LahanDesa(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    val id: Int,
    @ColumnInfo(name = "Nama_Wilayah")
    val namaWilayah: String,
    @ColumnInfo(name = "Sawah")
    val sawah: Int,
    @ColumnInfo(name = "Bukan_Sawah")
    val bukanSawah: Int,
    @ColumnInfo(name = "Non_Pertanian")
    val nonPertanian: Double
)
