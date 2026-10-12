
package com.example.app.componentes

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.hardware.SensorManager.SENSOR_DELAY_NORMAL
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SensorGiroscopio(context: Context) : ViewModel(), SensorEventListener {

    val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    val SensorG: Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)

    var state_giroX = mutableStateOf(0f)
    var state_giroY = mutableStateOf(0f)
    var state_giroZ = mutableStateOf(0f)

    //constructor
    init {
        SensorG?.also {
            sensorManager.registerListener(this, it, SENSOR_DELAY_NORMAL)
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, accuracy: Int) {}


    override fun onSensorChanged(event: SensorEvent?) {
        event?.let {

            if (kotlin.math.abs(it.values[0]) > 0.05f) {
                state_giroX.value = it.values[0]
            }

            if (kotlin.math.abs(it.values[1]) > 0.05f) {
                state_giroY.value = it.values[1]
            }

            if (kotlin.math.abs(it.values[2]) > 0.05f) {
                state_giroZ.value = it.values[2]
            }
        }
    }
}
