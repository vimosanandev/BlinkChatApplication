package com.vimosanan.blink.chat.presentation.chat.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.vimosanan.blink.chat.presentation.chat.screen.ChatScreen
import com.vimosanan.blink.chat.presentation.navigation.Screen

fun NavGraphBuilder.chatNavGraph(navController: NavController) {
    composable(
        route = Screen.ChatScreen.route,
        enterTransition = { fadeIn(animationSpec = tween(300)) },
    ) {
        ChatScreen()
    }
}