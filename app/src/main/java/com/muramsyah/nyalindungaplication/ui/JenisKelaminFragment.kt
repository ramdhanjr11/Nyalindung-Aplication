package com.muramsyah.nyalindungaplication.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.muramsyah.nyalindungaplication.R
import com.muramsyah.nyalindungaplication.adapter.JenisKelaminAdapter
import com.muramsyah.nyalindungaplication.databinding.FragmentJenisKelaminBinding
import com.muramsyah.nyalindungaplication.databinding.FragmentKelahiranBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JenisKelaminFragment : BottomSheetDialogFragment() {

    private var _binding : FragmentJenisKelaminBinding? = null
    private val binding get() = _binding!!

    private val viewModel : AllTableViewModel by viewModels()

    private lateinit var adapter: JenisKelaminAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJenisKelaminBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = JenisKelaminAdapter()
        binding.rvData.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        viewModel.jenisKelamin.observe(viewLifecycleOwner) {
            adapter.dataPjenisKelamin = it.toCollection(arrayListOf())
            binding.rvData.adapter = adapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}