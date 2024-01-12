package com.intive.compose.ui.recomposition

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.intive.compose.ui.tools.LogCompositions

@Composable
fun CustomText(
    text: String,
    modifier: Modifier = Modifier,
    logText: String = "CustomText",
) {
    LogCompositions(scope = logText)

    Text(
        text = text,
        modifier = modifier.padding(32.dp),
        style = TextStyle(
            fontSize = 20.sp,
            textDecoration = TextDecoration.Underline,
            fontFamily = FontFamily.Monospace,
        )
    )
}
