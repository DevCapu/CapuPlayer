@file:OptIn(ExperimentalMaterialApi::class, ExperimentalMaterialApi::class)

package br.com.devcapu.capu

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.BottomSheetValue.Expanded
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.devcapu.capu.ui.MusicUiState
import br.com.devcapu.capu.ui.PlayerScreenUiState
import br.com.devcapu.capu.ui.PlayerViewModel
import br.com.devcapu.capu.ui.component.PlayingNowMusic
import br.com.devcapu.capu.ui.component.SoundsToggles
import br.com.devcapu.capu.ui.theme.CapuTheme

class MainActivity : ComponentActivity() {

    //region Lifecycles
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CapuTheme {
                PlayerScreen()
            }
        }
    }
    //endregion

    //region Composables
    @Composable
    private fun PlayerScreen(viewModel: PlayerViewModel = viewModel()) {
        val state = viewModel.state.collectAsState(initial = PlayerScreenUiState())
        val bottomSheetState = rememberBottomSheetScaffoldState(
            bottomSheetState = BottomSheetState(
                initialValue = Expanded,
                confirmStateChange = { false }
            )
        )

        if (bottomSheetState.bottomSheetState.isCollapsed) {
            LaunchedEffect(null) {
                bottomSheetState.bottomSheetState.expand()
            }
        }
        PlayerContent(
            bottomSheetScaffoldState = bottomSheetState,
            state = state.value
        )
    }
    //endregion
}

@Composable
private fun PlayerContent(
    bottomSheetScaffoldState: BottomSheetScaffoldState,
    state: PlayerScreenUiState,
) {
    BottomSheetScaffold(
        sheetContent = { SoundsToggles() },
        scaffoldState = bottomSheetScaffoldState,
        sheetBackgroundColor = colors.background,
        sheetGesturesEnabled = false,
    ) {
        PlayingNowMusic(state = state.musicUiState)
    }
}

@Preview(showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PlayerScreenPreview() {
    CapuTheme {
        PlayerContent(
            bottomSheetScaffoldState = rememberBottomSheetScaffoldState(),
            state = PlayerScreenUiState(
                musicUiState = MusicUiState(
                    music = "Belas",
                    artist = "eevee",
                    isPlaying = true,
                    onClickPlayButton = {}
                )
            )
        )
    }
}