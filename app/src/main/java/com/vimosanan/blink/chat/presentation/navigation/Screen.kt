package com.vimosanan.blink.chat.presentation.navigation

sealed class Screen(val route: String) {
    data object ChatScreen : Screen("chat-screen")
}