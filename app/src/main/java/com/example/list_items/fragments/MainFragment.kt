package com.example.list_items.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.list_items.R
import com.example.list_items.adapter.SpaceItemDecorator
import com.example.list_items.adapter.HeaderAdapter
import com.example.list_items.adapter.TeacherListAdapter
import com.example.list_items.databinding.FragmentMainBinding
import com.example.list_items.features.SwipeToDelete
import com.example.list_items.model.MainItem
import com.example.list_items.model.TeacherRepository

class MainFragment : Fragment(R.layout.fragment_main) {
    private var binding : FragmentMainBinding ?= null
    private var adapter : HeaderAdapter ?= null
    private var listAdapter : TeacherListAdapter ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        binding?.fab?.setOnClickListener {
            Dialog(addItem = ::addItem).show(parentFragmentManager, "dialog")
        }
        binding?.run {
            val itemDecoration = context?.let {
                SpaceItemDecorator(
                    it,
                    16.0f
                )
            }
            SwipeToDelete(listAdapter, ::deleteItem).attachToRecyclerView(rvTeachers)

            listAdapter = TeacherListAdapter(glide = Glide.with(this@MainFragment)) { teacher ->
                deleteItem(teacher)
            }
            TeacherRepository.generateList()
            listAdapter?.submitList(TeacherRepository.itemList )
            rvTeachers.adapter = listAdapter
            rvTeachers.layoutManager = LinearLayoutManager(context)
            rvTeachers.addItemDecoration(itemDecoration!!)
        }
    }



    private fun deleteItem(teacher: MainItem.Teacher) {
        TeacherRepository.deleteItem(teacher)
        listAdapter?.submitList(TeacherRepository.itemList){binding?.rvTeachers?.scrollToPosition(0)}
    }
    private fun addItem(teacher: MainItem.Teacher, position: Int) {
        TeacherRepository.addTeacher(teacher, position)
        listAdapter?.submitList(TeacherRepository.itemList)
        binding?.rvTeachers?.scrollToPosition(position)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_main, menu)
    }

}