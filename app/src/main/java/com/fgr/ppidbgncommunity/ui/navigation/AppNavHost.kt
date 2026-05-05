package com.fgr.ppidbgncommunity.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fgr.ppidbgncommunity.common.CollectEffect
import com.fgr.ppidbgncommunity.ui.feature.berkala.BerkalaEffect
import com.fgr.ppidbgncommunity.ui.feature.berkala.BerkalaScreen
import com.fgr.ppidbgncommunity.ui.feature.berkala.BerkalaViewModel
import com.fgr.ppidbgncommunity.ui.feature.home.HomeEffect
import com.fgr.ppidbgncommunity.ui.feature.home.HomeEvent
import com.fgr.ppidbgncommunity.ui.feature.home.HomeScreen
import com.fgr.ppidbgncommunity.ui.feature.home.HomeViewModel
import com.fgr.ppidbgncommunity.ui.feature.sertamerta.SertaMertaScreen
import com.fgr.ppidbgncommunity.ui.feature.wajibtersedia.WajibTersediaScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.HomeScreen,
    ) {
        // ── HOME ──────────────────────────────────────────────────────
        composable<Screen.HomeScreen> {
            val vm: HomeViewModel = hiltViewModel()
            val state by vm.state.collectAsState()

            CollectEffect(vm.effect) { effect: HomeEffect ->
                when (effect) {
                    is HomeEffect.Navigate -> navHostController.navigate(effect.route)
                }
            }

            HomeScreen(
                modifier = modifier,
                state = state,
                onEvent = vm::onEvent,
            )
        }

        // ── BERKALA ───────────────────────────────────────────────────
        composable<Screen.BerkalaScreen> {
            val vm: BerkalaViewModel = hiltViewModel()
            val state by vm.state.collectAsState()

            // BerkalaEffect.LaunchUrl is handled directly in BerkalaScreen
            // via Intent to keep the browser launch simple and synchronous.
            CollectEffect(vm.effect) { _: BerkalaEffect -> /* no-op */ }

            BerkalaScreen(
                state = state,
                onEvent = vm::onEvent,
                onBack = { navHostController.popBackStack() },
                modifier = modifier,
            )
        }

        // ── SERTA MERTA ───────────────────────────────────────────────
        composable<Screen.SertaMertaScreen> {
            SertaMertaScreen(
                onBack = { navHostController.popBackStack() },
                modifier = modifier,
            )
        }

        // ── WAJIB TERSEDIA ────────────────────────────────────────────
        composable<Screen.WajibTersediaScreen> {
            WajibTersediaScreen(
                onBack = { navHostController.popBackStack() },
                modifier = modifier,
            )
        }
    }
}