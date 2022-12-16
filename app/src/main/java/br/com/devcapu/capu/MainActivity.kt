@file:OptIn(ExperimentalMaterialApi::class, ExperimentalMaterialApi::class)

package br.com.devcapu.capu

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.BottomSheetValue.Expanded
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale.Companion.FillWidth
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.devcapu.capu.ui.component.Controller
import br.com.devcapu.capu.ui.component.SoundsToggles
import br.com.devcapu.capu.ui.theme.CapuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
            CapuTheme {
                BottomSheetScaffold(
                    sheetContent = {
                        Box(
                            modifier = Modifier.fillMaxHeight(0.5f)
                        ) { SoundsToggles() }
                    },
                    scaffoldState = bottomSheetState,
                    sheetBackgroundColor = MaterialTheme.colors.background,
                    sheetGesturesEnabled = false,
                    sheetPeekHeight = 150.dp,
                ) {
                    Scaffold(
                        backgroundColor = MaterialTheme.colors.background
                    ) {
                        LazyColumn(
                            modifier = Modifier
                                .padding(it)
                                .fillMaxHeight(0.5f)
                                .fillMaxWidth()
                                .background(MaterialTheme.colors.background),
                        ) {
                            item {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .fillParentMaxHeight()
                                ) {
                                    Image(
                                        modifier = Modifier.fillMaxWidth(),
                                        painter = painterResource(id = R.drawable.lofi_background),
                                        contentDescription = "32 bit image of a room with a window",
                                        contentScale = FillWidth
                                    )
                                    Surface(
                                        modifier = Modifier.align(BottomCenter),
                                        color = MaterialTheme.colors.background.copy(alpha = 0.75f)
                                    ) {
                                        Controller(
                                            music = "Ela partiu",
                                            artist = "Tim Maia - Bdexx Remix",
                                            isPlaying = false,
                                            onClickPlayerButton = { }
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PlayerScreenPreview() {
    CapuTheme {
//        PlayerScreen()
    }
}