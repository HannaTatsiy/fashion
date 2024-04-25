package com.clothing.store.fashion.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.clothing.store.fashion.R
import com.clothing.store.fashion.data.DataSource
import com.clothing.store.fashion.model.Item
import com.clothing.store.fashion.ui.component.ImageItem
import com.clothing.store.fashion.ui.theme.md_theme_dark_outline
import java.text.NumberFormat

@Composable
fun DetailsItemScreen(id: Int) {

    val item: Item = DataSource.getItemById(id)

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        ImageItem(item)
        ItemInfoSection(item)

        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier
                .padding(20.dp, 15.dp)
                .alpha(0.3f)
        )

        Text(
            text = "Выберите размер",
            fontSize = 17.sp,
            modifier = Modifier.padding(20.dp, 0.dp)
        )

        SelectSizeSection(listOf("S", "M", "L", "XL", "XXL", "XXXL"))

        /*
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .shadow(6.dp, RoundedCornerShape(10.dp))
        ) {
            Row(modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize(),

                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column(verticalArrangement = Arrangement.Center) {
                    Text(text = "Стоимость")
                    Text(text = NumberFormat.getCurrencyInstance().format(item.price))
                }

                Button(onClick = { /*TODO*/ }) {

                }
            }
        } */

    }
}

@Preview(showBackground = true)
@Composable
fun DetailsItemScreenPreview() {
    DetailsItemScreen(1)
}

@Composable
fun ItemInfoSection(item: Item) {
    Column(
        modifier = Modifier.padding(start = 20.dp, top = 25.dp, end = 20.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Details Screen",
                fontSize = 16.sp,
                modifier = Modifier.alpha(0.5f)
            )

            Row {
                Icon(
                    painter = painterResource(R.drawable.star),
                    contentDescription = null,
                    tint = Color(255, 195, 0),
                    modifier = Modifier.size(19.dp)
                )

                Text(
                    text = NumberFormat.getInstance().format(item.rating),
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.alpha(0.5f)
                )
            }
        }

        Text(
            text = item.title,
            fontSize = 18.sp,
            modifier = Modifier.padding(0.dp, 10.dp)
        )

        Text(
            text = "Описание товара",
            fontSize = 17.sp,
            modifier = Modifier.padding(0.dp, 10.dp)
        )

        Text(
            text = "Куртка-бомбер на основе льна с круглым воротником и длинными рукавами. Застёгивается на молнию спереди. Карманы с обшивкой",
            fontSize = 15.sp,
            modifier = Modifier.alpha(0.5f)
        )
    }
}

@Composable
fun SelectSizeSection(sizes: List<String>) {

    var selectedIndex by remember { mutableIntStateOf(0) }

    LazyRow {
        items(sizes.size) {
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 20.dp, top = 10.dp, bottom = 10.dp)
                    .clickable { selectedIndex = it }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedIndex == it) MaterialTheme.colorScheme.secondary
                        else MaterialTheme.colorScheme.onSecondary
                    )
                    .border(1.dp, md_theme_dark_outline, RoundedCornerShape(10.dp))
                    .padding(14.dp, 10.dp)) {

                Text(
                    text = sizes[it],
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = if (selectedIndex == it) MaterialTheme.colorScheme.surface
                    else MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SelectSizeSectionPreview() {
    SelectSizeSection(listOf("S", "M", "L", "XL", "XXL", "XXXL"))
}