package com.example.list_items.features

import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.list_items.adapter.TeacherListAdapter
import com.example.list_items.model.MainItem
import com.example.list_items.model.TeacherRepository

class SwipeToDelete(adapter: TeacherListAdapter?, val deleteItem: (teacher : MainItem.Teacher) -> Unit ) :

    ItemTouchHelper(object : SimpleCallback(0,  LEFT or RIGHT) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }
    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        if(TeacherRepository.itemList.get(viewHolder.adapterPosition) is MainItem.Teacher)
            deleteItem(TeacherRepository.itemList[viewHolder.adapterPosition] as MainItem.Teacher)
        adapter?.submitList(TeacherRepository.itemList)

    }})