package com.fgr.ppidbgncommunity.data.local

import android.content.Context
import com.fgr.ppidbgncommunity.data.model.BerkalaSection
import kotlinx.serialization.json.Json

private val json = Json { ignoreUnknownKeys = true }

fun readBerkalaSections(context: Context): List<BerkalaSection> {
    val raw = context.assets.open("berkala.json")
        .bufferedReader()
        .use { it.readText() }
    return json.decodeFromString(raw)
}
