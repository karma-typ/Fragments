package com.example.fragments

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun TrackCompos(){
    Row {
        Button(onClick = { /*TODO*/ }) {

        }
        Text("text =12234")
        Switch(checked = true, onCheckedChange = {})
    }
}

@Composable
fun ScreenMusicCompos() {
    LazyColumn {
        //items(TrackCompos())

    }
}