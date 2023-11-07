package com.kakapo.common.type

fun Int?.orZero(): Int {
    return this ?: 0
}