package com.intive.compose.ui.tools

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember

class Ref(var value: Int)

@Composable
inline fun LogCompositions(scope: String) {
    val ref = remember { Ref(0) }
    SideEffect {
        println("Compositions: $scope ${++ref.value}")
    }
}
