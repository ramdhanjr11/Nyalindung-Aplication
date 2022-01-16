package com.muramsyah.nyalindungaplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muramsyah.nyalindungaplication.data.source.entity.LahanDesa
import com.muramsyah.nyalindungaplication.databinding.ItemCardViewBinding

class LahanDesaAdapter : RecyclerView.Adapter<LahanDesaAdapter.ViewHolder>() {

    var dataLahanDesa: ArrayList<LahanDesa> = ArrayList()
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
        holder.bind(dataLahanDesa[position])
    }

    override fun getItemCount(): Int = dataLahanDesa.size

    inner class ViewHolder(private val binding: ItemCardViewBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: LahanDesa) {
            with(binding) {
                title1.text = "Nama Wilayah"
                title2.text = "Sawah"
                title3.text = "Bukan Sawah"
                title4.text = "Non Pertanian"

                body1.text = data.namaWilayah
                body2.text = data.sawah.toString()
                body3.text = data.bukanSawah.toString()
                body4.text = data.nonPertanian.toString()
            }
        }
    }
}