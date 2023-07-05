package com.example.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.paging.databinding.ItemImageBinding


class PixaAdapter : Adapter<PixaAdapter.PixaViewHolder>() {
    var arrayList = arrayListOf<ImageModel>()



    class PixaViewHolder(val binding: ItemImageBinding) : ViewHolder(binding.root){

       fun onBind (model: ImageModel){
            binding.imageView.load(model.largeImageUrl)
        }

    }

    fun addImage(model : ArrayList<ImageModel>){
        arrayList.addAll(model)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PixaViewHolder {
return PixaViewHolder(ItemImageBinding.inflate
    (LayoutInflater.from(parent.context),parent,false
        )
)
    }

    override fun getItemCount(): Int {
return arrayList.size
    }

    override fun onBindViewHolder(holder: PixaViewHolder, position: Int) {
holder.onBind(arrayList[position])
    }

}