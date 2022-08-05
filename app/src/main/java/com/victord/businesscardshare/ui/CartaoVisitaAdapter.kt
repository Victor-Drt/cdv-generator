package com.victord.businesscardshare.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.victord.businesscardshare.data.CartaoVisita
import com.victord.businesscardshare.databinding.ItemCartaoVisitasBinding

class CartaoVisitaAdapter : ListAdapter<CartaoVisita, CartaoVisitaAdapter.ViewHolder>(DiffCallback()) {

    var listenerShare : (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater =  LayoutInflater.from(parent.context)
        val binding = ItemCartaoVisitasBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder (
        private val binding: ItemCartaoVisitasBinding
            ) : RecyclerView.ViewHolder(binding.root) {
                fun bind (item: CartaoVisita) {
                    binding.tvNome.text = item.nome
                    binding.tvEmail.text = item.email
                    binding.tvTelefone.text = item.telefone
                    binding.tvNomeEmpresa.text = item.empresa
                    binding.mcvCartao.setCardBackgroundColor(Color.parseColor(item.fundoPersonalizado))
                    binding.mcvCartao.setOnClickListener{
                        listenerShare(it)
                    }
                }
            }
}

class DiffCallback : DiffUtil.ItemCallback<CartaoVisita> () {
    override fun areItemsTheSame(oldItem: CartaoVisita, newItem: CartaoVisita) = oldItem == newItem

    override fun areContentsTheSame(oldItem: CartaoVisita, newItem: CartaoVisita) = oldItem.id == newItem.id

}