package com.fgr.ppidbgncommunity.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.flow.Flow

@Composable
fun <EFFECT> CollectEffect(
    effect: Flow<EFFECT>,
    onEffect: (EFFECT) -> Unit
) {
    LaunchedEffect(Unit) {
        effect.collect(onEffect)
    }
}