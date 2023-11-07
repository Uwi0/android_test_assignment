package com.kakapo.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val dispatcher: VipeDispatcher)

enum class VipeDispatcher {
    IO
}