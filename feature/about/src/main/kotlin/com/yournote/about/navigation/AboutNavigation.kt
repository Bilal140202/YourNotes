package com.yournote.about.navigation

import android.util.Log
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import com.yournote.about.AboutScreen
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
fun EntryProviderBuilder<NavKey>.aboutScreen(onBack: () -> Unit) {
    entry<AboutArg> {
        val context = LocalContext.current
        var lastUpdate by remember {
            mutableStateOf("")
        }
        var version by remember {
            mutableStateOf("1.0.0")
        }
        LaunchedEffect(
            key1 = Unit,
            block = {
                try {
                    val pInfo = context.packageManager.getPackageInfo(context.packageName, 0)
                    version = pInfo.versionName ?: "1.0.0"
                    if (pInfo.lastUpdateTime > 0) {
                        val datetime = Instant.fromEpochMilliseconds(pInfo.lastUpdateTime)
                            .toLocalDateTime(TimeZone.currentSystemDefault()).date
                        lastUpdate = "${datetime.dayOfMonth} ${
                            datetime.month.name.lowercase().replaceFirstChar { it.uppercaseChar() }
                        } ${datetime.year}"
                    } else {
                        lastUpdate = "New Install"
                    }
                } catch (e: Exception) {
                    Log.e("AboutScreen", "Error loading app info", e)
                    version = "1.0.0"
                    lastUpdate = "New Install"
                }
            },
        )

        AboutScreen(
            onBack = onBack,
            lastUpdate = lastUpdate,
            version = version,
        )
    }
}

fun NavBackStack.navigateToAbout() {
    add(AboutArg)
}
