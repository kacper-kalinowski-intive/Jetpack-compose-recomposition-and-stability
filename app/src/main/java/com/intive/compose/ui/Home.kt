package com.intive.compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.intive.compose.ui.navigation.Destinations

@Composable
fun Home(
    navigateTo: (String) -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
    ) {
        Text("Recomposition")
        Destinations.recomposition.forEach {
            Button(onClick = { navigateTo(it) }) {
                Text(
                    text = it.uppercase(),
                )
            }
        }
        Text("Phases", Modifier.padding(top = 20.dp))
        Destinations.phases.forEach {
            Button(onClick = { navigateTo(it) }) {
                Text(
                    text = it.uppercase(),
                )
            }
        }
    }
}