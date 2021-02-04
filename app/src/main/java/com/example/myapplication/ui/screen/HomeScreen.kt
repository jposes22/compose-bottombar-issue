package com.example.myapplication.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.ui.base.NavScreen
import com.example.myapplication.ui.components.DefaultBottomBar
import java.text.DecimalFormat

@Composable
fun HomeScreen(navController: NavController){
    val bottomNavigationItems = remember {
        listOf(
            NavScreen.Test1,
            NavScreen.Test2
        )
    }

    val selectedTab: MutableState<NavScreen> =  mutableStateOf(bottomNavigationItems.first())

    Scaffold(
        bodyContent = { HomeBody() },
       //Comment this line to show 59 items
        bottomBar = { DefaultBottomBar(selectedTab,bottomNavigationItems) }
    )
}
fun getList() = (0..59).map { DecimalFormat("00").format(it) }
@Composable
private fun HomeBody(items:List<String> = getList()){
    Surface(Modifier.fillMaxSize()) {
        LazyColumn {
            items(items) {
                ItemRow(it)
            }
        }
    }
}
@Composable
private fun ItemRow(item:String){
    Row(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Text("Session $item")
    }
}