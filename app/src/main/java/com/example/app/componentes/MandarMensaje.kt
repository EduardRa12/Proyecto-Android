package com.example.app.componentes

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import java.net.URI


@Composable
fun MandarMensajes(modifier: Modifier){
    val contexto = LocalContext.current
    var state_telefono by remember { mutableStateOf("") }
    var state_mensaje by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize()
        , horizontalAlignment = Alignment.CenterHorizontally
        , verticalArrangement = Arrangement.Center) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { state_telefono = it },
            value = state_telefono,
            label = { Text("numero telefonico") })

        TextField(
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { state_mensaje = it },
            value = state_mensaje,
            label = { Text("Mensaje de Texto)") })


        Button(modifier = Modifier.fillMaxWidth(), onClick = {
            if (state_mensaje.isNotBlank() && state_telefono.isNotBlank()) {
                val intent: Intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("smsto:" + state_telefono.toString())
                    putExtra("sms_body", state_mensaje)
                }
                contexto.startActivity(intent)
                state_mensaje = ""
                state_telefono = ""
            }
        }) {
            Text("Envia mensaje")

        }

    }}


