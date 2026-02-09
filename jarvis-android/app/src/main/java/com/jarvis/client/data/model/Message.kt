package com.jarvis.client.data.model

import java.util.UUID

data class Message(
    val id: String = UUID.randomUUID().toString(),
    val senderId: String,
    val type: MessageType = MessageType.TEXT,
    val content: String,
    val timestamp: Long = System.currentTimeMillis(),
    val status: MessageStatus = MessageStatus.SENT
)

enum class MessageType { TEXT, IMAGE, VIDEO, AUDIO, FILE }
enum class MessageStatus { SENDING, SENT, DELIVERED, READ }
