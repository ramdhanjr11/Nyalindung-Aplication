package com.muramsyah.nyalindungaplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.muramsyah.nyalindungaplication.R
import com.muramsyah.nyalindungaplication.adapter.LahanDesaAdapter
import com.muramsyah.nyalindungaplication.adapter.SumberAirAdapter
import com.muramsyah.nyalindungaplication.databinding.FragmentSumberAirBinding
import com.muramsyah.nyalindungaplication.databinding.FragmentWilayahBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SumberAirFragment : BottomSheetDialogFragment() {

    private var _binding : FragmentSumberAirBinding? = null
    private val binding get() = _binding!!

    private val viewModel : AllTableViewModel by viewModels()

    private lateinit var adapter: SumberAirAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSumberAirBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = SumberAirAdapter()
        binding.rvData.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        viewModel.sumberAir.observe(viewLifecycleOwner) {
            adapter.dataSumberAir = it.toCollection(arrayListOf())
            binding.rvData.adapter = adapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}