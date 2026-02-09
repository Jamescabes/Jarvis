package com.jarvis.client.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jarvis.client.data.model.Message
import com.jarvis.client.ui.theme.JarvisTheme
import androidx.compose.animation.AnimatedVisibility
import com.jarvis.client.ui.anim.JarvisAnimations
import androidx.compose.animation.core.*
import androidx.compose.ui.draw.scale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(
    viewModel: ChatViewModel = hiltViewModel(),
    onNavigateBack: () -> Unit
) {
    val messages by viewModel.messages.collectAsState()
    var inputText by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    // Voice record state for animation
    var isRecording by remember { mutableStateOf(false) }

    // Smart Scroll: Scroll to bottom when new messages arrive
    LaunchedEffect(messages.size) {
        if (messages.isNotEmpty()) {
            listState.animateScrollToItem(messages.size - 1)
        }
    }

    JarvisTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("J.A.R.V.I.S.", style = MaterialTheme.typography.titleLarge) },
                    navigationIcon = {
                        IconButton(onClick = onNavigateBack) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = MaterialTheme.colorScheme.primary)
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.background,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                        navigationIconContentColor = MaterialTheme.colorScheme.primary
                    )
                )
            },
            bottomBar = {
                InputBar(
                    text = inputText,
                    onTextChanged = { inputText = it },
                    onSend = {
                        if (inputText.isNotBlank()) {
                            viewModel.sendMessage(inputText)
                            inputText = ""
                        }
                    },
                    isRecording = isRecording,
                    onRecordToggle = { isRecording = !isRecording }
                )
            }
        ) { paddingValues ->
            LazyColumn(
                state = listState,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(MaterialTheme.colorScheme.background)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(vertical = 16.dp)
            ) {
                items(
                    items = messages,
                    key = { it.id }
                ) { msg ->
                    // Animated Entry
                    AnimatedVisibility(
                        visible = true, // Always true once added
                        enter = JarvisAnimations.enterMessage()
                    ) {
                        MessageBubble(message = msg)
                    }
                }
            }
        }
    }
}

@Composable
fun InputBar(
    text: String,
    onTextChanged: (String) -> Unit,
    onSend: () -> Unit,
    isRecording: Boolean,
    onRecordToggle: () -> Unit
) {
    // Pulse animation for recording
    val infiniteTransition = rememberInfiniteTransition(label = "voiceRecord")
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = if (isRecording) 1.2f else 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(220, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scale"
    )
    val glowColor = if (isRecording) com.jarvis.client.ui.theme.JarvisBlue else Color.Transparent

    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Mic Button
        IconButton(
            onClick = onRecordToggle,
            modifier = Modifier
                .scale(if (isRecording) scale else 1f)
                .background(if (isRecording) glowColor.copy(alpha = 0.2f) else Color.Transparent, shape = RoundedCornerShape(50))
        ) {
            Icon(
                Icons.Default.Mic, 
                contentDescription = "Voice Input", 
                tint = if (isRecording) com.jarvis.client.ui.theme.JarvisBlue else MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        TextField(
            value = text,
            onValueChange = onTextChanged,
            modifier = Modifier.weight(1f),
            placeholder = { Text("Type a message...", color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f)) },
            shape = RoundedCornerShape(24.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedTextColor = MaterialTheme.colorScheme.onBackground,
                unfocusedTextColor = MaterialTheme.colorScheme.onBackground
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            onClick = onSend,
            modifier = Modifier.height(56.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {
            Text("Send", style = MaterialTheme.typography.labelLarge)
        }
    }
}

@Composable
fun MessageBubble(message: Message) {
    val isUser = message.senderId == "user"
    val alignment = if (isUser) Alignment.CenterEnd else Alignment.CenterStart
    val backgroundColor = if (isUser) com.jarvis.client.ui.theme.OutgoingBubble else com.jarvis.client.ui.theme.IncomingBubble
    val contentColor = MaterialTheme.colorScheme.onSurface
    val shape = if (isUser) {
        RoundedCornerShape(16.dp, 16.dp, 4.dp, 16.dp)
    } else {
        RoundedCornerShape(16.dp, 16.dp, 16.dp, 4.dp)
    }

    Box(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        contentAlignment = alignment
    ) {
        Surface(
            color = backgroundColor,
            contentColor = contentColor,
            shape = shape,
            shadowElevation = 4.dp,
            border = null // No border for cleaner look, or maybe subtle border
        ) {
            Text(
                text = message.content,
                modifier = Modifier.padding(12.dp),
                style = MaterialTheme.typography.bodyLarge,
                color = if (isUser) com.jarvis.client.ui.theme.JarvisBlue else Color.White // Text color contrast
            )
        }
    }
}
