package com.muramsyah.nyalindungaplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muramsyah.nyalindungaplication.data.repository.NyalindungRepository
import com.muramsyah.nyalindungaplication.data.source.entity.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllTableViewModel @Inject constructor(private val repository: NyalindungRepository) : ViewModel() {

    private var _wilayah = MutableLiveData<List<Wilayah>>()
    val wilayah : LiveData<List<Wilayah>> = _wilayah

    private var _kelahiran = MutableLiveData<List<Kelahiran>>()
    val kelahiran : LiveData<List<Kelahiran>> = _kelahiran

    private var _lahanDesa = MutableLiveData<List<LahanDesa>>()
    val lahanDesa : LiveData<List<LahanDesa>> = _lahanDesa

    private var _jenisKelamin = MutableLiveData<List<PjenisKelamin>>()
    val jenisKelamin : LiveData<List<PjenisKelamin>> = _jenisKelamin

    private var _sumberAir = MutableLiveData<List<PsumberAir>>()
    val sumberAir : LiveData<List<PsumberAir>> = _sumberAir

    init {
        getAllWilayah()
        getAllKelahiran()
        getAllLahanDesa()
        getAllJenisKelamin()
        getAllSumberAir()
    }

    private fun getAllWilayah() {
        viewModelScope.launch {
            repository.getAllWilayah().collect {
                _wilayah.postValue(it)
            }
        }
    }

    private fun getAllKelahiran() {
        viewModelScope.launch {
            repository.getAllKelahiran().collect {
                _kelahiran.postValue(it)
            }
        }
    }

    private fun getAllLahanDesa() {
        viewModelScope.launch {
            repository.getAllLahanDesa().collect {
                _lahanDesa.postValue(it)
            }
        }
    }

    private fun getAllJenisKelamin() {
        viewModelScope.launch {
            repository.getAllJenisKelamin().collect {
                _jenisKelamin.postValue(it)
            }
        }
    }

    private fun getAllSumberAir() {
        viewModelScope.launch {
            repository.getAllSumberAir().collect {
                _sumberAir.postValue(it)
            }
        }
    }

}