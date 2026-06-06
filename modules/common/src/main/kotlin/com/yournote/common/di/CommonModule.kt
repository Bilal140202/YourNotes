/*
 *abiola 2024
 */

package com.yournote.common.di

import com.yournote.common.AlarmManager
import com.yournote.common.ContentManager
import com.yournote.common.IAlarmManager
import com.yournote.common.IContentManager
import com.yournote.common.INotePlayer
import com.yournote.common.NotePlayer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CommonModule {

    @Binds
    internal abstract fun bindsAlarmManager(
        alarmManager: AlarmManager,
    ): IAlarmManager

    @Binds
    internal abstract fun bindsContentManager(
        contentManager: ContentManager,
    ): IContentManager

    @Binds
    internal abstract fun bindsNotePlayer(
        notePlayer: NotePlayer,
    ): INotePlayer
}
