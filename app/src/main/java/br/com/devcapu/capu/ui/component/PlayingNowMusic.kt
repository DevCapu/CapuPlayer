package br.com.devcapu.capu.ui.component

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.devcapu.capu.R
import br.com.devcapu.capu.ui.MusicUiState

@Composable
fun PlayingNowMusic(state: MusicUiState) {
    Scaffold(backgroundColor = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxHeight(0.5f)
                .fillMaxWidth()
                .background(MaterialTheme.colors.background),
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(id = R.drawable.lofi_background),
                    contentDescription = "32 bit image of a room with a window",
                    contentScale = ContentScale.FillWidth
                )
                Surface(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    color = MaterialTheme.colors.background.copy(alpha = 0.75f)
                ) { Controller(state = state) }
            }
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun PlayingNowMusicPreview() {
    PlayingNowMusic(
        state = MusicUiState(
            music = "Belas",
            artist = "eevee",
            isPlaying = true,
            onClickPlayButton = {}
        )
    )

}