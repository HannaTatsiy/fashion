package com.clothing.store.fashion.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.clothing.store.fashion.R
import com.clothing.store.fashion.data.DataSource
import com.clothing.store.fashion.ui.component.ItemGrid
import com.clothing.store.fashion.ui.theme.FashionTheme

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        AppBar()
        //Promotions()
        ItemGrid(
            navController,
            DataSource.clothing,
            modifier = Modifier.padding(
                start = dimensionResource(R.dimen.padding_medium),
                end = dimensionResource(R.dimen.padding_medium),
            )
        )
    }
}

@Composable
fun AppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_medium), dimensionResource(R.dimen.padding_small))
            .height(45.dp),

        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        OutlinedTextField(
            value = "",
            placeholder = {
                Text(
                    text = "Введите название товара",
                    fontSize = 11.sp
                )
            },
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "Поиск"
                )
            },
            shape = MaterialTheme.shapes.medium,
            modifier = modifier
                .weight(1f)
                .alpha(0.8f),
            onValueChange = { /*TODO*/ })

        Spacer(modifier = modifier.width(dimensionResource(R.dimen.padding_small)))

        Box(modifier = modifier.padding(horizontal = 10.dp)) {
            Button(
                onClick = {/*TODO*/ },
                shape = CircleShape,
                modifier = modifier.size(40.dp),
                contentPadding = PaddingValues(1.dp)
            ) {

                Icon(
                    painterResource(R.drawable.order_bool_ascending_variant),
                    contentDescription = "Фильтр",
                    modifier = modifier.size(20.dp)
                )
            }

        }
    }
}

@Composable
fun Promotions() {
    //  LazyRow(content = ){

    //  }
}

@Composable
fun PromotionItem() {

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    FashionTheme {
        HomeScreen(navController = rememberNavController())
    }
}