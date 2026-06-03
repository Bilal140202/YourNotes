package com.yournote.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

sealed class MyColors {

    abstract val primaryLight: Color
    abstract val onPrimaryLight: Color
    abstract val primaryContainerLight: Color
    abstract val onPrimaryContainerLight: Color
    abstract val secondaryLight: Color
    abstract val onSecondaryLight: Color
    abstract val secondaryContainerLight: Color
    abstract val onSecondaryContainerLight: Color
    abstract val tertiaryLight: Color
    abstract val onTertiaryLight: Color
    abstract val tertiaryContainerLight: Color
    abstract val onTertiaryContainerLight: Color
    abstract val errorLight: Color
    abstract val onErrorLight: Color
    abstract val errorContainerLight: Color
    abstract val onErrorContainerLight: Color
    abstract val backgroundLight: Color
    abstract val onBackgroundLight: Color
    abstract val surfaceLight: Color
    abstract val onSurfaceLight: Color
    abstract val surfaceVariantLight: Color
    abstract val onSurfaceVariantLight: Color
    abstract val outlineLight: Color
    abstract val outlineVariantLight: Color
    abstract val scrimLight: Color
    abstract val inverseSurfaceLight: Color
    abstract val inverseOnSurfaceLight: Color
    abstract val inversePrimaryLight: Color
    abstract val surfaceDimLight: Color
    abstract val surfaceBrightLight: Color
    abstract val surfaceContainerLowestLight: Color
    abstract val surfaceContainerLowLight: Color
    abstract val surfaceContainerLight: Color
    abstract val surfaceContainerHighLight: Color
    abstract val surfaceContainerHighestLight: Color

    abstract val primaryDark: Color
    abstract val onPrimaryDark: Color
    abstract val primaryContainerDark: Color
    abstract val onPrimaryContainerDark: Color
    abstract val secondaryDark: Color
    abstract val onSecondaryDark: Color
    abstract val secondaryContainerDark: Color
    abstract val onSecondaryContainerDark: Color
    abstract val tertiaryDark: Color
    abstract val onTertiaryDark: Color
    abstract val tertiaryContainerDark: Color
    abstract val onTertiaryContainerDark: Color
    abstract val errorDark: Color
    abstract val onErrorDark: Color
    abstract val errorContainerDark: Color
    abstract val onErrorContainerDark: Color
    abstract val backgroundDark: Color
    abstract val onBackgroundDark: Color
    abstract val surfaceDark: Color
    abstract val onSurfaceDark: Color
    abstract val surfaceVariantDark: Color
    abstract val onSurfaceVariantDark: Color
    abstract val outlineDark: Color
    abstract val outlineVariantDark: Color
    abstract val scrimDark: Color
    abstract val inverseSurfaceDark: Color
    abstract val inverseOnSurfaceDark: Color
    abstract val inversePrimaryDark: Color
    abstract val surfaceDimDark: Color
    abstract val surfaceBrightDark: Color
    abstract val surfaceContainerLowestDark: Color
    abstract val surfaceContainerLowDark: Color
    abstract val surfaceContainerDark: Color
    abstract val surfaceContainerHighDark: Color
    abstract val surfaceContainerHighestDark: Color

    data object Default : MyColors() {

        // Light theme - Purple baseline
        override val primaryLight = Color(0xFF6750A4)
        override val onPrimaryLight = Color(0xFFFFFFFF)
        override val primaryContainerLight = Color(0xFFEADDFF)
        override val onPrimaryContainerLight = Color(0xFF21005D)
        override val secondaryLight = Color(0xFF625B71)
        override val onSecondaryLight = Color(0xFFFFFFFF)
        override val secondaryContainerLight = Color(0xFFE8DEF8)
        override val onSecondaryContainerLight = Color(0xFF1D192B)
        override val tertiaryLight = Color(0xFF7D5260)
        override val onTertiaryLight = Color(0xFFFFFFFF)
        override val tertiaryContainerLight = Color(0xFFFFD8E4)
        override val onTertiaryContainerLight = Color(0xFF31111D)
        override val errorLight = Color(0xFFB3261E)
        override val onErrorLight = Color(0xFFFFFFFF)
        override val errorContainerLight = Color(0xFFF9DEDC)
        override val onErrorContainerLight = Color(0xFF410E0B)
        override val backgroundLight = Color(0xFFFFFBFE)
        override val onBackgroundLight = Color(0xFF1C1B1F)
        override val surfaceLight = Color(0xFFFFFBFE)
        override val onSurfaceLight = Color(0xFF1C1B1F)
        override val surfaceVariantLight = Color(0xFFE7E0EC)
        override val onSurfaceVariantLight = Color(0xFF49454F)
        override val outlineLight = Color(0xFF79747E)
        override val outlineVariantLight = Color(0xFFCAC4D0)
        override val scrimLight = Color(0xFF000000)
        override val inverseSurfaceLight = Color(0xFF313033)
        override val inverseOnSurfaceLight = Color(0xFFF4EFF4)
        override val inversePrimaryLight = Color(0xFFD0BCFF)
        override val surfaceDimLight = Color(0xFFDED8E1)
        override val surfaceBrightLight = Color(0xFFFFFBFE)
        override val surfaceContainerLowestLight = Color(0xFFFFFFFF)
        override val surfaceContainerLowLight = Color(0xFFF7F2FA)
        override val surfaceContainerLight = Color(0xFFF3EDF7)
        override val surfaceContainerHighLight = Color(0xFFECE6F0)
        override val surfaceContainerHighestLight = Color(0xFFE6E0E9)

        // Dark theme - Purple baseline
        override val primaryDark = Color(0xFFD0BCFF)
        override val onPrimaryDark = Color(0xFF381E72)
        override val primaryContainerDark = Color(0xFF4F378B)
        override val onPrimaryContainerDark = Color(0xFFEADDFF)
        override val secondaryDark = Color(0xFFCCC2DC)
        override val onSecondaryDark = Color(0xFF332D41)
        override val secondaryContainerDark = Color(0xFF4A4458)
        override val onSecondaryContainerDark = Color(0xFFE8DEF8)
        override val tertiaryDark = Color(0xFFEFB8C8)
        override val onTertiaryDark = Color(0xFF492532)
        override val tertiaryContainerDark = Color(0xFF633B48)
        override val onTertiaryContainerDark = Color(0xFFFFD8E4)
        override val errorDark = Color(0xFFF2B8B5)
        override val onErrorDark = Color(0xFF601410)
        override val errorContainerDark = Color(0xFF8C1D18)
        override val onErrorContainerDark = Color(0xFFF9DEDC)
        override val backgroundDark = Color(0xFF1C1B1F)
        override val onBackgroundDark = Color(0xFFE6E0E9)
        override val surfaceDark = Color(0xFF1C1B1F)
        override val onSurfaceDark = Color(0xFFE6E0E9)
        override val surfaceVariantDark = Color(0xFF49454F)
        override val onSurfaceVariantDark = Color(0xFFCAC4D0)
        override val outlineDark = Color(0xFF938F99)
        override val outlineVariantDark = Color(0xFF49454F)
        override val scrimDark = Color(0xFF000000)
        override val inverseSurfaceDark = Color(0xFFE6E0E9)
        override val inverseOnSurfaceDark = Color(0xFF313033)
        override val inversePrimaryDark = Color(0xFF6750A4)
        override val surfaceDimDark = Color(0xFF1C1B1F)
        override val surfaceBrightDark = Color(0xFF464049)
        override val surfaceContainerLowestDark = Color(0xFF141218)
        override val surfaceContainerLowDark = Color(0xFF211F26)
        override val surfaceContainerDark = Color(0xFF25232A)
        override val surfaceContainerHighDark = Color(0xFF302D38)
        override val surfaceContainerHighestDark = Color(0xFF3B383E)
    }

    data object Pink : MyColors() {

        // Light theme - Teal alternative
        override val primaryLight = Color(0xFF006B5E)
        override val onPrimaryLight = Color(0xFFFFFFFF)
        override val primaryContainerLight = Color(0xFF7AF8DE)
        override val onPrimaryContainerLight = Color(0xFF00201B)
        override val secondaryLight = Color(0xFF4A635E)
        override val onSecondaryLight = Color(0xFFFFFFFF)
        override val secondaryContainerLight = Color(0xFFCCE8E2)
        override val onSecondaryContainerLight = Color(0xFF06201B)
        override val tertiaryLight = Color(0xFF416279)
        override val onTertiaryLight = Color(0xFFFFFFFF)
        override val tertiaryContainerLight = Color(0xFFC5E6FF)
        override val onTertiaryContainerLight = Color(0xFF001E30)
        override val errorLight = Color(0xFFBA1A1A)
        override val onErrorLight = Color(0xFFFFFFFF)
        override val errorContainerLight = Color(0xFFFFDAD6)
        override val onErrorContainerLight = Color(0xFF410002)
        override val backgroundLight = Color(0xFFFAFDFB)
        override val onBackgroundLight = Color(0xFF191C1B)
        override val surfaceLight = Color(0xFFFAFDFB)
        override val onSurfaceLight = Color(0xFF191C1B)
        override val surfaceVariantLight = Color(0xFFDAE5E2)
        override val onSurfaceVariantLight = Color(0xFF3F4946)
        override val outlineLight = Color(0xFF6F7976)
        override val outlineVariantLight = Color(0xFFBEC9C5)
        override val scrimLight = Color(0xFF000000)
        override val inverseSurfaceLight = Color(0xFF2E3130)
        override val inverseOnSurfaceLight = Color(0xFFEFF1EF)
        override val inversePrimaryLight = Color(0xFF5CDBC2)
        override val surfaceDimLight = Color(0xFFD9DDE0)
        override val surfaceBrightLight = Color(0xFFFAFDFB)
        override val surfaceContainerLowestLight = Color(0xFFFFFFFF)
        override val surfaceContainerLowLight = Color(0xFFF3F7F5)
        override val surfaceContainerLight = Color(0xFFEDF1EF)
        override val surfaceContainerHighLight = Color(0xFFE8ECE9)
        override val surfaceContainerHighestLight = Color(0xFFE2E7E4)

        // Dark theme - Teal alternative
        override val primaryDark = Color(0xFF5CDBC2)
        override val onPrimaryDark = Color(0xFF003730)
        override val primaryContainerDark = Color(0xFF005048)
        override val onPrimaryContainerDark = Color(0xFF7AF8DE)
        override val secondaryDark = Color(0xFFB1CCC6)
        override val onSecondaryDark = Color(0xFF1D3530)
        override val secondaryContainerDark = Color(0xFF344C47)
        override val onSecondaryContainerDark = Color(0xFFCCE8E2)
        override val tertiaryDark = Color(0xFFA9CAE2)
        override val onTertiaryDark = Color(0xFF103447)
        override val tertiaryContainerDark = Color(0xFF294A60)
        override val onTertiaryContainerDark = Color(0xFFC5E6FF)
        override val errorDark = Color(0xFFFFB4AB)
        override val onErrorDark = Color(0xFF690005)
        override val errorContainerDark = Color(0xFF93000A)
        override val onErrorContainerDark = Color(0xFFFFDAD6)
        override val backgroundDark = Color(0xFF191C1B)
        override val onBackgroundDark = Color(0xFFE2E7E4)
        override val surfaceDark = Color(0xFF191C1B)
        override val onSurfaceDark = Color(0xFFE2E7E4)
        override val surfaceVariantDark = Color(0xFF3F4946)
        override val onSurfaceVariantDark = Color(0xFFBEC9C5)
        override val outlineDark = Color(0xFF89938F)
        override val outlineVariantDark = Color(0xFF3F4946)
        override val scrimDark = Color(0xFF000000)
        override val inverseSurfaceDark = Color(0xFFE2E7E4)
        override val inverseOnSurfaceDark = Color(0xFF2E3130)
        override val inversePrimaryDark = Color(0xFF006B5E)
        override val surfaceDimDark = Color(0xFF191C1B)
        override val surfaceBrightDark = Color(0xFF3F4240)
        override val surfaceContainerLowestDark = Color(0xFF141716)
        override val surfaceContainerLowDark = Color(0xFF211F26)
        override val surfaceContainerDark = Color(0xFF252325)
        override val surfaceContainerHighDark = Color(0xFF302D2F)
        override val surfaceContainerHighestDark = Color(0xFF3B383A)
    }
}

val playLight = Color(0xFF006A65)
val onPlayLight = Color(0xFFFFFFFF)
val playContainerLight = Color(0xFF9DF2EA)
val onPlayContainerLight = Color(0xFF00201E)
val pauseLight = Color(0xFF2B638B)
val onPauseLight = Color(0xFFFFFFFF)
val pauseContainerLight = Color(0xFFCCE5FF)
val onPauseContainerLight = Color(0xFF001E31)

val playDark = Color(0xFF81D5CE)
val onPlayDark = Color(0xFF003734)
val playContainerDark = Color(0xFF00504C)
val onPlayContainerDark = Color(0xFF9DF2EA)
val pauseDark = Color(0xFF98CCF9)
val onPauseDark = Color(0xFF003350)
val pauseContainerDark = Color(0xFF044B71)
val onPauseContainerDark = Color(0xFFCCE5FF)

val extendedLight = ExtendedColorScheme(
    play = ColorFamily(
        playLight,
        onPlayLight,
        playContainerLight,
        onPlayContainerLight,
    ),
    pause = ColorFamily(
        pauseLight,
        onPauseLight,
        pauseContainerLight,
        onPauseContainerLight,
    ),
)

val extendedDark = ExtendedColorScheme(
    play = ColorFamily(
        playDark,
        onPlayDark,
        playContainerDark,
        onPlayContainerDark,
    ),
    pause = ColorFamily(
        pauseDark,
        onPauseDark,
        pauseContainerDark,
        onPauseContainerDark,
    ),
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color,
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified,
    Color.Unspecified,
    Color.Unspecified,
    Color.Unspecified,
)

@Immutable
data class ExtendedColorScheme(
    val play: ColorFamily,
    val pause: ColorFamily,
)
