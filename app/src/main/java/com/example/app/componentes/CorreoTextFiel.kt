package com.example.app.componentes


import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app.componentes.TextosEjemplo
import com.example.app.ui.theme.AppTheme

    @Composable
    fun CorreoTextField(){
        var correo by rememberSaveable{ mutableStateOf("") }
        var isError by rememberSaveable{ mutableStateOf(false) }
        fun isValidEmail(email: String): Boolean{
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }
        Column(modifier = Modifier.fillMaxSize()
            , horizontalAlignment = Alignment.CenterHorizontally
            , verticalArrangement = Arrangement.Center) {
            TextField(value = correo, onValueChange = {
                correo= it
                isError = !isValidEmail(correo) && correo.isNotEmpty()
            }, isError = isError, label = {Text("Correo")} )
            if(isError){
                Text(text = "Email no válido",
                    color = Color.Red)
            }
        }

    }

@Composable
fun TextFieldGenerico(texto_inicial: String, comportamiento:(String) -> Boolean, mensajeError: String){
    var contenido by rememberSaveable{ mutableStateOf("") }
    var isError by rememberSaveable{ mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()
        , horizontalAlignment = Alignment.CenterHorizontally
        , verticalArrangement = Arrangement.Center) {
        TextField(value = contenido, onValueChange = {
            contenido= it
            isError = !comportamiento(contenido) && contenido.isNotEmpty()
        }, isError = isError, label = {Text(texto_inicial) })
        if(isError){
            Text(text = mensajeError,
                color = Color.Red)
        }
    }

}
