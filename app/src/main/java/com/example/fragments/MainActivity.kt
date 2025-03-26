package com.example.fragments

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
                    TimerCompos("Android")
                }
            }
        }
    }
}

@Composable
fun TimerCompos(name: String, modifier: Modifier = Modifier) {
    Column(){
        Button(onClick = { /*TODO*/ }) {
            Text(text = "22")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "33")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "44")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "55")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "55")
        }


    }
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun TimerComposPreview() {
    FragmentsTheme {
        TimerCompos("Android")
    }
}