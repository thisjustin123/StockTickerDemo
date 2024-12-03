package com.cornellappdev.android.stocktickerdemo.model

import kotlinx.coroutines.delay

object TickerRepository {
    suspend fun getTickerValue(ticker: String): Double {
        // Simulate a delay.
        delay(400)

        // Random value along 100 - 1000
        return (100..1000).random().toDouble()
    }
}
