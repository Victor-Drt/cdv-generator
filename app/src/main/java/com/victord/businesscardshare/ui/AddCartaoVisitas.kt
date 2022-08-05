package com.victord.businesscardshare.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.victord.businesscardshare.databinding.ActivityAddCartaoVisitasBinding

class AddCartaoVisitas : AppCompatActivity() {
    private val binding by lazy { ActivityAddCartaoVisitasBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners () {
        binding.ibClose.setOnClickListener {
            finish()
        }

        binding.btnConfirm.setOnClickListener {

        }
    }
}