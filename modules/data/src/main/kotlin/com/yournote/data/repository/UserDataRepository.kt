/*
 *abiola 2024
 */

package com.yournote.data.repository

import com.yournote.model.Contrast
import com.yournote.model.DarkThemeConfig
import com.yournote.model.NoteDisplayCategory
import com.yournote.model.ThemeBrand
import com.yournote.model.UserData
import kotlinx.coroutines.flow.Flow

interface UserDataRepository {

    /**
     * Stream of [UserData]
     */
    val userData: Flow<UserData>

    suspend fun setThemeBrand(themeBrand: ThemeBrand)

    suspend fun setThemeContrast(contrast: Contrast)

    /**
     * Sets the desired dark theme config.
     */
    suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig)

    /**
     * Sets the preferred dynamic color config.
     */
    suspend fun setDynamicColorPreference(useDynamicColor: Boolean)

    /**
     * Sets whether the user has completed the onboarding process.
     */
    suspend fun setShouldHideOnboarding(shouldHideOnboarding: Boolean)
    suspend fun setNoteDisplayCategory(noteDisplayCategory: NoteDisplayCategory)

    suspend fun toggleGrid()
}
