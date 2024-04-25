package com.clothing.store.fashion.nav

sealed class Route(
    val route: String
) {
    object Login: Route(
        route = "login"
    )

    object Register: Route(
        route = "register"
    )

    object CompleteProfile: Route(
        route = "complete_profile"
    )

    object InputEmail: Route(
        route = "input_email"
    )

    object ResetPassword: Route(
        route = "reset_password"
    )

    object VerifyCode: Route(
        route = "verify_code"
    )

    object DetailsItem: Route(
        route = "details_item/{id}"
    )
}