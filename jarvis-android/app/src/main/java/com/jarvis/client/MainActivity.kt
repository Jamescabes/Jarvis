package com.jarvis.client

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jarvis.client.ui.ChatScreen
import com.jarvis.client.ui.HomeScreen
import com.jarvis.client.ui.theme.JarvisTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JarvisTheme {
                JarvisNavigation()
            }
        }
    }
}

@Composable
fun JarvisNavigation() {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onNavigateToChat = { navController.navigate("chat") },
                onNavigateToCall = { /* TODO: Implement Call */ },
                onNavigateToCamera = { /* TODO: Implement Camera */ }
            )
        }
        composable("chat") {
            ChatScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}
