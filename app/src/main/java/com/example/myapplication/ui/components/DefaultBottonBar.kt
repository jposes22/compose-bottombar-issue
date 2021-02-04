package com.example.myapplication.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import com.example.myapplication.ui.base.NavScreen

@Composable
fun DefaultBottomBar(selectedTab: MutableState<NavScreen>, bottomNavigationItems: List<NavScreen>){
    BottomNavigation  {
        bottomNavigationItems.forEach { navScreen ->
            BottomNavigationItem(
                selectedContentColor = Color.White,
                unselectedContentColor = Color.LightGray,
                icon = { Icon(Icons.Default.Settings) },
                label = { Text("Tab") },
                selected = selectedTab.value == navScreen,
                alwaysShowLabels = false, // This hides the title for the unselected items
                onClick = {
                    selectedTab.value = navScreen
                }
            )
        }
    }
}