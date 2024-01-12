package com.intive.compose.ui.recomposition.unstablelambda

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.intive.compose.ui.recomposition.CustomText
import com.intive.compose.ui.tools.LogCompositions
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class UnstableState(
    val list: List<Int>,
)

data class StableState(
    val list: ImmutableList<Int>,
)

@Composable
fun MainUnstableLambdaComponent() {
    var counter by remember { mutableIntStateOf(0) }

    val unstableState = remember { UnstableState(listOf(1)) }
    val stableState = remember { StableState(persistentListOf(1)) }

    LogCompositions(scope = "MainLambdaComponent")

    Column {
        Button(onClick = { counter++ }) {
            LogCompositions(scope = "Lambda passed to Button")

            CustomText(
                text = "Counter: $counter",
            )
        }

        UnstableLambdaComponent(
            logText = "UnstableLambdaComponent with unstable lambda",
            counter = -1, // -1,
            onClick = { unstableState }
        )

        UnstableLambdaComponent(
            logText = "UnstableLambdaComponent with stable lambda",
            counter = counter, // -1,
            onClick = { stableState }
        )
    }
}

@Composable
fun UnstableLambdaComponent(
    logText: String,
    counter: Int,
    onClick: () -> Unit,
) {
    LogCompositions(scope = logText)

    Button(onClick = onClick) {
        LogCompositions(scope = "Lambda passed to Button inside $logText")

        CustomText(
            logText = "CustomText inside $logText",
            text = "Counter: $counter",
        )
    }
}
