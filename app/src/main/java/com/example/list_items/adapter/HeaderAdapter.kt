package com.example.list_items.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.list_items.R
import com.example.list_items.model.MainItem

class HeaderAdapter (
    private val list: List<MainItem>,
    private val glide: RequestManager,
    private val action: (MainItem.Teacher) -> Unit,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder = when(viewType) {
        R.layout.item_teacher -> TeacherItem.create(parent, glide, action)
        R.layout.ad_casino -> AdItem.create(parent)
        else -> {throw IllegalStateException("stop pls")}
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        when(holder) {
            is TeacherItem -> holder.OnBind(list[position] as MainItem.Teacher)
//            is AdItem -> tutututu
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(list[position]) {
            is MainItem.Ad -> R.layout.ad_casino
            is MainItem.Teacher -> R.layout.item_teacher
        }
    }

    override fun getItemCount(): Int = list.size



}