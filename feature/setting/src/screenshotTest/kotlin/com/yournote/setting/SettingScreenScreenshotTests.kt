/*
 *abiola 2023
 */

package com.yournote.setting

import androidx.compose.runtime.Composable
import com.yournote.designsystem.theme.NotePadTheme
import com.yournote.model.DarkThemeConfig
import com.yournote.model.ThemeBrand
import com.yournote.ui.PreviewMain

class SettingScreenScreenshotTests {
    @PreviewMain
    @Composable
    internal fun Main() {
        val settingState = SettingState(
            themeBrand = ThemeBrand.DEFAULT,
            darkThemeConfig = DarkThemeConfig.LIGHT,
        )
        NotePadTheme {
            SettingScreen(
                settingState = settingState,
            )
        }
    }
}
