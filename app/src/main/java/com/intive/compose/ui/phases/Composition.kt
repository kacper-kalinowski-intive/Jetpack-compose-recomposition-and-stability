package com.intive.compose.ui.phases

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Composition() {
    var text by remember { mutableStateOf("Composable1") }

    Column {
        if (text == "Composable1") {
            Composable1(
                onClick = {
                    text = "Composable2"
                })
        } else {
            Composable2(
                onClick = {
                    text = "Composable1"
                }
            )
        }
        Text("Some other text")
    }
}

@Composable
fun Composable1(onClick: () -> Unit) {
    Column {
        Box(
            modifier = Modifier
                .background(Color.Red)
                .size(50.dp)
        )
        Button(
            onClick = onClick,
        ) {
            Text("Composable1")
        }
    }
}

@Composable
fun Composable2(onClick: () -> Unit) {
    Column {
        Button(
            onClick = onClick,
        ) {
            Text("Composable2")
        }
        Text("Some additional text")
    }
}
