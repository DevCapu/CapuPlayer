package br.com.devcapu.capu

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SwitchDefaults.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale.Companion.FillWidth
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.devcapu.capu.ui.theme.CapuTheme
import br.com.devcapu.capu.ui.theme.ForrestGreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CapuTheme { PlayerScreen() }
        }
    }
}

@Composable
fun PlayerScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillParentMaxHeight(0.5f)
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
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text(
                                    text = "Gostava tanto de você",
                                    style = MaterialTheme.typography.body1,
                                    color = White
                                )
                                Text(
                                    text = "Tim Maia - Bdexx Remix",
                                    style = MaterialTheme.typography.body1,
                                    color = White,
                                    fontSize = 14.sp
                                )
                            }
                            IconButton(
                                onClick = { /*TODO*/ },
                                modifier = Modifier
                                    .background(
                                        color = White,
                                        shape = RoundedCornerShape(percent = 50)
                                    )
                            ) {
                                Icon(
                                    imageVector = Icons.Default.PlayArrow,
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
                            backgroundColor = White,
                            color = ForrestGreen
                        )
                    }
                }
            }
        }

        item {
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
                        text = "Pessoas",
                        style = MaterialTheme.typography.body1
                    )
                    Switch(
                        checked = true,
                        onCheckedChange = {},
                        colors = colors(
                            checkedThumbColor = White,
                            checkedTrackColor = ForrestGreen,
                            uncheckedThumbColor = ForrestGreen,
                            uncheckedTrackColor = White
                        ),
                    )
                }
            }
        }
    }
}

@Preview(
    showSystemUi = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun PlayerScreenPreview() {
    CapuTheme {
        PlayerScreen()
    }
}