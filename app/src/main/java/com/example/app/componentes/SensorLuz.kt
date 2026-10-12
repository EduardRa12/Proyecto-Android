package com.example.app.componentes

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.hardware.SensorManager.SENSOR_DELAY_NORMAL
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SensorLuz (context: Context) : ViewModel(), SensorEventListener {
    val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    val SensorL: Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)

    var state_light = mutableStateOf(0f)

    //constructor
init {
    SensorL.also{
        sensorManager.registerListener(this, it, SENSOR_DELAY_NORMAL)
    }
}

    override fun onAccuracyChanged(p0: Sensor?, accuracy: Int) {}
    override fun onSensorChanged(event: SensorEvent?) {
        event?.let {
            state_light.value = it.values[0]
        }
    }
    fun unregisterSensor(){
        sensorManager.unregisterListener(this)
    }
}
