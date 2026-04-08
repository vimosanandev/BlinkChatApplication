package com.vimosanan.blink.chat.domain.usecase.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class ParamsUseCase<in P, out R>(
    private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(params: P): R =
        withContext(dispatcher) {
            execute(params)
        }

    protected abstract suspend fun execute(params: P): R
}