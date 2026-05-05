package com.fgr.ppidbgncommunity.ui.feature.home

import com.fgr.ppidbgncommunity.common.BaseViewModel
import com.fgr.ppidbgncommunity.ui.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() :
    BaseViewModel<HomeEvent, HomeState, HomeEffect>(initialState = HomeState()) {

    override fun onEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.Load -> Unit // stats already in initial state
            HomeEvent.NavigateToBerkala ->
                sendEffect(HomeEffect.Navigate(Screen.BerkalaScreen))
            HomeEvent.NavigateToSertaMerta ->
                sendEffect(HomeEffect.Navigate(Screen.SertaMertaScreen))
            HomeEvent.NavigateToWajibTersedia ->
                sendEffect(HomeEffect.Navigate(Screen.WajibTersediaScreen))
        }
    }
}