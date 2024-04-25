package com.clothing.store.fashion.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.clothing.store.fashion.R
import com.clothing.store.fashion.nav.Route
import com.clothing.store.fashion.ui.component.BaseButton
import com.clothing.store.fashion.ui.component.BaseOutlinedTextField

@Composable
fun InputEmailScreen(navController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Сброс пароля", fontSize = 24.sp)
            Text(
                text = "Введите адрес почты для сброса пароля",
                fontSize = 13.sp,
                modifier = Modifier
                    .padding(0.dp, dimensionResource(R.dimen.padding_small))
                    .alpha(0.5f)
            )
        }

        Column(modifier = Modifier.padding(top= 32.dp)) {
            BaseOutlinedTextField(
                textLabel = "Введите Email",
                textPlaceholder = "example@gmail.com",
                image = R.drawable.email_outline,
            )

            BaseButton(
                text = "Войти",
                {navController.navigate(Route.VerifyCode.route) },
                Modifier.padding(top = 30.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun InputEmailScreenPreview() {
    InputEmailScreen(navController = rememberNavController())
}

