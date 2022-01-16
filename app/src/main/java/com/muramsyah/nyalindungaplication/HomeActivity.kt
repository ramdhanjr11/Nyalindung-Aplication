package com.muramsyah.nyalindungaplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.muramsyah.nyalindungaplication.databinding.ActivityHomeBinding
import com.muramsyah.nyalindungaplication.ui.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private var _binding: ActivityHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClickedEvent()
    }

    private fun onClickedEvent() {
        binding.btnInfo.setOnClickListener {  }

        binding.rlPetaNyalindung.setOnClickListener {
            val intent = Intent(this, PetaNyalindungActivity::class.java)
            startActivity(intent)
        }

        binding.rlPendudukWilayah.setOnClickListener {
            val pendudukWilayahFragment = WilayahFragment()
            pendudukWilayahFragment.show(supportFragmentManager, WilayahFragment::class.java.name)
        }

        binding.rlKelahiranKematian.setOnClickListener {
            val kelahiranFragment = KelahiranFragment()
            kelahiranFragment.show(supportFragmentManager, KelahiranFragment::class.java.name)
        }

        binding.rlLahanDesa.setOnClickListener {
            val lahanDesaFragment = LahanDesaFragment()
            lahanDesaFragment.show(supportFragmentManager, LahanDesaFragment::class.java.name)
        }

        binding.rlPendudukJenisKelamin.setOnClickListener {
            val jenisKelaminFragment = JenisKelaminFragment()
            jenisKelaminFragment.show(supportFragmentManager, JenisKelaminFragment::class.java.name)
        }

        binding.rlPenggunaSumberAir.setOnClickListener {
            val sumberAirFragment = SumberAirFragment()
            sumberAirFragment.show(supportFragmentManager, SumberAirFragment::class.java.name)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}