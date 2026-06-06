/*
 *abiola 2024
 */

package com.yournote.data.di

import com.yournote.data.repository.LabelRepository
import com.yournote.data.repository.NoteCheckRepository
import com.yournote.data.repository.NoteDrawingRepository
import com.yournote.data.repository.NoteImageRepository
import com.yournote.data.repository.NoteLabelRepository
import com.yournote.data.repository.NoteNotificationRepository
import com.yournote.data.repository.NoteRepository
import com.yournote.data.repository.NoteVoiceRepository
import com.yournote.data.repository.RealLabelRepository
import com.yournote.data.repository.RealNoteCheckRepository
import com.yournote.data.repository.RealNoteDrawingRepository
import com.yournote.data.repository.RealNoteImageRepository
import com.yournote.data.repository.RealNoteLabelRepository
import com.yournote.data.repository.RealNoteRepository
import com.yournote.data.repository.RealNoteVoiceRepository
import com.yournote.data.repository.RealNotificationRepository
import com.yournote.data.repository.RealUserDataRepository
import com.yournote.data.repository.UserDataRepository
import com.yournote.data.util.ConnectivityManagerNetworkMonitor
import com.yournote.data.util.NetworkMonitor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindsNetworkMonitor(
        networkMonitor: ConnectivityManagerNetworkMonitor,
    ): NetworkMonitor

    @Binds
    internal abstract fun bindsUserDataRepository(
        userDataRepository: RealUserDataRepository,
    ): UserDataRepository

    @Binds
    internal abstract fun bindNoteRepository(
        noteRepository: RealNoteRepository,
    ): NoteRepository

    @Binds
    internal abstract fun bindNoteCheckRepository(
        noteCheckRepository: RealNoteCheckRepository,
    ): NoteCheckRepository

    @Binds
    internal abstract fun bindNoteDrawingRepository(
        noteDrawingRepository: RealNoteDrawingRepository,
    ): NoteDrawingRepository

    @Binds
    internal abstract fun bindNoteImageRepository(
        noteImageRepository: RealNoteImageRepository,
    ): NoteImageRepository

    @Binds
    internal abstract fun bindNoteLabelRepository(
        noteLabelRepository: RealNoteLabelRepository,
    ): NoteLabelRepository

    @Binds
    internal abstract fun bindNoteNotificationRepository(
        notificationRepository: RealNotificationRepository,
    ): NoteNotificationRepository

    @Binds
    internal abstract fun bindNoteVoiceRepository(
        noteVoiceRepository: RealNoteVoiceRepository,
    ): NoteVoiceRepository

    @Binds
    internal abstract fun bindsLabelRepository(
        realLabelRepository: RealLabelRepository,
    ): LabelRepository
}
