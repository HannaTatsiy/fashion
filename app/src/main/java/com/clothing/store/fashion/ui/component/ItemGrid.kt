package com.clothing.store.fashion.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.clothing.store.fashion.R
import com.clothing.store.fashion.data.DataSource
import com.clothing.store.fashion.model.Item
import java.text.NumberFormat

@Composable
fun ItemCard(
    item: Item,
    onClick: () -> Unit
) {

    var current by remember { mutableStateOf(item.isFavorite) }

    Column(
        modifier = Modifier
            .height(280.dp)
            .width(200.dp)
            .clickable { onClick() },
    ) {
        ItemIcon({
            current = !current
            item.isFavorite = !item.isFavorite
        }, current, item.imageResourceId[0])
        ItemInformation(item.title, item.price, item.rating)
    }
}

@Composable
fun ItemIcon(
    onClick: () -> Unit,
    isFavorite: Boolean,
    @DrawableRes itemIcon: Int,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Image(
            modifier = modifier
                .size(dimensionResource(R.dimen.image_size_grid))
                .clip(MaterialTheme.shapes.small),

            contentScale = ContentScale.Crop,
            painter = painterResource(itemIcon),
            contentDescription = null
        )

        Box(
            modifier = modifier
                .align(Alignment.TopEnd)
                .padding(vertical = 5.dp, horizontal = 10.dp)
        ) {
            Button(
                onClick = onClick,
                shape = CircleShape,
                modifier = modifier
                    .size(35.dp)
                    .alpha(0.4f),
                contentPadding = PaddingValues(1.dp),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.surface)
            ) {
                // Inner content including an icon and a text label
                Icon(
                    if (isFavorite) painterResource(R.drawable.heart) else painterResource(R.drawable.heart_outline),
                    tint = Color(202, 142, 162, 255),
                    contentDescription = null,
                    modifier = modifier.size(23.dp)
                )
            }
        }
    }
}

@Composable
fun ItemGrid(
    navController: NavHostController,
    list: List<Item>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
    ) {
        items(list) { item ->
            ItemCard(item) {navController.navigate("details_item/${item.id}")}
        }
    }
}

@Composable
fun ItemInformation(
    itemTitle: String,
    itemPrice: Double,
    itemRating: Double,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(4.dp)) {
        Row(Modifier.weight(3f)) {
            Text(
                text = itemTitle,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(3f)
            )

            Row(Modifier.weight(0.8f)) {
                Icon(
                    painter = painterResource(R.drawable.star),
                    contentDescription = null,
                    tint = Color(255, 195, 0),
                    modifier = modifier.size(16.dp)
                )

                Text(
                    text = NumberFormat.getInstance().format(itemRating),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }

        Text(
            text = NumberFormat.getCurrencyInstance().format(itemPrice),
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier
                .weight(2f)
                .padding(top = dimensionResource(R.dimen.padding_small))

        )
    }
}

@Preview(showBackground = true)
@Composable
fun ItemGridPreview() {
    ItemGrid( navController = rememberNavController(), DataSource.clothing)
}