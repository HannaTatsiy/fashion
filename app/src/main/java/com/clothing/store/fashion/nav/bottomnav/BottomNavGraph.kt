package com.clothing.store.fashion.nav.bottomnav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.clothing.store.fashion.nav.Route
import com.clothing.store.fashion.ui.screen.HomeScreen
import com.clothing.store.fashion.ui.screen.CartScreen
import com.clothing.store.fashion.ui.screen.CompleteProfileScreen
import com.clothing.store.fashion.ui.screen.DetailsItemScreen
import com.clothing.store.fashion.ui.screen.FavoriteScreen
import com.clothing.store.fashion.ui.screen.InputEmailScreen
import com.clothing.store.fashion.ui.screen.LoginScreen
import com.clothing.store.fashion.ui.screen.RegisterScreen
import com.clothing.store.fashion.ui.screen.ResetPasswordScreen
import com.clothing.store.fashion.ui.screen.VerifyCodeScreen

@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route)
        {
            HomeScreen(navController)
        }
        composable(route = BottomBarScreen.Cart.route)
        {
            CartScreen(navController)
        }
        composable(route = BottomBarScreen.Favorite.route)
        {
            FavoriteScreen(navController)
        }
        composable(route = BottomBarScreen.Login.route)
        {
            LoginScreen(navController)
        }


        composable(route = Route.Register.route)
        {
            RegisterScreen(navController)
        }
        composable(route = Route.CompleteProfile.route)
        {
            CompleteProfileScreen()
        }
        composable(route = Route.InputEmail.route)
        {
            InputEmailScreen(navController)
        }
        composable(route = Route.ResetPassword.route)
        {
            ResetPasswordScreen(navController)
        }
        composable(route = Route.VerifyCode.route)
        {
            VerifyCodeScreen(navController)
        }

        composable(route = Route.DetailsItem.route, arguments =  listOf(
            navArgument("id"){
                type = NavType.IntType
                defaultValue = 1
            }
        ))
        {backStack -> val id = requireNotNull(backStack.arguments).getInt("id")
            DetailsItemScreen(id = id)
        }
    }
}