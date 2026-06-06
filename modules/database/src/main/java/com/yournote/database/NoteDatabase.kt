package com.yournote.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.DeleteColumn
import androidx.room.DeleteTable
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import com.yournote.database.dao.LabelDao
import com.yournote.database.dao.NoteCheckDao
import com.yournote.database.dao.NoteDao
import com.yournote.database.dao.NoteDrawingDao
import com.yournote.database.dao.NoteImageDao
import com.yournote.database.dao.NoteLabelDao
import com.yournote.database.dao.NoteNotificationDao
import com.yournote.database.dao.NoteVoiceDao
import com.yournote.database.model.LabelEntity
import com.yournote.database.model.NoteCheckEntity
import com.yournote.database.model.NoteDrawingEntity
import com.yournote.database.model.NoteEntity
import com.yournote.database.model.NoteImageEntity
import com.yournote.database.model.NoteLabelEntity
import com.yournote.database.model.NoteVoiceEntity
import com.yournote.database.model.NotificationEntity

@Database(
    entities = [
        NoteEntity::class,
        NoteVoiceEntity::class,
        NoteImageEntity::class,
        NoteCheckEntity::class,
        NoteLabelEntity::class,
        LabelEntity::class,
        NotificationEntity::class,
        NoteDrawingEntity::class,

    ],
    version = 5,
    autoMigrations = [
        AutoMigration(1, 2),
        AutoMigration(2, 3, NoteDatabase.Migrate2to3::class),
        AutoMigration(3, 4, NoteDatabase.Migrate3to4::class),
        AutoMigration(4, 5, NoteDatabase.Migrate4to5::class),

    ],
)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getLabelDao(): LabelDao

    abstract fun getNoteCheckDao(): NoteCheckDao

    abstract fun getNoteDao(): NoteDao

    abstract fun getNoteImageDao(): NoteImageDao

    abstract fun getNoteLabelDao(): NoteLabelDao

    abstract fun getNoteVoiceDao(): NoteVoiceDao

    abstract fun getNotification(): NoteNotificationDao

    abstract fun getNoteDrawingDao(): NoteDrawingDao

    @DeleteColumn(tableName = "note_image_table", columnName = "imageName")
    class Migrate2to3 : AutoMigrationSpec

    @DeleteColumn(tableName = "note_image_table", columnName = "imageName")
    class Migrate3to4 : AutoMigrationSpec

    @DeleteTable(tableName = "path_table")
    @DeleteColumn(tableName = "note_image_table", columnName = "timestamp")
    @DeleteColumn(tableName = "note_image_table", columnName = "isDrawing")
    @DeleteColumn(tableName = "note_table", columnName = "interval")
    @DeleteColumn(tableName = "note_table", columnName = "reminder")
    class Migrate4to5 : AutoMigrationSpec
}
