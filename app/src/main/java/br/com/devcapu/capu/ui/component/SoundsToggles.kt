package br.com.devcapu.capu.ui.component

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.devcapu.capu.ui.theme.CapuTheme
import br.com.devcapu.capu.ui.theme.ForrestGreen

@Composable
fun SoundsToggles() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Toggle(
                label = "Pessoas",
                checked = false,
                onCheckedChange = { }
            )
        }
        item {
            Toggle(
                label = "Lareira",
                checked = false,
                onCheckedChange = { }
            )
        }

        item {
            Toggle(
                label = "Vento",
                checked = false,
                onCheckedChange = { }
            )
        }

        item {
            Toggle(
                label = "Chuva",
                checked = false,
                onCheckedChange = { }
            )
        }

        item {
            Toggle(
                label = "Floresta",
                checked = false,
                onCheckedChange = { }
            )
        }
    }
}

@Composable
private fun Toggle(
    label: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.body1
            )
            Switch(
                checked = checked,
                onCheckedChange = onCheckedChange,
                colors = SwitchDefaults.colors(
                    checkedThumbColor = White,
                    checkedTrackColor = ForrestGreen,
                    uncheckedThumbColor = ForrestGreen,
                    uncheckedTrackColor = White
                ),
            )
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun SoundsTogglesPreviews() {
    CapuTheme { SoundsToggles() }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun TogglePreview() {
    CapuTheme {
        Toggle(label = "Chuva", checked = false, onCheckedChange = {})
    }
}