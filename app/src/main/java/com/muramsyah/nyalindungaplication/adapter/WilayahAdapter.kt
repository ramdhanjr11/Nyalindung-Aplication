package com.muramsyah.nyalindungaplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muramsyah.nyalindungaplication.data.source.entity.Wilayah
import com.muramsyah.nyalindungaplication.databinding.ItemCardViewBinding

class WilayahAdapter : RecyclerView.Adapter<WilayahAdapter.ViewHolder>() {

    var dataWilayah: ArrayList<Wilayah> = ArrayList()
        get() = field
        set(value) {
            field.clear()
            field.addAll(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataWilayah[position])
    }

    override fun getItemCount(): Int = dataWilayah.size

    inner class ViewHolder(private val binding: ItemCardViewBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: Wilayah) {
            with(binding) {
                title1.text = "Nama Wilayah"
                title2.text = "Luas Wilayah"
                title3.text = "Jumlah Penduduk"
                title4.text = "Kepadatan Penduduk"

                body1.text = data.namaWilayah
                body2.text = data.luasWilayah.toString()
                body3.text = data.jumlahPenduduk.toString()
                body4.text = data.kepadatanPenduduk.toString()
            }
        }
    }
}