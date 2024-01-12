package com.intive.compose.ui.stability

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.collections.immutable.ImmutableList

@Composable
fun StableComponent(
    boolean: Boolean,
    string: String,
    char: Char,
    int: Int,
    long: Long,
    float: Float,
    lambdaWithoutParam: () -> Unit,
    lambdaWithParam: (String) -> String,
) {
    boolean
    string
    char
    int
    long
    float
    lambdaWithParam
    lambdaWithoutParam
    // Implementation
}


data class Unstable(var unstableParameter: Int)

@Composable
fun UnstableComponent(
    unstable: Unstable,
) {
    unstable
    // Implementation
}

@Composable
fun UnstableListComponent(
    unstableList: List<Int>,
) {
    unstableList
    // Implementation
}


// We can force stability
@Stable
data class ForcedStable(var unstableParameter: Int)

@Composable
fun ForcedStableComponent(
    forcedStable: ForcedStable,
) {
    forcedStable
    // Implementation
}

@Stable
data class ForcedStableList<T>(val unstableList: List<T>)
/* or */
@Immutable
data class ForcesImmutableList<T>(val unstableList: List<T>)

@Composable
fun StableListComponent(
    forcedStableList: ForcedStableList<Int>,
    forcesImmutableList: ForcesImmutableList<Int>,
    immutableList: ImmutableList<Int>,
) {
    forcedStableList
    forcesImmutableList
    immutableList
    // Implementation
}


// If we want mutability
@Stable
class MyStateHolder {
    var isLoading by mutableStateOf(false)
}


// Enum Class Stability
enum class EnumClass {
    ONE, TWO, THREE
}

@Composable
fun EnumComponent(
    enum: EnumClass
) {
    enum
    // Implementation
}