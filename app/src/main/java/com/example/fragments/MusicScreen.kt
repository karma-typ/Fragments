package com.example.fragments

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class TrackInfo(val name: String, val author: String, val albumPicker: Int)

@Preview
@Composable
fun TrackCompos(trackInfo: TrackInfo = TrackInfo("Алкоритм", "Научно-технический рэп", R.mipmap.x1666)){
    Row (Modifier.height(56.dp)){
        Image(
            ImageBitmap.imageResource(id = trackInfo.albumPicker),
            "Album Picker",
            modifier = Modifier
                .size(56.dp)
                .clip(RoundedCornerShape(4.dp))
        )
        Column(Modifier.padding(5.dp)){
            Text(text = trackInfo.name, fontSize = 15.sp)
            Text(text = trackInfo.author, fontSize = 10.sp, modifier = Modifier.alpha(0.5F))
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = { /*TODO*/ }, Modifier.size(30.dp, 56.dp)) {

        }
        Button(onClick = { /*TODO*/ }, Modifier.size(30.dp, 56.dp)) {

        }
    }
}

@Composable
fun ScreenMusicCompos(tracks: List<TrackInfo> = listOf(TrackInfo("Тилибом", "Научно-технический рэп", R.mipmap.x1666),
                                                        TrackInfo("Два стула", "Научно-технический рэп", R.mipmap.x1666),
                                                        TrackInfo("Безответственной ненависти гимн", "Научно-технический рэп", R.mipmap.x1666),
                                                        TrackInfo("Тульпа", "Научно-технический рэп", R.mipmap.x1666),
                                                        TrackInfo("Кернел паника", "Научно-технический рэп", R.mipmap.x1666),
                                                        TrackInfo("Тыжпрограммист едет за солью", "Научно-технический рэп", R.mipmap.x1666),
                                                        TrackInfo("Алкоритм", "Научно-технический рэп", R.mipmap.x1666),
                                                        TrackInfo("MVP", "Научно-технический рэп", R.mipmap.x1666),
                                                        TrackInfo("Джанго это я", "Научно-технический рэп", R.mipmap.x1666),
                                                        TrackInfo("А ты хорош", "Научно-технический рэп", R.mipmap.x1666) )) {
    val searchText: MutableState<String> = remember { mutableStateOf("") }
    Column {
        TextField(value = searchText.value, onValueChange = {searchText.value = it}, placeholder = { Text( "222")}, modifier = Modifier.fillMaxWidth(), singleLine = true)
        LazyColumn {
            items(tracks){
                TrackCompos(it)
            }
        }




    }
}