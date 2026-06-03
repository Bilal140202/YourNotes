/*
 *abiola 2024
 */

package com.yournote.datastore

import androidx.datastore.core.okio.OkioSerializer
import com.yournote.model.Contrast
import com.yournote.model.DarkThemeConfig
import com.yournote.model.NoteDisplayCategory
import com.yournote.model.ThemeBrand
import com.yournote.model.UserData
import kotlinx.serialization.json.Json
import okio.BufferedSink
import okio.BufferedSource
import javax.inject.Inject

val json = Json

class UserDataJsonSerializer @Inject constructor() : OkioSerializer<UserData> {
    override val defaultValue: UserData
        get() =
            UserData(
                themeBrand = ThemeBrand.DEFAULT,
                darkThemeConfig = DarkThemeConfig.LIGHT,
                useDynamicColor = false,
                shouldHideOnboarding = false,
                contrast = Contrast.Normal,
                noteDisplayCategory = NoteDisplayCategory(),
                isGrid = true,
            )

    override suspend fun readFrom(source: BufferedSource): UserData {
        return json.decodeFromString<UserData>(source.readUtf8())
    }

    override suspend fun writeTo(
        userData: UserData,
        sink: BufferedSink,
    ) {
        sink.use {
            it.writeUtf8(json.encodeToString(UserData.serializer(), userData))
        }
    }
}
