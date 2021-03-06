package compose.view.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.Field
import compose.GameFieldState

@Suppress("FunctionNaming")
@Composable
internal fun FieldItem(
    field: Field,
    onClick: () -> Unit
) = Row(Modifier.clickable(onClick = onClick)) {
    Button(
        onClick = onClick,
        enabled = field.state == null,
    ) {
        Text(
            text = printButtonChar(field),
            modifier = Modifier.padding(10.dp),
            fontSize = 30.sp
        )
    }
}

fun printButtonChar(field: Field): String = when (field.state) {
    GameFieldState.Cross -> "+"
    GameFieldState.Zero -> "0"
    null -> "  "
}
