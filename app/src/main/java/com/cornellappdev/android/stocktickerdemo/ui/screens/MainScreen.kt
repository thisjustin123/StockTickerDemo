package com.cornellappdev.android.stocktickerdemo.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cornellappdev.android.stocktickerdemo.ui.components.TickerRow
import com.cornellappdev.android.stocktickerdemo.viewmodel.MainViewModel

@Composable
fun MainScreen(
    mainViewModel: MainViewModel = viewModel()
) {
    // TODO: Why isn't this causing a load?
    val map = mainViewModel.mapFlow.collectAsState().value

    LazyColumn(modifier = Modifier.systemBarsPadding()) {
        itemsIndexed(map.entries.toTypedArray()) { index, entry ->
            TickerRow(ticker = entry.key, price = entry.value)

            if (index < map.size - 1) {
                Spacer(modifier = Modifier.height(1.dp).background(Color.Gray))
            }
        }
    }

}
