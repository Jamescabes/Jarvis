package com.jarvis.client.data.repository

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

import com.jarvis.client.data.model.Message
import com.jarvis.client.data.model.MessageType
import com.jarvis.client.data.model.MessageStatus

class ChatRepository @Inject constructor(
    private val client: OkHttpClient
) {
    private var webSocket: WebSocket? = null
    private val _messages = MutableStateFlow<List<Message>>(emptyList())
    val messages: StateFlow<List<Message>> = _messages

    fun connect() {
        val request = Request.Builder().url("ws://10.0.2.2:8000/ws").build()
        val listener = object : WebSocketListener() {
            override fun onMessage(webSocket: WebSocket, text: String) {
                // Incoming messages from WebSocket are from Jarvis
                val current = _messages.value.toMutableList()
                current.add(
                    Message(
                        senderId = "jarvis",
                        content = text,
                        type = MessageType.TEXT,
                        status = MessageStatus.DELIVERED
                    )
                ) 
                _messages.value = current
            }
            
            override fun onFailure(webSocket: WebSocket, t: Throwable, response: okhttp3.Response?) {
                println("Error: ${t.message}")
            }
        }
        webSocket = client.newWebSocket(request, listener)
    }

    fun sendMessage(text: String) {
        // Optimistically add user message
        val current = _messages.value.toMutableList()
        current.add(
            Message(
                senderId = "user",
                content = text,
                type = MessageType.TEXT,
                status = MessageStatus.SENDING
            )
        )
        _messages.value = current
        
        webSocket?.send(text)
    }
}
