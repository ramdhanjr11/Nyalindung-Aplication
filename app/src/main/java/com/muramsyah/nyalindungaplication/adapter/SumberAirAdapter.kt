package com.muramsyah.nyalindungaplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muramsyah.nyalindungaplication.data.source.entity.LahanDesa
import com.muramsyah.nyalindungaplication.data.source.entity.PsumberAir
import com.muramsyah.nyalindungaplication.databinding.ItemCardViewBinding

class SumberAirAdapter : RecyclerView.Adapter<SumberAirAdapter.ViewHolder>() {

    var dataSumberAir: ArrayList<PsumberAir> = ArrayList()
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
        holder.bind(dataSumberAir[position])
    }

    override fun getItemCount(): Int = dataSumberAir.size

    inner class ViewHolder(private val binding: ItemCardViewBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: PsumberAir) {
            with(binding) {
                title1.text = "Nama Wilayah"
                title2.text = "Sumur Pompa"
                title3.text = "Sumur"
                title4.text = "Mata Air"

                body1.text = data.namaWilayah
                body2.text = data.sumurPompa.toString()
                body3.text = data.sumur.toString()
                body4.text = data.mataAir.toString()
            }
        }
    }
}