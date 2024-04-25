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
import androidx.compose.ui.text.style.TextAlign
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
fun ResetPasswordScreen(navController: NavHostController){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column( horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Новый пароль",
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Новый пароль должен отличаться от старого",
                fontSize = 13.sp,
                modifier = Modifier
                    .padding(0.dp, dimensionResource(R.dimen.padding_small))
                    .alpha(0.5f)
            )
        }

        Column {

            BaseOutlinedTextField(
                textLabel = "Введите пароль",
                textPlaceholder = "************",
                image = R.drawable.eye_off_outline,
                modifier = Modifier.padding(top = 15.dp)
            )

            BaseOutlinedTextField(
                textLabel = "Повторите пароль",
                textPlaceholder = "************",
                image = R.drawable.eye_off_outline,
                modifier = Modifier.padding(top = 15.dp)
            )

            BaseButton(
                text = "Сменить",
                { navController.navigate(Route.Login.route) },
                Modifier.padding(top = 25.dp)
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResetPasswordScreenPreview(){
    ResetPasswordScreen(navController = rememberNavController())
}