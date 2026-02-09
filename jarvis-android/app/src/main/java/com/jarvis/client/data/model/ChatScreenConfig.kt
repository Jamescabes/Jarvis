package com.jarvis.client.data.model

data class ChatScreenConfig(
    val headerHeight: Int = 64, // dp
    val maxBubbleWidthPercent: Float = 0.75f,
    val inputBarMinHeight: Int = 56, // dp
    val supportsVoice: Boolean = true,
    val supportsMedia: Boolean = true
)
