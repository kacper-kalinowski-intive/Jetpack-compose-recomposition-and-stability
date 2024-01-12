package com.intive.compose.ui.recomposition.lambdascopeclosure

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.intive.compose.ui.recomposition.CustomText
import com.intive.compose.ui.tools.LogCompositions

@Composable
fun MainLambdaClosureComponent() {
    var counter by remember { mutableIntStateOf(0) }

    val text = "With Closure"

    LogCompositions(scope = "MainLambdaExpandedComponent")

    //counter // state read MainLambdaExpandedComponent

    Column {
        Button(
            onClick = { counter++ },
        ) {
            LogCompositions(scope = "Lambda passed to Button")

            CustomText(
                text = "Counter: $counter",
            )
        }

        LambdaClosureComponent("Outer LambdaWithClosureComponent") {
            LogCompositions(scope = "Lambda passed to Outer LambdaWithClosureComponent")

            //counter // state read Outer LambdaWithClosureComponent

            CustomText(
                text = text, // closure on "text" variable
                logText = "Outer CustomTextWithClosure",
            )

            LambdaClosureComponent("Inner LambdaWithClosureComponent") {
                LogCompositions(scope = "Lambda passed to Inner LambdaWithClosureComponent")

                counter // state read Inner LambdaWithClosureComponent

                CustomText(
                    text = text, // closure on "text" variable
                    logText = "Inner CustomTextWithClosure",
                )
            }
        }

        LambdaClosureComponent("Outer LambdaWithoutClosureComponent") {
            LogCompositions(scope = "Lambda passed to Outer LambdaWithoutClosureComponent")

            //counter // state read Outer LambdaWithoutClosureComponent

            CustomText(
                text = "Outer Without Closure",
                logText = "Outer CustomTextWithoutClosure",
            )

            LambdaClosureComponent("Inner LambdaWithoutClosureComponent" ) {
                LogCompositions(scope = "Lambda passed to Inner LambdaWithoutClosureComponent")

                //counter // state read Inner LambdaWithoutClosureComponent

                CustomText(
                    text = "Inner Without Closure",
                    logText = "Inner CustomTextWithoutClosure",
                )
            }
        }
    }
}

@Composable
fun LambdaClosureComponent(
    logText: String,
    content: @Composable () -> Unit,
) {
    LogCompositions(scope = logText)

    content()
}
