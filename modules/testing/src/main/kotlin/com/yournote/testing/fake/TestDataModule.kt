/*
 *abiola 2024
 */

package com.yournote.testing.fake

import com.yournote.data.di.DataModule
import com.yournote.data.repository.LabelRepository
import com.yournote.data.repository.NoteCheckRepository
import com.yournote.data.repository.NoteDrawingRepository
import com.yournote.data.repository.NoteImageRepository
import com.yournote.data.repository.NoteLabelRepository
import com.yournote.data.repository.NoteNotificationRepository
import com.yournote.data.repository.NoteRepository
import com.yournote.data.repository.NoteVoiceRepository
import com.yournote.data.repository.UserDataRepository
import com.yournote.data.util.NetworkMonitor
import com.yournote.testing.fake.repository.FakeLabelRepository
import com.yournote.testing.fake.repository.FakeNoteCheckRepository
import com.yournote.testing.fake.repository.FakeNoteDrawingRepository
import com.yournote.testing.fake.repository.FakeNoteImageRepository
import com.yournote.testing.fake.repository.FakeNoteLabelRepository
import com.yournote.testing.fake.repository.FakeNoteRepository
import com.yournote.testing.fake.repository.FakeNoteVoiceRepository
import com.yournote.testing.fake.repository.FakeNotificationRepository
import com.yournote.testing.fake.repository.FakeUserDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DataModule::class],
)
internal interface TestDataModule {

    @Binds
    fun bindsNetworkMonitor(
        networkMonitor: AlwaysOnlineNetworkMonitor,
    ): NetworkMonitor

    @Binds
    fun bindsUserDataRepository(
        userDataRepository: FakeUserDataRepository,
    ): UserDataRepository

    @Binds
    fun bindNoteRepository(
        noteRepository: FakeNoteRepository,
    ): NoteRepository

    @Binds
    fun bindNoteCheckRepository(
        noteCheckRepository: FakeNoteCheckRepository,
    ): NoteCheckRepository

    @Binds
    fun bindNoteDrawingRepository(
        noteDrawingRepository: FakeNoteDrawingRepository,
    ): NoteDrawingRepository

    @Binds
    fun bindNoteImageRepository(
        noteImageRepository: FakeNoteImageRepository,
    ): NoteImageRepository

    @Binds
    fun bindNoteLabelRepository(
        noteLabelRepository: FakeNoteLabelRepository,
    ): NoteLabelRepository

    @Binds
    fun bindNoteNotificationRepository(
        notificationRepository: FakeNotificationRepository,
    ): NoteNotificationRepository

    @Binds
    fun bindNoteVoiceRepository(
        noteVoiceRepository: FakeNoteVoiceRepository,
    ): NoteVoiceRepository

    @Binds
    fun bindsLabelRepository(
        realLabelRepository: FakeLabelRepository,
    ): LabelRepository
}
