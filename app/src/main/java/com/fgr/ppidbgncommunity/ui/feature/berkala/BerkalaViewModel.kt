package com.fgr.ppidbgncommunity.ui.feature.berkala

import android.content.Context
import com.fgr.ppidbgncommunity.common.BaseViewModel
import com.fgr.ppidbgncommunity.data.local.readBerkalaSections
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class BerkalaViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
) : BaseViewModel<BerkalaEvent, BerkalaState, BerkalaEffect>(initialState = BerkalaState()) {

    init {
        onEvent(BerkalaEvent.Load)
    }

    override fun onEvent(event: BerkalaEvent) {
        when (event) {
            BerkalaEvent.Load -> loadData()
            is BerkalaEvent.ToggleSection -> toggleSection(event.index)
            is BerkalaEvent.OpenUrl -> sendEffect(BerkalaEffect.LaunchUrl(event.url))
        }
    }

    private fun loadData() {
        setState { copy(isLoading = true) }
        val sections = readBerkalaSections(context)
        setState { copy(sections = sections, isLoading = false) }
    }

    private fun toggleSection(index: Int) {
        setState {
            val updated = if (index in expandedSections) {
                expandedSections - index
            } else {
                expandedSections + index
            }
            copy(expandedSections = updated)
        }
    }
}
