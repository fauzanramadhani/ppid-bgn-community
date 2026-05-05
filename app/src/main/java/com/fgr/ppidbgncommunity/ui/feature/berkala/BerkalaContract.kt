package com.fgr.ppidbgncommunity.ui.feature.berkala

import com.fgr.ppidbgncommunity.data.model.BerkalaSection

data class BerkalaState(
    val sections: List<BerkalaSection> = emptyList(),
    val expandedSections: Set<Int> = emptySet(),
    val isLoading: Boolean = true,
)

sealed interface BerkalaEvent {
    data object Load : BerkalaEvent
    data class ToggleSection(val index: Int) : BerkalaEvent
    data class OpenUrl(val url: String) : BerkalaEvent
}

sealed interface BerkalaEffect {
    data class LaunchUrl(val url: String) : BerkalaEffect
}
