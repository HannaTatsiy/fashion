package com.clothing.store.fashion.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NumberOutlinedTextField(
    modifier: Modifier = Modifier,
    value: TextFieldValue = TextFieldValue(),
    onValueChange: (TextFieldValue) -> Unit = {}
) {

    Box(
        modifier = modifier
            .width(350.dp)
            .height(75.dp)
    ) {

        Text(
            text = "Введите номер телефона",
            fontSize = 12.sp,
            modifier = Modifier.alpha(0.9f),
        )

        OutlinedTextField(
            value = value,
            leadingIcon = {
                    Text(
                        text = "+7",
                        fontSize = 13.sp,
                        modifier = Modifier
                            .alpha(0.9f)
                            .padding(bottom = 4.dp)
                    )
            },
            trailingIcon = {
                Icon(Icons.Filled.Phone, contentDescription = null)
            },
            placeholder = {
                Text(
                    text = "(000)000-00-00",
                    fontSize = 12.sp,
                    modifier = Modifier
                        .alpha(0.8f)
                        .padding(bottom = 4.dp)
                )
            },
            singleLine = true,
            modifier = Modifier
                .width(350.dp)
                .padding(0.dp, top = 20.dp),
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
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
fun NumberOutlinedTextFieldPreview() {
    NumberOutlinedTextField(
        Modifier.padding(top = 10.dp)
    )
}

