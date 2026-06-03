/*
 *abiola 2022
 */

package com.yournote.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yournote.data.repository.UserDataRepository
import com.yournote.model.DarkThemeConfig
import com.yournote.model.ThemeBrand
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val userDataRepository: UserDataRepository,
) : ViewModel() {

    val settingState = userDataRepository
        .userData
        .mapLatest {
            SettingState(
                themeBrand = it.themeBrand,
                darkThemeConfig = it.darkThemeConfig,
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = SettingState(),
        )

    fun setThemeBrand(themeBrand: ThemeBrand) {
        viewModelScope.launch {
            userDataRepository.setThemeBrand(themeBrand)
        }
    }

    /**
     * Sets the desired dark theme config.
     */
    fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig) {
        viewModelScope.launch {
            userDataRepository.setDarkThemeConfig(darkThemeConfig)
        }
    }
}
