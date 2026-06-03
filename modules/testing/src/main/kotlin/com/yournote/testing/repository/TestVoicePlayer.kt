package com.yournote.testing.repository

import com.yournote.common.INotePlayer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class TestVoicePlayer : INotePlayer {
    override fun playMusic(path: String, position: Int): Flow<Int> {
        return flowOf(0)
    }

    override fun pause() {
    }
}
