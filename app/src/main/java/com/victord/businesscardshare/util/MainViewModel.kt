package com.victord.businesscardshare.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.victord.businesscardshare.data.CartaoVisita
import com.victord.businesscardshare.data.CartaoVisitaRepository

class MainViewModel(private val cartaoVisitaRepository: CartaoVisitaRepository) : ViewModel() {

    fun insert(cartaoVisita: CartaoVisita) {
        cartaoVisitaRepository.insert(cartaoVisita)
    }

    fun getAll() : LiveData<List<CartaoVisita>> {
        return cartaoVisitaRepository.getAll()
    }

}

class MainViewModelFactory (private val repository: CartaoVisitaRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }
}
