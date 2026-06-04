package com.yournote.database.di

import android.content.Context
import androidx.room.Room
import com.yournote.database.NoteDatabase
import com.yournote.database.dao.LabelDao
import com.yournote.database.dao.NoteCheckDao
import com.yournote.database.dao.NoteDao
import com.yournote.database.dao.NoteDrawingDao
import com.yournote.database.dao.NoteImageDao
import com.yournote.database.dao.NoteLabelDao
import com.yournote.database.dao.NoteNotificationDao
import com.yournote.database.dao.NoteVoiceDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun databaseProvider(
        @ApplicationContext context: Context,
    ): NoteDatabase {
        return Room.databaseBuilder(context, NoteDatabase::class.java, "ludoDb.db")
            .fallbackToDestructiveMigration()
            .build()
//        return Room.inMemoryDatabaseBuilder(context,LudoDatabase::class.java,)
//            .build()
    }

    @Provides
    @Singleton
    fun labelDaoProvider(noteDatabase: NoteDatabase): LabelDao {
        return noteDatabase.getLabelDao()
    }

    @Provides
    @Singleton
    fun noteCheckDaoProvider(noteDatabase: NoteDatabase): NoteCheckDao {
        return noteDatabase.getNoteCheckDao()
    }

    @Provides
    @Singleton
    fun noteDaoProvider(noteDatabase: NoteDatabase): NoteDao {
        return noteDatabase.getNoteDao()
    }

    @Provides
    @Singleton
    fun noteImageDaoProvider(noteDatabase: NoteDatabase): NoteImageDao {
        return noteDatabase.getNoteImageDao()
    }

    @Provides
    @Singleton
    fun noteLabelDaoProvider(noteDatabase: NoteDatabase): NoteLabelDao {
        return noteDatabase.getNoteLabelDao()
    }

    @Provides
    @Singleton
    fun noteVoiceDaoProvider(noteDatabase: NoteDatabase): NoteVoiceDao {
        return noteDatabase.getNoteVoiceDao()
    }

    @Provides
    @Singleton
    fun noteDrawingDaoProvider(noteDatabase: NoteDatabase): NoteDrawingDao {
        return noteDatabase.getNoteDrawingDao()
    }

    @Provides
    @Singleton
    fun notificationDaoProvider(noteDatabase: NoteDatabase): NoteNotificationDao {
        return noteDatabase.getNotification()
    }
}
