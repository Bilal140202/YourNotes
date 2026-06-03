package com.yournote.setting

import com.yournote.model.DarkThemeConfig
import com.yournote.model.ThemeBrand

data class SettingState(
    val themeBrand: ThemeBrand = ThemeBrand.DEFAULT,
    val darkThemeConfig: DarkThemeConfig = DarkThemeConfig.DARK,
)
