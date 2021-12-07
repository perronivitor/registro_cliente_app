package com.perroni.registroclienteapp.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.perroni.registroclienteapp.databinding.CardItemClientBinding
import com.perroni.registroclienteapp.domain.UserEntity


class HomeAdapter(private var dataSet: List<UserEntity>? = null,
                           private val onItemClick: (user : UserEntity) -> Unit)
    : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private lateinit var binding : CardItemClientBinding

    class ViewHolder(binding: CardItemClientBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvName = binding.tvName
        val tvCPF = binding.tvCPF
        val tvMatricula = binding.tvMatricula
        val tvEmail = binding.tvEmail
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = CardItemClientBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        dataSet?.get(position)?.let { user ->
            holder.tvCPF.text = user.cpf
            holder.tvMatricula.text = user.matricula
            holder.tvName.text = user.name
            holder.tvEmail.text = user.email

            holder.itemView.setOnClickListener {
                onItemClick(user)
            }
        }
    }

    override fun getItemCount() = dataSet?.size ?: 0

    fun setData(data: List<UserEntity>) {
        dataSet = data
        notifyDataSetChanged()
    }
}