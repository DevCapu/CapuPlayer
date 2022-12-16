package br.com.devcapu.capu.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons.Default
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.devcapu.capu.ui.MusicUiState
import br.com.devcapu.capu.ui.theme.ForrestGreen

@Composable
fun Controller(
   state: MusicUiState
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
                    color = Color.White
                )
                Text(
                    text = state.artist,
                    style = MaterialTheme.typography.body1,
                    color = Color.White,
                    fontSize = 14.sp
                )
            }
            IconButton(
                onClick = state.onClickPlayButton,
                modifier = Modifier
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(percent = 50)
                    )
            ) {
                val image = if (state.isPlaying) {
                    Default.PlayArrow
                } else {
                    Default.Home
                }
                Icon(
                    imageVector = image,
                    null,
                    tint = ForrestGreen
                )
            }
        }
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp)
                .clip(shape = RoundedCornerShape(4.dp)),
            progress = 0.5f,
            backgroundColor = Color.White,
            color = ForrestGreen
        )
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun ControllerPreview() {
    Controller(
        state = MusicUiState(
            music = "Ela partiu | Capu remix",
            artist = "capu",
            isPlaying = true,
            onClickPlayButton = { }
        )
    )
}