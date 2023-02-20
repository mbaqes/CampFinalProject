package com.example.campfinalproject.pages.homepage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.campfinalproject.pages.homepage.composible.ListItem
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun HomePage(viewModel: ProductViewModel = hiltViewModel()) {
    var state = viewModel.state.collectAsState().value
Scaffold(topBar = {
    TopAppBar() {

    }
}) {
    it.calculateTopPadding()
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "List OF ")
        LazyColumn(){
            items(state.products){product->
                ListItem({  }, item = product)
            }
        }
    }

}
}