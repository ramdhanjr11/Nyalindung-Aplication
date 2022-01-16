package com.muramsyah.nyalindungaplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.muramsyah.nyalindungaplication.adapter.SumberAirAdapter
import com.muramsyah.nyalindungaplication.adapter.WilayahAdapter
import com.muramsyah.nyalindungaplication.databinding.FragmentWilayahBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WilayahFragment : BottomSheetDialogFragment() {

    private var _binding : FragmentWilayahBinding? = null
    private val binding get() = _binding!!

    private val viewModel : AllTableViewModel by viewModels()

    private lateinit var adapter: WilayahAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWilayahBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = WilayahAdapter()
        binding.rvData.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        viewModel.wilayah.observe(viewLifecycleOwner) {
            adapter.dataWilayah = it.toCollection(arrayListOf())
            binding.rvData.adapter = adapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}