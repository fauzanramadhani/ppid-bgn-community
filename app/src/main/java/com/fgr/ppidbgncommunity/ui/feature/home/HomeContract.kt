package com.fgr.ppidbgncommunity.ui.feature.home

sealed interface HomeEvent {
    data object Load : HomeEvent
    data object NavigateToBerkala : HomeEvent
    data object NavigateToSertaMerta : HomeEvent
    data object NavigateToWajibTersedia : HomeEvent
}

sealed interface HomeEffect {
    data class Navigate(val route: Any) : HomeEffect
}