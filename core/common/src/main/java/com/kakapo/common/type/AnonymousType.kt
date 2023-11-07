package com.kakapo.common.type

typealias Func = () -> Unit
typealias Fun<A, B> = (A) -> B
typealias SuspendFun<A, B> = suspend (A) -> B
typealias SuspendFunc<T> = (T) -> Unit

inline infix fun <A, B> A.map(crossinline f: Fun<A, B>): B = f(this)

suspend inline infix fun <A, B> A.mapSuspend(crossinline f: SuspendFun<A, B>): B = f(this)