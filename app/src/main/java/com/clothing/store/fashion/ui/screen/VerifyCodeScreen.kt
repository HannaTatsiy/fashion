package com.clothing.store.fashion.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.clothing.store.fashion.nav.Route
import com.clothing.store.fashion.ui.component.BaseButton
import com.clothing.store.fashion.ui.component.CodeOutlinedTextField

@Composable
fun VerifyCodeScreen(navController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Код подтверждения", fontSize = 24.sp)
            Text(
                text = "На почту был отправлен код подтверждения",
                fontSize = 13.sp,
                modifier = Modifier.alpha(0.5f)
            )

            Text(
                text = "example@gmail.com",
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CodeOutlinedTextField()
            CodeOutlinedTextField()
            CodeOutlinedTextField()
            CodeOutlinedTextField()
        }

        Text(
            text = "Не пришел код?",
            modifier = Modifier
                .padding(0.dp, 5.dp)
                .alpha(0.5f)
        )
        Text(
            text = "Отправить снова",
            textDecoration = TextDecoration.Underline,
            color = MaterialTheme.colorScheme.tertiary,
        )

        BaseButton(
            text = "Подтвердить",
            {navController.navigate(Route.ResetPassword.route) },
            Modifier.padding(top = 30.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun VerifyCodeScreenPreview() {
    VerifyCodeScreen(navController = rememberNavController())
}