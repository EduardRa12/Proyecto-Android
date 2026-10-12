package com.example.app.componentes

import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun HandlerOrientacion(){
    val configuration = LocalConfiguration.current
    val esPortrait = configuration.orientation == Configuration.ORIENTATION_PORTRAIT
    if(esPortrait){
        MiPortrait()
    }else{
        Milandscape()
    }
}


//mi presentacion en Landscape y portrait


@Composable
fun MiPortrait(){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier.size(150.dp).background(Color.Red), contentAlignment = Alignment.Center){
            Text(text = "item")
        }

        Box(modifier = Modifier.size(150.dp).background(Color.Blue), contentAlignment = Alignment.Center){
            Text(text = "item")
        }

        Box(modifier = Modifier.size(150.dp).background(Color.Green), contentAlignment = Alignment.Center){
            Text(text = "item")
        }
    }
}



@Composable
fun Milandscape(){
    Row(modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically) {

        Box(modifier = Modifier.weight(1f).background(Color.Green)){
            Text("item")
        }

        Column(modifier = Modifier.weight(1f)
        , horizontalAlignment = Alignment.CenterHorizontally
        , verticalArrangement = Arrangement.Center) {
            Text("item 1", modifier = Modifier.fillMaxWidth().background(Color.Red).height(120.dp))
            Text("item 2", modifier = Modifier.fillMaxWidth().background(Color.Blue).height(120.dp))
        }
    }
}
