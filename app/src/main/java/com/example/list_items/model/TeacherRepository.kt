package com.example.list_items.model

import java.text.FieldPosition

object TeacherRepository {
    val teachers = arrayListOf(

        MainItem.Teacher(
            1,
            "Пифагор",
            "Математика",
            "https://new-science.ru/wp-content/uploads/2020/03/515-1.jpg"
        ),
        MainItem.Teacher(
            2,
            "Макс Планк",
            "Квантовая механика",
            "https://new-science.ru/wp-content/webp-express/webp-images/doc-root/wp-content/uploads/2019/10/45272-18.jpg.webp"
        ),
        MainItem.Teacher(
            3,
            "Галилео Галилей",
            "Астрономия",
            "https://new-science.ru/wp-content/webp-express/webp-images/doc-root/wp-content/uploads/2019/10/45272-19.jpg.webp"
        ),
        MainItem.Teacher(
            4,
            "Исаак Ньютон",
            "Классическая механкиа",
            "https://new-science.ru/wp-content/webp-express/webp-images/doc-root/wp-content/uploads/2019/10/45272-20.jpg.webp"
        ), MainItem.Teacher(
            5,
            "Мария Кюри",
            "Химия",
            "https://new-science.ru/wp-content/webp-express/webp-images/doc-root/wp-content/uploads/2019/10/45272-21-768x618.jpg.webp"
        ),
        MainItem.Teacher(
            7,
            "Альберт Эйнштейн",
            "Физика",
            "https://new-science.ru/wp-content/webp-express/webp-images/doc-root/wp-content/uploads/2019/10/45272-22.jpg.webp"
        ),
        MainItem.Teacher(
            8,
            "Миша Абрамский",
            "Програмирование",
            "https://sun9-72.userapi.com/impf/c850524/v850524279/1c0557/ir61CNdEqTg.jpg?size=1124x750&quality=96&sign=9b4cd3908d9f541a1952250457a744a8&c_uniq_tag=ER_zWKTP0hwhhnojNZ9psWxWQia2nUg4ezn9jDBgX20&type=album"
        ),
        MainItem.Teacher(
            9,
            "Никола Тесла",
            "Электротехника",
            "https://new-science.ru/wp-content/webp-express/webp-images/doc-root/wp-content/uploads/2019/10/45272-26.jpg.webp"
        ),
        MainItem.Teacher(
            10,
            "Барбара МакКлинток",
            "Генитика",
            "https://new-science.ru/wp-content/webp-express/webp-images/doc-root/wp-content/uploads/2019/10/45272-27.jpg.webp"
        ), MainItem.Teacher(
            11,
            "Эдвин Хаббл",
            "Астрономия",
            "https://new-science.ru/wp-content/webp-express/webp-images/doc-root/wp-content/uploads/2019/10/45272-32.jpg.webp"
        )
    )

    var itemList: List<MainItem> = listOf()

    fun generateList() {
        val list = mutableListOf<MainItem>()
        for (i in 0 until 12) {
            if (i % 6 == 0) {
                val item = MainItem.Ad(((1..3).random()).toString())
                val newItem = item.copy()
                list.add(newItem)
            } else {
                val item =
                    teachers.first { it.id == i }
                val newItem = item.copy()
                list.add(newItem)
            }
        }
        itemList = list
    }

    fun deleteItem(teacher: MainItem.Teacher) {

        val list = listOf<MainItem>().toMutableList()
        val position = itemList.indexOf(teacher)
        if (position <= itemList.size)
            list.addAll(itemList.subList(0, position))
        if (position < itemList.size )
            list.addAll(itemList.subList(position + 1, itemList.size))
        itemList = list.toList()
    }


    fun addTeacher(teacher: MainItem.Teacher, position: Int) {
        val list = listOf<MainItem>().toMutableList()
        if(position > itemList.size) {
            list.addAll(itemList)
            list.add(teacher)
        } else {
            list.addAll(itemList.subList(0, position))
            list.add(teacher)
            list.addAll(itemList.subList(position, itemList.size))
        }
        itemList = list.toList()
    }
}