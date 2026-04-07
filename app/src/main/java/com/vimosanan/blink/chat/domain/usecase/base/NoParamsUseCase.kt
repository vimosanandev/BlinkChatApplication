package com.vimosanan.blink.chat.domain.usecase.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class NoParamsUseCase<T>(private val dispatcher: CoroutineDispatcher) : UseCase {
    suspend operator fun invoke(): T =
        withContext(dispatcher) { execute() }

    protected abstract suspend fun execute(): T
}