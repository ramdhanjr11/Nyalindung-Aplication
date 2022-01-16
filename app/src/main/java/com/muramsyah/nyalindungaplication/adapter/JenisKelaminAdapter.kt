package com.muramsyah.nyalindungaplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muramsyah.nyalindungaplication.data.source.entity.Kelahiran
import com.muramsyah.nyalindungaplication.data.source.entity.PjenisKelamin
import com.muramsyah.nyalindungaplication.data.source.entity.Wilayah
import com.muramsyah.nyalindungaplication.databinding.ItemCardView2Binding

class JenisKelaminAdapter : RecyclerView.Adapter<JenisKelaminAdapter.ViewHolder>() {

    var dataPjenisKelamin: ArrayList<PjenisKelamin> = ArrayList()
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
        holder.bind(dataPjenisKelamin[position])
    }

    override fun getItemCount(): Int = dataPjenisKelamin.size

    inner class ViewHolder(private val binding: ItemCardView2Binding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: PjenisKelamin) {
            with(binding) {
                title1.text = "Nama Wilayah"
                title2.text = "Laki-laki"
                title3.text = "Perempuan"

                body1.text = data.namaWilayah
                body2.text = data.lakiLaki.toString()
                body3.text = data.perempuan.toString()
            }
        }
    }
}