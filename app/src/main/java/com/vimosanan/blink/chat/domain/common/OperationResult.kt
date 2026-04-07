package com.vimosanan.blink.chat.domain.common

sealed interface OperationResult {
    data object Success : OperationResult

    data class Error(
        val error: String,
    ) : OperationResult
}