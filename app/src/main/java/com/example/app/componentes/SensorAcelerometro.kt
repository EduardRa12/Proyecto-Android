package com.example.app.componentes

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SensorAcelerometro(context: Context) : ViewModel(), SensorEventListener {
    val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    val SensorAccel: Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

    var estado_accX = mutableStateOf(0f)
    var estado_accY = mutableStateOf(0f)
    var estado_accZ = mutableStateOf(0f)

    //constructor
    init {
        SensorAccel.also {
            sensorManager.registerListener(this, it, 1000000)
        }
    }


    override fun onAccuracyChanged(p0: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {
        event?.let {
            estado_accX.value = it.values[0]
            estado_accY.value = it.values[1]
            estado_accZ.value = it.values[2]
        }
    }

    fun unregisterSensor() {
        sensorManager.unregisterListener(this)
    }

}




