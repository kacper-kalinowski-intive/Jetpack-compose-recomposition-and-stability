package com.intive.compose.ui.phases

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@Composable
fun Layout() {
    val offset by animateValueBetween(-100, 100)

    Column {
        Text("Normal text")
        Text(
            "Text with offset",
            Modifier.offset { IntOffset(0, offset.toInt()) } // DO
            //Modifier.offset(y = offset.toInt().dp) // DONT
        )
    }
}

@Composable
fun animateValueBetween(start: Int, end: Int): State<Float> {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    return infiniteTransition.animateFloat(
        initialValue = start.toFloat(),
        targetValue = end.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )
}

