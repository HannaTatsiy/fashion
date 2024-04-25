package com.clothing.store.fashion.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.clothing.store.fashion.R
import com.clothing.store.fashion.ui.component.BaseButton
import com.clothing.store.fashion.ui.component.BaseHeader
import com.clothing.store.fashion.ui.component.BaseOutlinedTextField
import com.clothing.store.fashion.ui.component.NumberOutlinedTextField

@Composable
fun CompleteProfileScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        BaseHeader(
            "Закончите заполнение",
            "Эта информация будет видна только вам",
            Modifier.padding(0.dp, dimensionResource(R.dimen.padding_small)))

        Box(modifier = Modifier.padding(0.dp, 25.dp)) {
            Image(
                painter = painterResource(R.drawable.default_logo_user_jpg),
                contentDescription = "Изображение профиля",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .border(2.dp, MaterialTheme.colorScheme.onSurfaceVariant, CircleShape),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.secondary, BlendMode.Screen)
            )

            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(horizontal = 2.dp)
            ) {
                Button(
                    onClick = {/*TODO*/ },
                    shape = CircleShape,
                    modifier = Modifier
                        .border(3.dp, MaterialTheme.colorScheme.background, CircleShape)
                        .size(35.dp),
                    contentPadding = PaddingValues(1.dp),
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary)
                ) {

                    Icon(
                        painterResource(R.drawable.pencil),
                        contentDescription = "Редактировать фото",
                        modifier = Modifier.size(20.dp)
                    )
                }

            }
        }

        Column {

            NumberOutlinedTextField(
                modifier = Modifier.padding(top = 15.dp)
            )

            Column {
                BaseOutlinedTextField(
                    textLabel = "Выберете пол",
                    textPlaceholder = "Нажмите для выбора",
                    image = R.drawable.menu_down,
                    modifier = Modifier.padding(top = 15.dp)
                )

                DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {

                }
            }

            BaseButton(
                text = "Сохранить",
                {/*TODO*/ },
                Modifier.padding(top = 25.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CompleteProfileScreenPreview() {
    CompleteProfileScreen()
}