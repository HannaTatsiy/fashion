package com.clothing.store.fashion.nav.bottomnav

import com.clothing.store.fashion.R

sealed class BottomBarScreen (
    val route: String,
    val title: String,
    val icon: Int,
    val iconFocused: Int
) {

    //for home
    object Home: BottomBarScreen(
        route = "home",
        title = "Главная",
        icon = R.drawable.home_circle_outline,
        iconFocused = R.drawable.home_circle
    )

    //for cart
    object Cart: BottomBarScreen(
        route = "cart",
        title = "Корзина",
        icon = R.drawable.cart_outline,
        iconFocused = R.drawable.cart
    )

    object Favorite: BottomBarScreen(
        route = "favorite",
        title = "Избранное",
        icon = R.drawable.heart_outline,
        iconFocused = R.drawable.heart
    )

    object Login: BottomBarScreen(
        route = "login",
        title = "Логин",
        icon = R.drawable.account_circle_outline,
        iconFocused = R.drawable.account_circle
    )
}