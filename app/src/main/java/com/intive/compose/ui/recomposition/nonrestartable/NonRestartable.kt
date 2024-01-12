package com.intive.compose.ui.recomposition.nonrestartable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.intive.compose.ui.recomposition.CustomText
import com.intive.compose.ui.tools.LogCompositions

@Composable
fun MainNonRestartableComponent() {
    LogCompositions(scope = "MainNonRestartableComponent")

    NonRestartableComponent()
}

@Composable
@NonRestartableComposable
fun NonRestartableComponent() {
    var counter by remember { mutableIntStateOf(0) }

    LogCompositions(scope = "NonRestartableComponent")

    CustomText(
        text = "Counter: $counter",
        modifier = Modifier.clickable {
            counter++
        },
    )
}
