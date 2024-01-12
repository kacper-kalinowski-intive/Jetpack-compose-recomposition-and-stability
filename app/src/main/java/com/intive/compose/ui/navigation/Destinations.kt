package com.intive.compose.ui.navigation

object Destinations {
    const val HOME_ROUTE = "home"
    const val BASE_ROUTE = "base"
    const val NON_RESTARTABLE_ROUTE = "non restartable"
    const val LAMBDA_ROUTE = "lambda"
    const val LAMBDA_EXPANDED_ROUTE = "lambda expanded"
    const val LAMBDA_CLOSURE_ROUTE = "lambda closure"
    const val UNSTABLE_LAMBDA_ROUTE = "unstable lambda"
    const val COMPOSITION_ROUTE = "composition"
    const val LAYOUT_ROUTE = "layout"
    const val DRAW_ROUTE = "draw"

    val recomposition = listOf(
        BASE_ROUTE,
        NON_RESTARTABLE_ROUTE,
        LAMBDA_ROUTE,
        LAMBDA_EXPANDED_ROUTE,
        LAMBDA_CLOSURE_ROUTE,
        UNSTABLE_LAMBDA_ROUTE,
    )
    val phases = listOf(
        COMPOSITION_ROUTE,
        LAYOUT_ROUTE,
        DRAW_ROUTE,
    )
}
