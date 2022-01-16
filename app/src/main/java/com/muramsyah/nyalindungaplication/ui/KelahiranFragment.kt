package com.muramsyah.nyalindungaplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.muramsyah.nyalindungaplication.R
import com.muramsyah.nyalindungaplication.adapter.JenisKelaminAdapter
import com.muramsyah.nyalindungaplication.adapter.KelahiranAdapter
import com.muramsyah.nyalindungaplication.databinding.FragmentKelahiranBinding
import com.muramsyah.nyalindungaplication.databinding.FragmentLahanDesaBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KelahiranFragment : BottomSheetDialogFragment() {

    private var _binding : FragmentKelahiranBinding? = null
    private val binding get() = _binding!!

    private val viewModel : AllTableViewModel by viewModels()

    private lateinit var adapter: KelahiranAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentKelahiranBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = KelahiranAdapter()
        binding.rvData.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        viewModel.kelahiran.observe(viewLifecycleOwner) {
            adapter.dataKelahiran = it.toCollection(arrayListOf())
            binding.rvData.adapter = adapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}