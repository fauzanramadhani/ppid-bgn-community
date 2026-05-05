package com.fgr.ppidbgncommunity.ui.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable data object HomeScreen : Screen
    @Serializable data object BerkalaScreen : Screen
    @Serializable data object SertaMertaScreen : Screen
    @Serializable data object WajibTersediaScreen : Screen
}