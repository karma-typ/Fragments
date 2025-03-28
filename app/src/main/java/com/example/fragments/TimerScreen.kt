package com.example.fragments

import android.content.Context
import android.os.CountDownTimer
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Date

@Composable
fun ScreenTimerCompos(context: Context) {

    val startTime: MutableState<Long> = remember { mutableLongStateOf(-1) }
    val stopTime: MutableState<Long> = remember { mutableLongStateOf(-1) }
    val unRunTime: MutableState<Long> = remember { mutableLongStateOf(0) }
    val timerTime: MutableState<Long> = remember { mutableLongStateOf(10000) }
    val progress: MutableState<Float> = remember { mutableFloatStateOf(1F) }
    val timerIsStop: MutableState<Boolean> = remember { mutableStateOf(true) }

    fun clearTime(){
        timerIsStop.value = true
        startTime.value = -1
        unRunTime.value = 0
        progress.value = 1F
    }
    class CusTimer: CountDownTimer(timerTime.value - (Date().time - startTime.value - unRunTime.value), 80) {

        override fun onTick(millisUntilFinished: Long) {
            val _time: Long = Date().time - startTime.value - unRunTime.value
            progress.value = 1 - _time / timerTime.value.toFloat()
            if(_time<=0){
                onFinish()
                this.cancel()
            }
        }

        override fun onFinish() {
            clearTime()
            val toast = Toast(context)
            toast.setText("виу-виу-виу")
            toast.show()
        }
    }

    val timer: MutableState<CusTimer> = remember { mutableStateOf(CusTimer()) }

    fun chengTime(dTime: Long){
        timerTime.value += dTime
        if (timerTime.value < 10000)
            timerTime.value = 10000
        else
            if (timerTime.value > 3600000)
                timerTime.value = 3600000
        if(!timerIsStop.value){
            timer.value.cancel()
            timer.value = CusTimer()
            timer.value.start()
        }
        else{
            if(startTime.value > 0){
                unRunTime.value += Date().time - stopTime.value
                stopTime.value = Date().time
                val _time = Date().time - startTime.value - unRunTime.value
                if(_time > timerTime.value)
                    timer.value.onFinish()
                else
                    progress.value = 1 - _time / timerTime.value.toFloat()
            }
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.weight(1f))
        Box(
            contentAlignment = Alignment.Center
        ){
            //val animatedProgress by animateFloatAsState(targetValue = 0.5F)
            CircularProgressIndicator(
                progress = progress.value,
                modifier = Modifier.size(300.dp),
                //color = Color.Black,
            )
            val _time = Date().time - startTime.value - unRunTime.value
            val str = String.format("%02d", timerTime.value/60000)+":"+String.format("%02d", timerTime.value%60000/1000)
            Text(
                text = if(startTime.value > 0) String.format("%02d", _time/60000)+":"+String.format("%02d", _time%60000/1000)+"/"+str else str,
                fontSize = 30.sp
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Row{
            Button(onClick = {
                chengTime(-60000)
            }, modifier = Modifier
                .padding(5.dp)
                .size(width = 80.dp, height = 40.dp)) {
                Text(text = "-1m")
            }
            Button(onClick = {
                chengTime(-10000)
            }, modifier = Modifier
                .padding(5.dp)
                .size(width = 80.dp, height = 40.dp)) {
                Text(text = "-10s")
            }
            Button(onClick = {
                chengTime(10000)
            }, modifier = Modifier
                .padding(5.dp)
                .size(width = 80.dp, height = 40.dp)) {
                Text(text = "+10s")
            }
            Button(onClick = {
                chengTime(60000)
            }, modifier = Modifier
                .padding(5.dp)
                .size(width = 80.dp, height = 40.dp)) {
                Text(text = "+1m")
            }
        }
        Row{
            Button(onClick = {
                if(timerIsStop.value){
                    if(startTime.value < 0){
                        startTime.value = Date().time
                    }
                    else{
                        unRunTime.value += Date().time - stopTime.value
                    }
                    timer.value = CusTimer()
                    timer.value.start()
                    timerIsStop.value = false
                }
                else{
                    timer.value.cancel()
                    stopTime.value = Date().time
                    timerIsStop.value = true
                }
            }, modifier = Modifier
                .padding(horizontal = 15.dp)
                .size(width = 120.dp, height = 60.dp)) {
                if(timerIsStop.value)
                    Text(text = "▶", fontSize = 30.sp)
                else
                    Text(text = "||", fontSize = 30.sp)
            }
            Button(onClick = { timer.value.cancel()
                clearTime()}, modifier = Modifier
                .padding(horizontal = 15.dp)
                .size(width = 120.dp, height = 60.dp)) {
                Text(text = "⟲", fontSize = 33.sp, fontWeight = FontWeight.Bold)
            }
        }

    }
}