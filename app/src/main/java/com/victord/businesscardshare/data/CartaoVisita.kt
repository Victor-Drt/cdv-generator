package com.victord.businesscardshare.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CartaoVisita (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome : String,
    val email : String,
    val telefone : String,
    val empresa : String,
    val fundoPersonalizado : String,
)