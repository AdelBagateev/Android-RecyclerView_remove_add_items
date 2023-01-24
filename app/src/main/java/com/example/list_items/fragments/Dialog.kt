package com.example.list_items.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.example.list_items.R
import com.example.list_items.databinding.FragmentDialogAddBinding
import com.example.list_items.model.MainItem

class Dialog(val addItem :(teacher : MainItem.Teacher, pos: Int) -> Unit) : DialogFragment(){
    var binding :FragmentDialogAddBinding ?= null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = LayoutInflater.from(requireContext()).inflate(R.layout.fragment_dialog_add,   null, false)
        binding = FragmentDialogAddBinding.bind(view)
        return AlertDialog.Builder(requireContext())
            .setTitle("Добавить")
            .setView(view)
            .setPositiveButton("Дщбавить") {
                dialog, _ ->
                val name : String = binding?.teacherName?.text.toString()
                val subj : String = binding?.teacherSubject?.text.toString()
                val position : Int = binding?.teacherPosition?.text.toString().toInt()
                val teacher = MainItem.Teacher((20..100).random(), name, subj, "https://ptzgovorit.ru/sites/default/files/original_nodes/come-ottenere-il-certificato-b2-per-insegnare_c3ce2e2475844a3594c3c6bbceea7bb7.jpg")
                addItem(teacher, position - 1)
                dialog.dismiss()
            }
            .setNegativeButton("Отмена") {
                    dialog, _ -> dialog.dismiss()
            }
            .show()
    }
}