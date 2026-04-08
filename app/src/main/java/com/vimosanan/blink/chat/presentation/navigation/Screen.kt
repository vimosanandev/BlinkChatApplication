package com.vimosanan.blink.chat.presentation.navigation

sealed class Screen(val route: String) {
    data object ChatScreen : Screen("inbox")
    data class Messages(
        val conversationId: String,
    ) : Screen("messages/{conversationId}") {
        companion object {
            const val ROUTE = "messages/{conversationId}"
            const val ARG = "conversationId"

            fun createRoute(conversationId: String) = "messages/$conversationId"
        }
    }
}