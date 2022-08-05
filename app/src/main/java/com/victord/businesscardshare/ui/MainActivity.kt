package com.victord.businesscardshare.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.victord.businesscardshare.App
import com.victord.businesscardshare.databinding.ActivityMainBinding
import com.victord.businesscardshare.util.MainViewModel
import com.victord.businesscardshare.util.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private val binding by lazy {  ActivityMainBinding.inflate(layoutInflater) }
    private val mainViewModel : MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }
    private val adapter by lazy { CartaoVisitaAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCartoes.adapter = adapter
        getAllCartaoVisita()
        insertListeners()
    }

    private fun insertListeners () {
        binding.fabAddCartao.setOnClickListener {
            val intent = Intent(this@MainActivity, AddCartaoVisitas::class.java)
            startActivity(intent) // vai pra proxima tela
        }
    }

    private fun getAllCartaoVisita() {
        mainViewModel.getAll().observe(this) {
            adapter.submitList(it)
        }
    }
}