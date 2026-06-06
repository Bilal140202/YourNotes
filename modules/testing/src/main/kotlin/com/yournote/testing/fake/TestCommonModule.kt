/*
 *abiola 2024
 */

package com.yournote.testing.fake

import com.yournote.common.IAlarmManager
import com.yournote.common.IContentManager
import com.yournote.common.INotePlayer
import com.yournote.common.di.CommonModule
import com.yournote.testing.fake.repository.FakeAlarmManager
import com.yournote.testing.fake.repository.FakeContentManager
import com.yournote.testing.fake.repository.FakeVoicePlayer
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [CommonModule::class],
)
internal interface TestCommonModule {

    @Binds
    fun bindsAlarmManager(
        alarmManager: FakeAlarmManager,
    ): IAlarmManager

    @Binds
    fun bindsContentManager(
        contentManager: FakeContentManager,
    ): IContentManager

    @Binds
    fun bindsNotePlayer(
        notePlayer: FakeVoicePlayer,
    ): INotePlayer
}
