package br.com.devcapu.capu.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

data class PlayerScreenUiState(
    val musicUiState: MusicUiState = MusicUiState(),
)

data class MusicUiState(
    val music: String = "belas",
    val artist: String = "eevee",
    var isPlaying: Boolean = false,
    val onClickPlayButton: () -> Unit = {},
)

class PlayerViewModel : ViewModel() {
    private var _state = MutableStateFlow(PlayerScreenUiState())
    val state: Flow<PlayerScreenUiState> = _state

    init {
        _state.value = _state.value.copy(
            musicUiState = _state.value.musicUiState.copy(
                onClickPlayButton = { playOrPauseMusic() }
            )
        )
    }

    private fun playOrPauseMusic() {
        _state.value = _state.value.copy(
            musicUiState = _state.value.musicUiState.copy(
                isPlaying = !_state.value.musicUiState.isPlaying
            )
        )
    }
}