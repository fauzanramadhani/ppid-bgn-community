package com.fgr.ppidbgncommunity.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.flow.Flow

@Composable
inline fun <reified VM : BaseViewModel<*, *, *>> BindViewModel(
    crossinline content: @Composable (vm: VM) -> Unit
) {
    val vm: VM = hiltViewModel()
    content(vm)
}