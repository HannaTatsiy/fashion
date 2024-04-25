package com.clothing.store.fashion.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Remove
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissState
import androidx.compose.material3.DismissValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.clothing.store.fashion.R
import com.clothing.store.fashion.data.DataSource
import com.clothing.store.fashion.model.Item
import com.clothing.store.fashion.model.Kind
import kotlinx.coroutines.delay
import java.text.NumberFormat

private const val CONTAINER_BACKGROUND_ALPHA_INITIAL = 0.6f

@Composable
fun CartScreen(navController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, bottom = 15.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Моя корзина",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
        }

        CartLazyColumn(DataSource.clothing.filter { item ->  item.inCart},  {item -> navController.navigate("details_item/${item.id}")})
    }

}

@Composable
private fun CartLazyColumn(
    list: List<Item>,
    onClick: (Item) -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
        ){
           items(items = list, key = {it.id}){ item ->
                SwipeToDeleteContainer(item = item, onDelete = {item.inCart = false} ) {
                item -> CardItem(item = item, { onClick(item) },modifier = modifier)
            }
           }
        }
    }

}

@Composable
private fun CardItem(
    item: Item,
    onClick: () -> Unit,
    modifier: Modifier = Modifier) {

    var valueCounter by remember { mutableIntStateOf(1) }

    Row(
        modifier.fillMaxWidth().clickable { onClick() },
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {

            Image(
                modifier = modifier
                    .size(120.dp)
                    .padding(10.dp)
                    .clip(MaterialTheme.shapes.small),

                contentScale = ContentScale.Crop,
                painter = painterResource(item.imageResourceId[0]),
                contentDescription = null
            )

            Column(
                modifier.width(150.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = item.title, style = MaterialTheme.typography.bodyMedium)
                Text(
                    text = "Размер: ${item.size}",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .padding(0.dp, 6.dp)
                        .alpha(0.5f)
                )
                Text(
                    text = NumberFormat.getCurrencyInstance().format(item.price),
                    fontWeight = FontWeight.Medium,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        CounterButton(
            value = valueCounter.toString(),
            onValueIncreaseClick = {
                valueCounter = minOf(valueCounter + 1, 10)
            },
            onValueDecreaseClick = {
                valueCounter = maxOf(valueCounter - 1, 1)
            },
            onValueClearClick = {
                valueCounter = 0
            },
            modifier = modifier.padding(25.dp))
    }
}

@Composable
private fun CounterButton(
    value: String,
    onValueDecreaseClick: () -> Unit,
    onValueIncreaseClick: () -> Unit,
    onValueClearClick: () -> Unit,
    modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .width(75.dp)
            .height(30.dp)
    )
    {
        ButtonContainer(
            onValueDecreaseClick = onValueDecreaseClick,
            onValueIncreaseClick = onValueIncreaseClick,
            onValueClearClick = onValueClearClick
        )

        DraggableThumbButton(
            value = value,
            onClick = onValueIncreaseClick,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}


@Composable
@Preview(showBackground = true)
fun CardItemPreview() {

    val item = Item(
        1,
        listOf(
            R.drawable.item06_1,
            R.drawable.item06_2,
            R.drawable.item06_3,
            R.drawable.item06_4
        ),
        "Стеганая куртка с капюшоном",
        12000.0,
        4.7,
        Kind.MALE,
        false
    );

    val navController = rememberNavController()

    CardItem(item, {navController.navigate("details_item/${item.id}")})
}

@Composable
@Preview(showBackground = true)
fun CartScreenPreview() {

    val navController = rememberNavController()
    CartScreen(navController)
}

@Composable
private fun ButtonContainer(
    onValueDecreaseClick: () -> Unit,
    onValueIncreaseClick: () -> Unit,
    onValueClearClick: () -> Unit,
    modifier: Modifier = Modifier,
    clearButtonVisible: Boolean = false,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(24.dp))
            .background(
                MaterialTheme.colorScheme.tertiaryContainer.copy(
                    CONTAINER_BACKGROUND_ALPHA_INITIAL
                )
            )
            .padding(horizontal = 3.dp)
    ) {

        // кнопка уменьшения
        IconControlButton(
            icon = Icons.Outlined.Remove,
            contentDescription = "Decrease count",
            onClick = onValueDecreaseClick,
            tintColor = MaterialTheme.colorScheme.onTertiaryContainer
        )

        // кнопка сброса
        if (clearButtonVisible) {
            IconControlButton(
                icon = Icons.Outlined.Clear,
                contentDescription = "Clear count",
                onClick = onValueClearClick,
                tintColor = MaterialTheme.colorScheme.onTertiaryContainer
            )
        }

        // кнопка увеличения
        IconControlButton(
            icon = Icons.Outlined.Add,
            contentDescription = "Increase count",
            onClick = onValueIncreaseClick,
            tintColor = MaterialTheme.colorScheme.onTertiaryContainer
        )
    }
}

@Composable
private fun IconControlButton(
    icon: ImageVector,
    contentDescription: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    tintColor: Color
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .size(18.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = tintColor,
            modifier = Modifier.size(12.dp)
        )
    }
}

@Composable
private fun DraggableThumbButton(
    value: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .shadow(3.dp, shape = CircleShape)
            .size(24.dp)
            .clip(CircleShape)
            .clickable { onClick() }
            .background(MaterialTheme.colorScheme.tertiary)
    ) {
        Text(
            text = value,
            fontSize = 13.sp,
            color = MaterialTheme.colorScheme.onTertiary,
            textAlign = TextAlign.Center,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun <T> SwipeToDeleteContainer(
    item: T,
    onDelete: (T) -> Unit,
    animationDuration: Int = 500,
    content: @Composable (T) -> Unit
){
    var isRemoved by remember {
        mutableStateOf(false)
    }

    val state =  rememberDismissState(
        confirmValueChange = {value ->
            if(value == DismissValue.DismissedToStart)
            {
                isRemoved = true
                true
            } else {false}
        }
    )

    LaunchedEffect(key1 = isRemoved){
        if(isRemoved){
            delay(animationDuration.toLong())
            onDelete(item)
        }
    }

    AnimatedVisibility(
        visible = !isRemoved,
        exit = shrinkVertically(
            animationSpec = tween(durationMillis = animationDuration),
            shrinkTowards = Alignment.Top
        ) + fadeOut()
    ) {
        SwipeToDismiss(
            state = state,
            background = { DeleteBackground(swipeDismissState = state) },
            dismissContent = {content(item)},
            directions = setOf(DismissDirection.EndToStart)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DeleteBackground(
    swipeDismissState: DismissState
){

    var color = MaterialTheme.colorScheme.errorContainer
    var tint = MaterialTheme.colorScheme.error

    if (swipeDismissState.dismissDirection != DismissDirection.EndToStart){
        color = Color.Transparent
        tint = Color.Transparent
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color)
        .padding(16.dp),
        contentAlignment = Alignment.CenterEnd){
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = null,
            tint = tint
        )
    }

}
