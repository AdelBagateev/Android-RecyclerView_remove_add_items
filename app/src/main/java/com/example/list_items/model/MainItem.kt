package com.example.list_items.model


sealed interface MainItem {
    data class Ad(val str : String) : MainItem

    data class Teacher (
        val id: Int,
        val name: String,
        val subject : String,
        val cover: String,
    ) : MainItem
}