package com.vimosanan.blink.chat.presentation.chat.inbox.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.vimosanan.blink.chat.presentation.chat.detail.screen.MessageScreen
import com.vimosanan.blink.chat.presentation.chat.inbox.screen.InboxScreen
import com.vimosanan.blink.chat.presentation.navigation.Screen

fun NavGraphBuilder.chatNavGraph(navController: NavController) {
    composable(
        route = Screen.ChatScreen.route,
        enterTransition = { fadeIn(animationSpec = tween(300)) },
    ) {
        InboxScreen { id ->
            navController.navigate(
                Screen.Messages.createRoute(id)
            )
        }
    }
    composable(
        route = Screen.Messages.ROUTE,
        arguments = listOf(
            navArgument(Screen.Messages.ARG) {
                type = androidx.navigation.NavType.StringType
            }
        )
    ) {
        MessageScreen {
            navController.popBackStack()
        }
    }
}