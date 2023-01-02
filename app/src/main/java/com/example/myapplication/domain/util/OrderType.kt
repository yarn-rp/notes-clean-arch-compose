package com.example.myapplication.domain.util

/**
    * Ascending or descending order.
 */
sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
