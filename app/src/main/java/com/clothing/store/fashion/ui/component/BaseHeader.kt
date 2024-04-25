package com.clothing.store.fashion.ui.component

import androidx.compose.foundation.layout.Column
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
import com.clothing.store.fashion.R

@Composable
fun BaseHeader(
    title:String,
    subTitle: String,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Закончите заполнение", fontSize = 24.sp)
        Text(
            text = "Эта информация будет видна только вам",
            fontSize = 13.sp,
            modifier = modifier
              //  .padding(0.dp, dimensionResource(R.dimen.padding_small))
                .alpha(0.5f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BaseHeaderPreview(){
    BaseHeader("Закончите заполнение", "Эта информация будет видна только вам")
}
