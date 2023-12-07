package com.carlostorres.dogedex.doglist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.carlostorres.dogedex.data.models.DogListResponse
import com.carlostorres.dogedex.databinding.DogListItemBinding

class DogAdapter : ListAdapter<DogListResponse, DogAdapter.DogViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<DogListResponse>(){
        override fun areItemsTheSame(oldItem: DogListResponse, newItem: DogListResponse): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: DogListResponse, newItem: DogListResponse): Boolean {
            return oldItem.id == newItem.id
        }

    }

    private var onItemClickListener: ((DogListResponse) -> Unit)? = null
    fun setOnItemClickListener(onItemClickListener : (DogListResponse) -> Unit){
        this.onItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {

        val binding = DogListItemBinding.inflate(LayoutInflater.from(parent.context))
        return DogViewHolder(binding)

    }

    override fun onBindViewHolder(dogViewHolder: DogViewHolder, position: Int) {
        val dog = getItem(position)
        dogViewHolder.bind(dog)
    }

    inner class DogViewHolder(val binding: DogListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind (dog : DogListResponse){
            binding.tvDogName.text = dog.name_en
            binding.tvDogName.setOnClickListener {
                onItemClickListener?.invoke(dog)
            }
        }

    }

}