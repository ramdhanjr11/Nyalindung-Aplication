package com.muramsyah.nyalindungaplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.muramsyah.nyalindungaplication.R
import com.muramsyah.nyalindungaplication.adapter.KelahiranAdapter
import com.muramsyah.nyalindungaplication.adapter.LahanDesaAdapter
import com.muramsyah.nyalindungaplication.databinding.FragmentLahanDesaBinding
import com.muramsyah.nyalindungaplication.databinding.FragmentSumberAirBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LahanDesaFragment : BottomSheetDialogFragment() {

    private var _binding : FragmentLahanDesaBinding? = null
    private val binding get() = _binding!!

    private val viewModel : AllTableViewModel by viewModels()

    private lateinit var adapter: LahanDesaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLahanDesaBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = LahanDesaAdapter()
        binding.rvData.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        viewModel.lahanDesa.observe(viewLifecycleOwner) {
            adapter.dataLahanDesa = it.toCollection(arrayListOf())
            binding.rvData.adapter = adapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}