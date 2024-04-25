package com.clothing.store.fashion.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.clothing.store.fashion.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseOutlinedTextField(
    textLabel: String,
    textPlaceholder: String,
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    value: TextFieldValue = TextFieldValue(),
    onValueChange: (TextFieldValue) -> Unit = {},
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {

    Box(
        modifier = modifier
            .width(350.dp)
            .height(75.dp)
    ) {

        Text(
            text = textLabel,
            fontSize = 12.sp,
            modifier = Modifier.alpha(0.9f),
        )

        OutlinedTextField(
            value = value,
            trailingIcon = {
                Icon(painterResource(image), contentDescription = null)
            },
            placeholder = {
                Text(
                    text = textPlaceholder,
                    fontSize = 12.sp,
                    modifier = Modifier.alpha(0.8f)
                )
            },
            singleLine = true,
            modifier = Modifier
                .width(350.dp)
                .padding(0.dp, top = 20.dp),
            onValueChange = onValueChange,
            keyboardOptions = keyboardOptions,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            )
        )

        Box(
            modifier = Modifier
                .width(350.dp)
                .padding(0.dp, top = 24.dp)
                .height(45.dp)
                .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(70.dp)),
        )
    }

}

@Preview(showBackground = true)
@Composable
fun BaseOutlinedTextFieldPreview() {
    BaseOutlinedTextField(
        "Введите пароль", "********", Modifier.padding(top = 10.dp), R.drawable.eye_off_outline
    )
}