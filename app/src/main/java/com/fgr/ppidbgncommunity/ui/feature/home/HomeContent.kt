package com.fgr.ppidbgncommunity.ui.feature.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fgr.ppidbgncommunity.R
import com.fgr.ppidbgncommunity.ui.component.MenuItemCard
import com.fgr.ppidbgncommunity.ui.component.StatsCard
import com.fgr.ppidbgncommunity.ui.component.SummaryCard
import com.fgr.ppidbgncommunity.ui.theme.GoldAccent
import com.fgr.ppidbgncommunity.ui.theme.NavyDeep

@Composable
fun HomeContent(
    state: HomeState,
    onBerkalaClick: () -> Unit,
    onSertaMertaClick: () -> Unit,
    onWajibTersediaClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { visible = true }

    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(animationSpec = tween(500)),
    ) {
        LazyColumn(
            modifier = modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize(),
        ) {
            // ── HEADER with overlapping card ──────────────────────────
            item {
                Box {
                    // Banner image + gradient overlay
                    Box(modifier = Modifier.height(240.dp)) {
                        Image(
                            painter = painterResource(R.drawable.header_home_bgn),
                            contentDescription = "Header PPID BGN",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize(),
                        )
                        // Gradient overlay: top transparent → bottom deep navy
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Brush.verticalGradient(
                                        colors = listOf(
                                            Color.Transparent,
                                            NavyDeep.copy(alpha = 0.55f),
                                            NavyDeep.copy(alpha = 0.85f),
                                        ),
                                        startY = 60f,
                                    )
                                )
                        )
                        // Screen title on top of gradient
                        Column(
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(start = 20.dp, bottom = 44.dp),
                        ) {
                            Text(
                                text = "PPID BGN",
                                style = MaterialTheme.typography.labelMedium,
                                color = Color.White.copy(alpha = 0.8f),
                            )
                            Text(
                                text = "Layanan Informasi Publik",
                                style = MaterialTheme.typography.headlineSmall,
                                color = Color.White,
                            )
                        }
                    }

                    // ── FLOATING MENU CARD (overlap) ──────────────────
                    Surface(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .offset(y = 70.dp)
                            .padding(horizontal = 20.dp)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(24.dp),
                        color = MaterialTheme.colorScheme.surface,
                        shadowElevation = 8.dp,
                        tonalElevation = 0.dp,
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                        ) {
                            MenuItemCard(
                                icon = Icons.Default.Info,
                                label = "Berkala",
                                onClick = onBerkalaClick,
                                modifier = Modifier.weight(1f),
                            )
                            MenuItemCard(
                                icon = Icons.Default.Notifications,
                                label = "Serta Merta",
                                onClick = onSertaMertaClick,
                                modifier = Modifier.weight(1f),
                            )
                            MenuItemCard(
                                icon = Icons.Default.List,
                                label = "Wajib Tersedia",
                                onClick = onWajibTersediaClick,
                                modifier = Modifier.weight(1f),
                            )
                        }
                    }
                }
            }

            // Gap to compensate for floating card overlap
            item { Spacer(modifier = Modifier.height(86.dp)) }

            // ── SECTION LABEL: Statistik ──────────────────────────────
            item {
                SectionLabel(
                    title = "Statistik Layanan",
                    subtitle = "Data permohonan informasi publik",
                    modifier = Modifier.padding(horizontal = 20.dp),
                )
            }

            // ── STATS GRID (2 top + 1 bottom) ─────────────────────────
            item {
                Column(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        StatsCard(
                            value = state.statsPermohonanInformasi.toString(),
                            label = "Permohonan Informasi",
                            accentColor = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.weight(1f),
                        )
                        StatsCard(
                            value = state.statsPermohonanKeberatan.toString(),
                            label = "Permohonan Keberatan",
                            accentColor = GoldAccent,
                            modifier = Modifier.weight(1f),
                        )
                    }
                    StatsCard(
                        value = "${state.statsSurveyKepuasan}%",
                        label = "Indeks Kepuasan Masyarakat",
                        accentColor = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
            }

            item { Spacer(modifier = Modifier.height(16.dp)) }

            // ── SECTION LABEL: Ringkasan ──────────────────────────────
            item {
                SectionLabel(
                    title = "Ringkasan Permohonan",
                    subtitle = "Status seluruh permohonan informasi",
                    modifier = Modifier.padding(horizontal = 20.dp),
                )
            }

            // ── SUMMARY CARD ──────────────────────────────────────────
            item {
                SummaryCard(
                    diterima = state.statsDiterima,
                    ditolak = state.statsDitolak,
                    modifier = Modifier.padding(horizontal = 20.dp),
                )
            }

            item { Spacer(modifier = Modifier.height(32.dp)) }
        }
    }
}

@Composable
private fun SectionLabel(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(bottom = 12.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground,
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}
