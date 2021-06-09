package com.manapps.mandroid.recyclerviewinkotlin

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.manapps.mandroid.recyclerviewinkotlin.databinding.ItemLayoutBinding

class RecyclerViewItemAdapter(
        val context: Context,
        val dataModelList: MutableList<DataModel>,
        val itemClickListenerInterface: RecyclerViewItemClickListenerInterface) :
        RecyclerView.Adapter<RecyclerViewItemAdapter.ItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder = ItemViewHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun getItemCount(): Int = dataModelList.size
    class ItemViewHolder(var holderBinding: ItemLayoutBinding) : RecyclerView.ViewHolder(holderBinding.root) {
        fun bind(dataModel: DataModel) {
            holderBinding.itemLabel.text = dataModel.title

        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataModelList[position])

        holder.itemView.setOnClickListener {
            onItemClick(position)
        }
    }

    private fun onItemClick(position: Int) {
        itemClickListenerInterface.recyclerViewItemClickListener(position)

    }


}