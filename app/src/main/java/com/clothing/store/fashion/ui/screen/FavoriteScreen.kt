package com.clothing.store.fashion.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.clothing.store.fashion.R
import com.clothing.store.fashion.data.DataSource
import com.clothing.store.fashion.ui.component.ItemGrid

@Composable
fun FavoriteScreen(navController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Row(Modifier.fillMaxWidth().padding(top = 5.dp ,bottom = 15.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Мои избранные",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
        }

        ItemGrid(
            navController,
            DataSource.clothing.filter { item -> item.isFavorite },
            modifier = Modifier.padding(
                start = dimensionResource(R.dimen.padding_medium),
                end = dimensionResource(R.dimen.padding_medium),
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FavoriteScreenPreview() {
    FavoriteScreen(navController = rememberNavController(),)
}