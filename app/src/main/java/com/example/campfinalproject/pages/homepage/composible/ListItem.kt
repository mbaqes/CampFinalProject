package com.example.campfinalproject.pages.homepage.composible

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.campfinalproject.pages.homepage.data.model.Product

@Composable
fun ListItem(onclick: () -> Unit, item: Product) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.horizontalGradient(
                    colors = listOf(
                        Color.Blue, Color.Gray
                    )
                )
            )
    ) {
        Column {
            Row(modifier = Modifier.fillMaxWidth()) {
                SubcomposeAsyncImage(
                    contentDescription = "",
                    loading = {
                        CircularProgressIndicator()
                    },
                    model = item.thumbnail,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(4.dp)
                        .background(Color.Red)
                )
                Column {
                    Text(text = item.title)
                    Text(text = item.price.toString())
                }
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                LazyRow {
                    items(item.images) { imageitem ->

                        SubcomposeAsyncImage(
                            contentDescription = "",
                            loading = {
                                CircularProgressIndicator()
                            },
                            model = imageitem,
                            modifier = Modifier
                                .size(100.dp)
                                .padding(4.dp)
                                .background(Color.Red)
                        )
                    }
                }
            }
        }
    }
}