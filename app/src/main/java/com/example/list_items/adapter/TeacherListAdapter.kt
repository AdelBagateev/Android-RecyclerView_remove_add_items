package com.example.list_items.adapter

import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.list_items.R
import com.example.list_items.model.MainItem

class TeacherListAdapter(
    private val glide: RequestManager,
    private val action: (MainItem.Teacher) -> Unit,
): ListAdapter<MainItem, RecyclerView.ViewHolder>(
    object : DiffUtil.ItemCallback<MainItem>() {
    override fun areItemsTheSame(
        oldItem: MainItem,
        newItem: MainItem
    ): Boolean {
        if (oldItem is MainItem.Teacher && newItem is MainItem.Teacher)
            return oldItem.id == newItem.id
        if (oldItem is MainItem.Ad && newItem is MainItem.Ad) {
            return oldItem.str == newItem.str
        }
        return false

    }

    override fun areContentsTheSame(
        oldItem: MainItem,
        newItem: MainItem
    ): Boolean {
        if (oldItem is MainItem.Teacher && newItem is MainItem.Teacher)
            return oldItem == newItem
        if (oldItem is MainItem.Ad && newItem is MainItem.Ad)
            return oldItem == newItem
        return false
    }

//    override fun getChangePayload(
//        oldItem: MainItem.Teacher,
//        newItem: MainItem.Teacher
//    ): Any? {
//        val bundle : Bundle = Bundle()
//        if (oldItem is MainItem.Teacher && newItem is MainItem.Teacher) {
//            if (newItem.name != oldItem.name) bundle.putString("", newItem.name)
//            if (newItem.cover != oldItem.cover) bundle.putString("", newItem.cover)
//            if (newItem.subject != oldItem.subject) bundle.putString("", newItem.subject)
//        }
//        if(bundle.isEmpty) {
//            return super.getChangePayload(oldItem, newItem)
//        } else
//            return bundle
//    }
}

) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return when(viewType) {
            R.layout.item_teacher -> TeacherItem.create(parent, glide, action)
            R.layout.ad_casino -> AdItem.create(parent)
            else ->  throw IllegalStateException("heeeeeeeeelp")
        }
    }


    override fun getItemViewType(position: Int): Int {
        return when(getItem(position)) {
            is MainItem.Ad -> R.layout.ad_casino
            is MainItem.Teacher -> R.layout.item_teacher
        }
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        if(holder is TeacherItem) {
            holder.OnBind(getItem(position) as MainItem.Teacher)
        }

//        holder.OnBind(getItem(position))
    }

}