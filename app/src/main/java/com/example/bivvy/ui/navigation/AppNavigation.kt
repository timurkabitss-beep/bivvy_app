package com.example.bivvy.ui.navigation

import android.app.Dialog
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.bivvy.ui.screens.firstscreen.FirstScreen

@Composable
fun AppNavigation(){
    val backStack = rememberNavBackStack(FirstRoute)
    NavDisplay(
        backStack = backStack,
        onBack = {backStack.removeLastOrNull()},
        entryProvider = entryProvider {
            entry<FirstRoute>{
                FirstScreen()
            }

        }
    )



}