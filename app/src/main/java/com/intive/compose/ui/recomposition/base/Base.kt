package com.intive.compose.ui.recomposition.base

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.intive.compose.ui.recomposition.CustomText
import com.intive.compose.ui.tools.LogCompositions

@Composable
fun MainBaseComponent() {
    var counter by remember { mutableIntStateOf(0) }

    LogCompositions(scope = "BaseComponent")

    CustomText(
        text = "Counter: $counter",
        modifier = Modifier.clickable {
            counter++
        },
    )
}
