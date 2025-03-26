package com.example.fragments

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fragments.ui.theme.FragmentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FragmentsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ScreenTimerCompos("Android")
                }
            }
        }
    }
}


@Composable
fun ScreenTimerCompos(name: String, modifier: Modifier = Modifier) {
    var f: Float = 0.75F
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator(
                modifier = Modifier.size(150.dp),
                progress = f,
                color = Color.Black,
                )
            Text(
                text = "05:00",
                //modifier = modifier
            )
        }
        Row(){
            Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(horizontal = 15.dp)) {
                Text(text = "||")

            }
            Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(horizontal = 15.dp)) {
                Text(text = "R")
            }
        }

    }
    /*Text(
        text = "Hello $name!",
        modifier = modifier
    )*/
}

@Preview(showBackground = true)
@Composable
fun TimerComposPreview() {
    FragmentsTheme {
        ScreenTimerCompos("0.75F")
    }
}