package com.clothing.store.fashion.data

import com.clothing.store.fashion.R
import com.clothing.store.fashion.model.Item
import com.clothing.store.fashion.model.Kind


object DataSource {

    fun getItemById(id: Int): Item {
        return clothing.first { item -> item.id == id }
    }

    val clothing = listOf(
        Item(
            1,
            listOf(
                R.drawable.item06_1,
                R.drawable.item06_2,
                R.drawable.item06_3,
                R.drawable.item06_4
            ),
            "Стеганая куртка с капюшоном",
            12000.0,
            4.7,
            Kind.MALE,
            false,
            "M",
            true
        ),

        Item(
            2,
            listOf(
                R.drawable.item05_1,
                R.drawable.item05_2,
                R.drawable.item05_3,
                R.drawable.item05_4
            ),
            "Стеганая куртка с капюшоном",
            16000.0,
            4.1,
            Kind.MALE,
            false,
            "L",
            true
        ),

        Item(
            3,
            listOf(
                R.drawable.item04_1,
                R.drawable.item04_2,
                R.drawable.item04_3,
                R.drawable.item04_4
            ),
            "Укороченная куртка из искусственной кожи в байкерском стиле",
            16000.0,
            4.1,
            Kind.MALE,
            false,
            "S",
            true
        ),

        Item(
            4,
            listOf(
                R.drawable.item03_1,
                R.drawable.item03_2,
                R.drawable.item03_3,
                R.drawable.item03_4
            ),
            "Куртка-бомбер с вощеной отделкой и контрастным воротником",
            16000.0,
            4.1,
            Kind.MALE,
            false
        ),

        Item(
            5,
            listOf(
                R.drawable.item02_1,
                R.drawable.item02_2,
                R.drawable.item02_3,
                R.drawable.item02_4
            ),
            "Нейлоновый бомбер оверсайз",
            16000.0,
            4.1,
            Kind.MALE,
            false
        ),

        Item(
            6,
            listOf(
                R.drawable.item01_1,
                R.drawable.item01_2,
                R.drawable.item01_3,
                R.drawable.item01_4
            ),
            "Укороченная куртка из искусственной кожи в байкерском стиле",
            16000.0,
            4.1,
            Kind.MALE,
            true
        ),
    )
}