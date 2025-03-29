package com.example.fragments

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fragments.ui.theme.FragmentsTheme

enum class ScreenType{
    ScreenTimer, ScreenMusic
}

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val screenType = ScreenType.ScreenTimer


        setContent {
            FragmentsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    ScreenDefaultCompos(screenType, this)

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TimerComposPreview() {
    FragmentsTheme {
        ScreenMusicCompos()
    }
}

@Composable
fun ScreenDefaultCompos(_screenType: ScreenType, context: Context) {
    val screenType: MutableState<ScreenType> = remember { mutableStateOf(_screenType) }
    val isScreensVisible: MutableState<Boolean> = remember { mutableStateOf(false) }

    Column (
        horizontalAlignment = if(isScreensVisible.value)
            Alignment.Start
        else
            Alignment.End
    ){
        Row {
            Button(onClick = { isScreensVisible.value =!isScreensVisible.value },
                Modifier.size(70.dp, 40.dp)) {
                Text(
                    if (isScreensVisible.value)
                        "⭆"
                    else
                        "⭅"
                )
            }
            if(isScreensVisible.value) {
                Button(onClick = { screenType.value = ScreenType.ScreenTimer },
                    Modifier.size(70.dp, 40.dp)) {
                    Text("⏱\uFE0E")
                }
                Button(onClick = { screenType.value = ScreenType.ScreenMusic },
                    Modifier.size(70.dp, 40.dp)) {
                    Text("♫")
                }
                Button(onClick = { /*TODO*/ },
                    Modifier.size(70.dp, 40.dp)) {
                    Text("3")
                }
                Button(onClick = { /*TODO*/ },
                    Modifier.size(70.dp, 40.dp)) {
                    Text("4")
                }
            }
        }
        Spacer(modifier = Modifier.windowInsetsTopHeight(WindowInsets.statusBars))

        when(screenType.value){
            ScreenType.ScreenTimer -> ScreenTimerCompos(context)
            ScreenType.ScreenMusic -> ScreenMusicCompos()
        }


    }


}