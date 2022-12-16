package br.com.devcapu.capu.ui.component

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons.Default
import androidx.compose.material.icons.filled.PauseCircleFilled
import androidx.compose.material.icons.filled.PlayCircleFilled
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.devcapu.capu.ui.MusicUiState
import br.com.devcapu.capu.ui.theme.CapuTheme
import br.com.devcapu.capu.ui.theme.ForrestGreen

@Composable
fun Controller(
    state: MusicUiState,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = state.music,
                    style = MaterialTheme.typography.body1,
                    color = White
                )
                Text(
                    text = state.artist,
                    style = MaterialTheme.typography.body1,
                    color = White,
                    fontSize = 14.sp
                )
            }
            IconButton(
                onClick = state.onClickPlayButton,
                modifier = Modifier
                    .background(
                        color = White,
                        shape = RoundedCornerShape(percent = 50)
                    )
            ) {
                val image = if (state.isPlaying) {
                    Default.PlayCircleFilled
                } else {
                    Default.PauseCircleFilled
                }
                Icon(
                    imageVector = image,
                    null,
                    tint = ForrestGreen
                )
            }
        }

        Slider(
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp)
                .clip(shape = RoundedCornerShape(4.dp)),
            valueRange = 0f..100f,
            colors = SliderDefaults.colors(
                thumbColor = ForrestGreen,
                disabledThumbColor = ForrestGreen.copy(alpha = .20f),
                activeTrackColor = White,
                inactiveTrackColor = White.copy(alpha = .20f)
            ),
            value = 50f,
            onValueChange = {}
        )
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ControllerPreview() {
    CapuTheme {
        Controller(
            state = MusicUiState(
                music = "Ela partiu | Capu remix",
                artist = "capu",
                isPlaying = true,
                onClickPlayButton = { }
            )
        )
    }
}