package com.example.app.componentes

import android.R
import android.graphics.fonts.Font
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TextosEjemplo(){
    Column(modifier = Modifier.fillMaxSize()
    , horizontalAlignment = Alignment.CenterHorizontally
    , verticalArrangement = Arrangement.Center) {
        Text(text = "Hola")
        Text(text = "Hola", color = Color.Red)
        Text(text = "Hola", fontSize = 24.sp)
        Text(text = "Hola", fontWeight = FontWeight.ExtraBold)
        Text(text = "Hola", fontWeight = FontWeight.Light)

    }
}