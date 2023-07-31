package com.example.demohilt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.demohilt.data.PassengerModel

class PassengerListAdapter(val onLoadMore: () -> Unit) :
    ListAdapter<PassengerModel.Data, ViewHolder>(DiffUtil) {

    private val ITEM_VIEW_TYPE_ITEM = 0
    private val ITEM_VIEW_TYPE_LOADER = 1


    inner class ViewModel(itemView: View) : ViewHolder(itemView) {
        val txtName: TextView = itemView.findViewById(R.id.txt_name)
    }

    inner class LoaderViewModel(itemView: View) : ViewHolder(itemView)

    companion object {
        val DiffUtil = object : DiffUtil.ItemCallback<PassengerModel.Data>() {
            override fun areItemsTheSame(
                oldItem: PassengerModel.Data,
                newItem: PassengerModel.Data,
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: PassengerModel.Data,
                newItem: PassengerModel.Data,
            ): Boolean {
                return oldItem == newItem
            }
        }
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is ViewModel) {
            holder.txtName.text = getItem(position).name
        } else {
            onLoadMore()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (viewType == ITEM_VIEW_TYPE_ITEM) {
            ViewModel(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.row_passanger_list, parent, false)
            )
        } else {
            LoaderViewModel(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.loading_view, parent, false)
            )

        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (currentList.size - 1 != null) ITEM_VIEW_TYPE_ITEM else ITEM_VIEW_TYPE_LOADER
    }

}