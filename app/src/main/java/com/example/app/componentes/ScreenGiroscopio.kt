package com.example.app.componentes

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun ScreenGiroscopio(modifier: Modifier = Modifier) {

    val contexto: Context = LocalContext.current
    val sensorGiroscopio = remember(contexto) { SensorGiroscopio(contexto) }

    DisposableEffect(sensorGiroscopio) {
        onDispose {
            sensorGiroscopio.unregisterSensor()
        }
    }

    Column(modifier = Modifier.fillMaxSize()
        ,horizontalAlignment = Alignment.CenterHorizontally
        ,verticalArrangement = Arrangement.Center) {

        Text(text = "Giroscopio X: ${sensorGiroscopio.state_giroX.value}")
        Text(text = "Giroscopio Y: ${sensorGiroscopio.state_giroY.value}")
        Text(text = "Giroscopio Z: ${sensorGiroscopio.state_giroZ.value}")
    }
}

private fun SensorGiroscopio.unregisterSensor() {}
