package com.clothing.store.fashion.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavHostController){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column {
            Text(text = "Создать акккаунт", fontSize = 24.sp)
            Text(
                text = "Пожалуйста, заполните поля ниже!",
                fontSize = 13.sp,
                modifier = Modifier
                    .padding(0.dp, dimensionResource(R.dimen.padding_medium))
                    .alpha(0.5f)
            )
        }

        Column {

            BaseOutlinedTextField(
                textLabel = "Введите имя",
                textPlaceholder = "Людмила Петровна",
                image = R.drawable.card_account_details_outline,
                modifier = Modifier.padding(top = 15.dp)
            )

            BaseOutlinedTextField(
                textLabel = "Введите Email",
                textPlaceholder = "example@gmail.com",
                modifier = Modifier.padding(top = 15.dp),
                image = R.drawable.email_outline
            )

            BaseOutlinedTextField(
                textLabel = "Введите пароль",
                textPlaceholder = "************",
                image = R.drawable.eye_off_outline,
                modifier = Modifier.padding(top = 15.dp)
            )

            Row(modifier = Modifier
                .width(350.dp)
                .padding(top = 10.dp),
               verticalAlignment = Alignment.CenterVertically
            ) {

                CompositionLocalProvider(
                    LocalMinimumInteractiveComponentEnforcement provides false) {
                    Checkbox(
                        checked = true,
                        onCheckedChange = {/*TODO*/},
                        colors = CheckboxDefaults.colors(MaterialTheme.colorScheme.secondary),
                        modifier = Modifier.padding(5.dp, 0.dp),
                    )
                }

                Text(
                    text = "Я согласен с ",
                )

                Text(
                    text = "политикой конфиденциальности",
                    color = MaterialTheme.colorScheme.tertiary,
                    textDecoration = TextDecoration.Underline,
                )
            }

            BaseButton(
                text = "Войти",
                {navController.navigate(Route.CompleteProfile.route) },
                Modifier.padding(top = 30.dp)
            )

            Row(modifier = Modifier
                .width(350.dp)
                .padding(top = 15.dp)
                .alpha(0.8f),
                horizontalArrangement = Arrangement.Center,
            ) {

                Text(
                    text = "Уже есть аккаунт? ",
                )

                Text(
                    text = "Войти",
                    textDecoration = TextDecoration.Underline,
                    color = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.clickable { navController.navigate(Route.Login.route) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview(){
    RegisterScreen(navController = rememberNavController())
}