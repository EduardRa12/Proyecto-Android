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
fun ScreenAccel(modifier: Modifier){
    val contexto: Context = LocalContext.current
    val sensorAcelerometro = remember(contexto) {SensorAcelerometro(contexto)
    }
    DisposableEffect((Unit)) {
        onDispose{
            sensorAcelerometro.unregisterSensor()
        }
    }
    Column (modifier=Modifier.fillMaxSize()
    , verticalArrangement = Arrangement.Center
    , horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Lectura X:${sensorAcelerometro.estado_accX.value.toString()}")
        Text(text = "Lectura Y:${sensorAcelerometro.estado_accY.value.toString()}")
        Text(text = "Lectura Z:${sensorAcelerometro.estado_accZ.value.toString()}")
    }
}

