package com.fgr.ppidbgncommunity.ui.feature.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    state: HomeState,
    onEvent: (HomeEvent) -> Unit,
) {
    HomeContent(
        state = state,
        onBerkalaClick = { onEvent(HomeEvent.NavigateToBerkala) },
        onSertaMertaClick = { onEvent(HomeEvent.NavigateToSertaMerta) },
        onWajibTersediaClick = { onEvent(HomeEvent.NavigateToWajibTersedia) },
        modifier = modifier.fillMaxSize(),
    )
}