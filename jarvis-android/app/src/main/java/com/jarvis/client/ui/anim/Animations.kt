package com.jarvis.client.ui.anim

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.ui.unit.IntOffset

object JarvisAnimations {
    // Easing: cubic-bezier(0.4, 0.0, 0.2, 1)
    val Easing = CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f)

    // Message Incoming: Slide Up + Fade
    // Duration: 180ms
    fun enterMessage() = slideInVertically(
        initialOffsetY = { 20 }, // TranslateY: 20
        animationSpec = tween(durationMillis = 180, easing = Easing)
    ) + fadeIn(
        animationSpec = tween(durationMillis = 180, easing = Easing)
    )
    
    // Voice Record: Pulsing scale (1 -> 1.2)
    // Duration: 220ms, Loop: true
    // This will be implemented via infiniteTransition in the composable
}
