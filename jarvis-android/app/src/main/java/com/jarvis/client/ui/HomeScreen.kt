package com.jarvis.client.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    onNavigateToChat: () -> Unit,
    onNavigateToCall: () -> Unit,
    onNavigateToCamera: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "J.A.R.V.I.S.",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 48.dp)
        )

        JarvisMenuButton(
            text = "Open Chat",
            icon = Icons.Default.Chat,
            onClick = onNavigateToChat
        )
        
        Spacer(modifier = Modifier.height(24.dp))

        JarvisMenuButton(
            text = "Call System",
            icon = Icons.Default.Call,
            onClick = onNavigateToCall
        )

        Spacer(modifier = Modifier.height(24.dp))

        JarvisMenuButton(
            text = "Visual Sensors",
            icon = Icons.Default.Videocam,
            onClick = onNavigateToCamera
        )
    }
}

@Composable
fun JarvisMenuButton(
    text: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        shape = CircleShape,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = MaterialTheme.colorScheme.primary
        ),
        border = ButtonDefaults.outlinedButtonBorder.copy(
            brush = androidx.compose.ui.graphics.SolidColor(MaterialTheme.colorScheme.primary)
        )
    ) {
        Icon(icon, contentDescription = null, modifier = Modifier.size(32.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = text, fontSize = 20.sp, fontWeight = FontWeight.Medium)
    }
}
