package com.victord.businesscardshare

import android.app.Application
import com.victord.businesscardshare.data.AppDatabase
import com.victord.businesscardshare.data.CartaoVisitaRepository

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { CartaoVisitaRepository(database.cartaoVisitaDao()) }
}