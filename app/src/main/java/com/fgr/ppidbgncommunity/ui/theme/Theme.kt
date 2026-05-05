package com.fgr.ppidbgncommunity.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary             = NavyPrimary,
    onPrimary           = Color.White,
    primaryContainer    = NavyContainer,
    onPrimaryContainer  = NavyDeep,
    secondary           = GoldAccent,
    onSecondary         = Color.White,
    secondaryContainer  = GoldContainer,
    onSecondaryContainer = NavyDeep,
    tertiary            = SuccessGreen,
    onTertiary          = Color.White,
    tertiaryContainer   = SuccessContainer,
    onTertiaryContainer = Color(0xFF0A3D1F),
    background          = BackgroundLight,
    onBackground        = NavyDeep,
    surface             = SurfaceWhite,
    onSurface           = NavyDeep,
    surfaceVariant      = SurfaceVariantL,
    onSurfaceVariant    = OnSurfaceSubtle,
    outline             = OutlineSubtle,
    error               = ErrorRedCustom,
    onError             = Color.White,
    errorContainer      = ErrorContainer,
    onErrorContainer    = Color(0xFF7C0000),
)

private val DarkColorScheme = darkColorScheme(
    primary             = NavyPrimaryDark,
    onPrimary           = NavyDeep,
    primaryContainer    = NavyDeep,
    onPrimaryContainer  = NavyPrimaryDark,
    secondary           = GoldLight,
    onSecondary         = NavyDeep,
    secondaryContainer  = Color(0xFF3D2A00),
    onSecondaryContainer = GoldLight,
    background          = SurfaceDark,
    onBackground        = OnSurfaceDark,
    surface             = Color(0xFF152238),
    onSurface           = OnSurfaceDark,
    surfaceVariant      = SurfaceVarDark,
    onSurfaceVariant    = Color(0xFFAFC0D8),
    outline             = Color(0xFF3A5070),
    error               = Color(0xFFFF6B6B),
    onError             = Color.White,
)

@Composable
fun PPIDBGNCOMMUNITYTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = NavyDeep.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}