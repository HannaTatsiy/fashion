package com.clothing.store.fashion.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.clothing.store.fashion.data.DataSource
import com.clothing.store.fashion.model.Item
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImageItem(item: Item) {

    val state = rememberPagerState()

    Column {
        SliderView(state, item)
        Spacer(modifier = Modifier.padding(8.dp))
        DotsIndicator(
            totalDots = item.imageResourceId.size,
            selectedIndex = state.currentPage
        )
    }

    // анимация
    LaunchedEffect(key1 = state.currentPage) {
        delay(5000)
        var newPosition = state.currentPage + 1
        if (newPosition > item.imageResourceId.size - 1) newPosition = 0
        state.animateScrollToPage(newPosition)
    }
}

@Composable
@Preview(showBackground = true)
fun ImageItemPreview() {
    ImageItem(DataSource.getItemById(1))
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SliderView(state: PagerState, item: Item) {

    val image = remember { mutableIntStateOf(0) }

    HorizontalPager(
        state = state,
        count = item.imageResourceId.size,
        modifier = Modifier
            .fillMaxWidth()
            .size(370.dp)
    ) { page ->
        image.intValue = item.imageResourceId[page]

        val painter = rememberImagePainter(data = image.intValue, builder = {
            //scale(Scale.FILL)
        })

        Image(
            painter = painter,
            contentDescription = "Фото товара",
            contentScale = ContentScale.Crop
        )

    }
}

@Composable
fun DotsIndicator(
    totalDots: Int,
    selectedIndex: Int
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.Center
    ) {
        items(totalDots) { index ->
            if (index == selectedIndex) {
                Dots(MaterialTheme.colorScheme.tertiary)
            } else {
                Dots(MaterialTheme.colorScheme.tertiaryContainer)
            }

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}

@Composable
fun Dots(color: Color) {
    Box(
        modifier = Modifier.padding(2.dp, 0.dp)
            .size(8.dp)
            .clip(CircleShape)
            .background(color = color)
    )
}

@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
fun SliderPreview() {

    val item = DataSource.getItemById(1)

    Column {
        SliderView(state = rememberPagerState(), item)
        DotsIndicator(
            totalDots = item.imageResourceId.size,
            selectedIndex = 1
        )
    }

}