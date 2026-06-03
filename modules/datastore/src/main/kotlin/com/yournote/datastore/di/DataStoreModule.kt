/*
 *abiola 2024
 */

package com.yournote.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.core.okio.OkioStorage
import com.yournote.common.network.di.ApplicationScope
import com.yournote.datastore.UserDataJsonSerializer
import com.yournote.model.UserData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import okio.FileSystem
import okio.Path.Companion.toPath
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    internal fun providesUserPreferencesDataStore(
        @ApplicationContext context: Context,
        @ApplicationScope scope: CoroutineScope,
        userPreferencesSerializer: UserDataJsonSerializer,
    ): DataStore<UserData> =
        DataStoreFactory.create(
            storage =
            OkioStorage(
                fileSystem = FileSystem.SYSTEM,
                serializer = userPreferencesSerializer,
                producePath = {
                    context.filesDir.resolve("userdata")
                        .absolutePath.toPath()
                },
            ),
        )
}
