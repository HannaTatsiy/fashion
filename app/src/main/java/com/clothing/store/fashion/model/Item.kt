package com.clothing.store.fashion.model

data class Item(
    val id: Int,
    val imageResourceId: List<Int>,
    val title: String,
    val price: Double,
    val rating: Double,
    val kind: Kind,
    var isFavorite: Boolean,
    var size: String = "S",
    var inCart: Boolean = false
)