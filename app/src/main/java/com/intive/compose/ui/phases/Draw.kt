package com.intive.compose.ui.phases

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color

@Composable
fun Draw() {
    val animation by animateColorBetween(Color.Red, Color.Magenta)

    Column {
        Text("Normal text")
        Text(
            "Text with offset",
            Modifier.drawBehind { drawRect(animation) } // DO
            //Modifier.background(animation) // DONT
        )
    }
}

@Composable
fun animateColorBetween(start: Color, end: Color): State<Color> {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    return infiniteTransition.animateColor(
        initialValue = start,
        targetValue = end,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )
}
