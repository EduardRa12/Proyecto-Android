package com.example.app.componentes

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.icu.util.Calendar
import android.net.Uri
import android.provider.CalendarContract
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import kotlin.contracts.contract

@Composable
fun MisIntentos(modifier: Modifier = Modifier){
    //intent explicitos
    //https://developer.android.com/jetpack/compose/lists?hl=es-419
    val contexto = LocalContext.current

    var state_num by remember {mutableStateOf("")}

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        TextField(value = state_num, onValueChange = {state_num=it}, modifier = Modifier.fillMaxWidth())
        //intentar realizar un allamada
        Button(onClick = {
            val intento : Intent = Uri.parse("tel:$state_num").let {
                    numero ->
               Intent(Intent.ACTION_CALL, numero)
            }
            contexto.startActivity(intento)
        }){
            Text("llamar")
        }
        //boton de google maps
        Button(onClick = {
            val intent_maps: Intent = Uri.parse("geo:19.70248339551657, -101.19231601682614?q=cafe\n").let { coord ->
                Intent(Intent.ACTION_VIEW, coord)
            }
            contexto.startActivity(intent_maps)
        }){
            Text("google maps")

        }

        Button(onClick = {
            val intent_WEB:Intent = Uri.parse("https://morelia.tecnm.mx").let {
                URL -> Intent(Intent.ACTION_VIEW, URL)
            }
            contexto.startActivity(intent_WEB)
        }) {
            Text("abrir pag")
        }
        Button(onClick = {
            val intent_mail: Intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_EMAIL, arrayOf("eduardra@outlook.com","eduardo_diaz_ramos@hotmail.com"))
                putExtra(Intent.EXTRA_CC, arrayOf("lalo22022002@gmail.com"))
                putExtra(Intent.EXTRA_SUBJECT, "asunto")
                putExtra(Intent.EXTRA_TEXT, "NO")
            }
            contexto.startActivity(intent_mail)
        }) {
            Text("Enviar correo")
        }

        Button(onClick = {
            val intent_evento:Intent = Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI).apply {
                val fecha_ini: Calendar= Calendar.getInstance().apply{
                    set(2026, 10, 2, 8, 0)
                }
                val fecha_fin: Calendar= Calendar.getInstance().apply{
                    set(2026, 10, 3, 10, 0)
                }
                putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, fecha_ini.timeInMillis)
                putExtra(CalendarContract.EXTRA_EVENT_END_TIME, fecha_fin.timeInMillis)
                putExtra(CalendarContract.Events.TITLE, "evento Prueba")
            }
            contexto.startActivity(intent_evento)
        }){
            Text("crear evento")
        }
    }
}

@Composable
fun OpenCameraButton() {
    val contexto = LocalContext.current
    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val imagen = result.data?.extras?.get("data") as Bitmap

        }
    }
    Button(onClick = {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraLauncher.launch(intent)
    }) {
        Text("Abrir Camara")
    }
}

