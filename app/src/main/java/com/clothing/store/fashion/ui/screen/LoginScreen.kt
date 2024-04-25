package com.clothing.store.fashion.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextDecoration
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
fun LoginScreen(navController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column {
            Text(text = "Вход в акккаунт", fontSize = 24.sp)
            Text(
                text = "Здравствуйте, с возвращением!",
                fontSize = 13.sp,
                modifier = Modifier
                    .padding(0.dp, dimensionResource(R.dimen.padding_medium))
                    .alpha(0.5f)
            )
        }

        Column {
            BaseOutlinedTextField(
                textLabel = "Введите Email",
                textPlaceholder = "example@gmail.com",
                image = R.drawable.email_outline
            )

            BaseOutlinedTextField(
                textLabel = "Введите пароль",
                textPlaceholder = "************",
                image = R.drawable.eye_off_outline,
                modifier = Modifier.padding(top = 15.dp)
            )

            Row(modifier = Modifier.width(350.dp).padding(end = 5.dp ,top = 5.dp),
                horizontalArrangement = Arrangement.End,
            ) {

                Text(
                    text = "Забыли пароль?",
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.clickable { navController.navigate(Route.InputEmail.route) }
                )
            }

            BaseButton(
                text = "Войти",
                {/*TODO*/ },
                Modifier.padding(top = 30.dp)
            )

            Row(modifier = Modifier.width(350.dp).padding(top = 15.dp).alpha(0.8f),
                horizontalArrangement = Arrangement.Center,
            ) {

                Text(
                    text = "Еще нет аккаунта? ",
                )

                Text(
                    text = "Зарегистрироваться",
                    textDecoration = TextDecoration.Underline,
                    color = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.clickable { navController.navigate(Route.Register.route) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AccountScreenPreview() {
    LoginScreen(navController = rememberNavController())
}

