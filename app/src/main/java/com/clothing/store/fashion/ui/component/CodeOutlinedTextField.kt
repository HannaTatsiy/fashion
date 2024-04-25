package com.clothing.store.fashion.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
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
fun CodeOutlinedTextField(
    modifier: Modifier = Modifier,
    value: TextFieldValue = TextFieldValue(),
    onValueChange: (TextFieldValue) -> Unit = {},
) {

    Box(
        modifier = modifier
            .width(60.dp)
            .height(50.dp)
    ) {

        OutlinedTextField(
            value = value,
            placeholder = {
                Text(
                    text = "-",
                    fontSize = 15.sp,
                    modifier = Modifier.alpha(0.8f),
                )
            },
            singleLine = true,
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
        )

        Box(
            modifier = Modifier
                .width(60.dp)
                .height(50.dp)
                .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(70.dp)),
        )
    }

}

@Preview(showBackground = true)
@Composable
fun CodeOutlinedTextFieldPreview() {
    CodeOutlinedTextField(
        Modifier.padding(top = 10.dp)
    )
}