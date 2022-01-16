package com.muramsyah.nyalindungaplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muramsyah.nyalindungaplication.data.source.entity.Kelahiran
import com.muramsyah.nyalindungaplication.data.source.entity.Wilayah
import com.muramsyah.nyalindungaplication.databinding.ItemCardView2Binding

class KelahiranAdapter : RecyclerView.Adapter<KelahiranAdapter.ViewHolder>() {

    var dataKelahiran: ArrayList<Kelahiran> = ArrayList()
        get() = field
        set(value) {
            field.clear()
            field.addAll(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemCardView2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataKelahiran[position])
    }

    override fun getItemCount(): Int = dataKelahiran.size

    inner class ViewHolder(private val binding: ItemCardView2Binding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: Kelahiran) {
            with(binding) {
                title1.text = "Nama Wilayah"
                title2.text = "Jumlah Kelahiran"
                title3.text = "Jumlah Kematian"

                body1.text = data.namaWilayah
                body2.text = data.jumlahKelahiran.toString()
                body3.text = data.jumlahKematian.toString()
            }
        }
    }
}