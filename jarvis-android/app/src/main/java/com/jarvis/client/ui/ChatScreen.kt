package com.jarvis.client.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ChatScreen(viewModel: ChatViewModel = viewModel()) {
    val messages by viewModel.messages.collectAsState()
    var inputText by remember { mutableStateOf("") }

    Column {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(messages) { msg ->
                Text(text = msg)
            }
        }
        
        Row {
            TextField(
                value = inputText,
                onValueChange = { inputText = it },
                modifier = Modifier.weight(1f)
            )
            Button(onClick = { 
                viewModel.sendMessage(inputText)
                inputText = ""
            }) {
                Text("Send")
            }
        }
    }
}
