package com.example.bivvy.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.rememberViewModelStoreProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.bivvy.data.datastore.UserRepository
import com.example.bivvy.ui.screens.main.MainScreen
import com.example.bivvy.ui.screens.onboarding.OnboardingScreen
import com.example.bivvy.ui.screens.onboarding.OnboardingViewModel


@Composable
fun AppNavigation(
    onExit: () -> Unit
){
    val backStack = rememberNavBackStack(OnboardingRoute)
    NavDisplay(
        backStack = backStack,
        onBack = {backStack.removeLastOrNull()},

        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<OnboardingRoute>{
                val viewModel = hiltViewModel<OnboardingViewModel>()
                OnboardingScreen(
                    onExit = onExit,
                    onUsernameConfirm = { username ->
                        viewModel.onUsernameConfirmed(username){
                            backStack.add(MainRoute)
                            backStack.remove(OnboardingRoute)
                        }
                    }
                )
            }
            entry<MainRoute>{
                MainScreen()
            }
        }
    )



}