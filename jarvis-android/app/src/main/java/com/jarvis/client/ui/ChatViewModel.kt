package com.jarvis.client.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jarvis.client.data.repository.ChatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val repository: ChatRepository
) : ViewModel() {
    val messages = repository.messages

    init {
        repository.connect()
    }

    fun sendMessage(text: String) {
        viewModelScope.launch {
            repository.sendMessage(text)
        }
    }
}
