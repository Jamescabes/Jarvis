package com.jarvis.client.data.repository

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ChatRepository @Inject constructor(
    private val client: OkHttpClient
) {
    private var webSocket: WebSocket? = null
    private val _messages = MutableStateFlow<List<String>>(emptyList())
    val messages: StateFlow<List<String>> = _messages

    fun connect() {
        val request = Request.Builder().url("ws://10.0.2.2:8000/ws").build()
        val listener = object : WebSocketListener() {
            override fun onMessage(webSocket: WebSocket, text: String) {
                // Determine if it's user or system message based on parsing (simplified here)
                val current = _messages.value.toMutableList()
                current.add(text) 
                _messages.value = current
            }
            
            override fun onFailure(webSocket: WebSocket, t: Throwable, response: okhttp3.Response?) {
                println("Error: ${t.message}")
            }
        }
        webSocket = client.newWebSocket(request, listener)
    }

    fun sendMessage(text: String) {
        webSocket?.send(text)
    }
}
