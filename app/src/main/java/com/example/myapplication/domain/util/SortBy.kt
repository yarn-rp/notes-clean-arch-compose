package com.example.myapplication.domain.util

sealed class SortBy(val orderType: OrderType) {
    class Date(orderType: OrderType): SortBy(orderType)
    class Title(orderType: OrderType): SortBy(orderType)
}