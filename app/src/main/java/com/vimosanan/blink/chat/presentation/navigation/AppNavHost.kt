package com.vimosanan.blink.chat.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vimosanan.blink.chat.presentation.chat.screen.ChatScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.ChatScreen.route,
        enterTransition = NavigationAnimation.enterSlideFromRight,
        exitTransition = NavigationAnimation.exitSlideToLeft,
        popEnterTransition = NavigationAnimation.popEnterSlideFromLeft,
        popExitTransition = NavigationAnimation.popExitSlideToRight,
    ) {
        composable(Screen.ChatScreen.route) {
            ChatScreen()
        }
    }
}