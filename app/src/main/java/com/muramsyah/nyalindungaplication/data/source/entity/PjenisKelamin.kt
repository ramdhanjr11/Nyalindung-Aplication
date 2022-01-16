package com.muramsyah.nyalindungaplication.data.source.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_pjeniskelamin")
data class PjenisKelamin(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    val id: Int,
    @ColumnInfo(name = "Nama_Wilayah")
    val namaWilayah: String,
    @ColumnInfo(name = "Laki_laki")
    val lakiLaki: Int,
    @ColumnInfo(name = "Perempuan")
    val perempuan: Int
)
