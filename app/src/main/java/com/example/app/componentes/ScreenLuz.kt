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
fun ScreenLuz(modifier: Modifier){
    val  contexto: Context = LocalContext.current
    val sensorLuz = remember(contexto){SensorLuz(contexto)}
    DisposableEffect(Unit){
        onDispose {
            sensorLuz.unregisterSensor()
        }

    }
    Column(modifier = Modifier.fillMaxSize()
        ,horizontalAlignment = Alignment.CenterHorizontally
        ,verticalArrangement = Arrangement.Center) {
        Text(text = "Nivel de luz: ${sensorLuz.state_light.value}")
    }
}