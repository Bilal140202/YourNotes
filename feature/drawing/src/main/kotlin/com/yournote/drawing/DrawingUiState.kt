package com.yournote.drawing

import com.yournote.model.DrawingPath

data class DrawingUiState(
    val drawingId: Long? = null,
    val drawings: List<DrawingPath> = emptyList(),
)
