package com.fgr.ppidbgncommunity.data.model

import kotlinx.serialization.Serializable

@Serializable
data class BerkalaItem(
    val title: String,
    val url: String,
)

@Serializable
data class BerkalaSection(
    val title: String,
    val items: List<BerkalaItem>,
)
