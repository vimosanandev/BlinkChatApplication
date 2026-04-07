package com.vimosanan.blink.chat.domain.usecase.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

abstract class FlowUseCase<in P, T>(private val dispatcher: CoroutineDispatcher) : UseCase {
    operator fun invoke(params: P): Flow<T> = execute(params).flowOn(dispatcher)

    protected abstract fun execute(params: P): Flow<T>
}