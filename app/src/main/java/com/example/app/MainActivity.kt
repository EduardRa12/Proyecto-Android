package com.example.app

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
import com.example.app.componentes.CorreoTextField
import com.example.app.componentes.HandlerOrientacion
import com.example.app.componentes.MandarMensajes
import com.example.app.componentes.MiPortrait
import com.example.app.componentes.MisIntentos
import com.example.app.componentes.OpenCameraButton
import com.example.app.componentes.ScreenGiroscopio
import com.example.app.componentes.ScreenLuz
import com.example.app.componentes.TextFieldGenerico
import com.example.app.componentes.TextosEjemplo
import com.example.app.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    /*Greeting(
                        name = "Eduard",
                        modifier = Modifier.padding(innerPadding)
                    )*/
                    // MyBox()
                    //ColconPesos()
                    // Anidado()
                    //ComponentCard()
                    //Cajitas()
                    //ContadorStateless()
                    //TextosEjemplo()
                    //TextFieldGenerico("eduardra@outlook.com", "false", "Error")
                    //HandlerOrientacion()
                    //MisIntentos()
                    //MandarMensajes(modifier = Modifier.padding(innerPadding))
                    //ScreenLuz(modifier = Modifier.padding(innerPadding))
                    ScreenGiroscopio()
                }

            }

        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun MyBox(){
    Box(modifier=
        Modifier.width(200.dp)
            .height(200.dp)
            .background(Color.Cyan)
            .verticalScroll(rememberScrollState())
        , contentAlignment= Alignment.BottomCenter

    ){
        Text(text = "Mensaje de nuestro Box")
    }

}

@Composable
fun ColconPesos(){
    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
        Text(text = "hijo", modifier = Modifier.background(Color.Red).fillMaxWidth().height(180.dp))
        Text(text = "hijo", modifier = Modifier.background(Color.Blue).fillMaxWidth().height(180.dp))
        Text(text = "hijo", modifier = Modifier.background(Color.Green).fillMaxWidth().height(180.dp))
        Text(text = "hijo", modifier = Modifier.background(Color.Yellow).fillMaxWidth().height(180.dp))
        Text(text = "hijo", modifier = Modifier.background(Color.Red).fillMaxWidth().height(180.dp))
        Text(text = "hijo", modifier = Modifier.background(Color.Blue).fillMaxWidth().height(180.dp))
        Text(text = "hijo", modifier = Modifier.background(Color.Green).fillMaxWidth().height(180.dp))
        Text(text = "hijo", modifier = Modifier.background(Color.Yellow).fillMaxWidth().height(180.dp))

    }
}

@Composable
fun Anidado(){
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier= Modifier.background(Color.Gray).weight(1f).fillMaxWidth()){
            Image(painter = painterResource(id = R.drawable.outline_agriculture_24)
                , contentDescription = "imagen avion", modifier = Modifier.width(70.dp).height(70.dp))
        }
        Row(modifier= Modifier.weight(1f)) {
            Box(modifier = Modifier.fillMaxHeight().background(Color.Magenta).weight(1f)){
                Image(painter = painterResource(id = R.drawable.baseline_alarm_24)
                    , contentDescription = "imagen alarma", modifier = Modifier.width(120.dp).height(120.dp))
            }
            Box(modifier= Modifier.fillMaxHeight().background(Color.Green).weight(1f)){
                Image(painter = painterResource(id = R.drawable.outline_arrow_drop_down_circle_24)
                    , contentDescription = "imagen avion", modifier = Modifier.width(120.dp).height(120.dp))
            }

        }
        Box(modifier= Modifier.weight(1f).background(Color.Cyan).fillMaxWidth()) {

        }
    }

}




@Composable
fun ComponentCard(modifier: Modifier= Modifier) {
    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
        OutlinedCard(modifier = Modifier.fillMaxWidth().height(400.dp)) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Card 1", fontSize = 24.sp, modifier = Modifier.weight(1f))
                Text(text = "Lorem", modifier.weight(3f))

            }
        }
        OutlinedCard(modifier = Modifier.fillMaxWidth().height(400.dp)) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Card 2", fontSize = 24.sp, modifier = Modifier.weight(1f))
                Text(text = "Lorem", modifier.weight(3f))

            }
        }
        OutlinedCard(modifier = Modifier.fillMaxWidth().height(400.dp)) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Card 3", fontSize = 24.sp, modifier = Modifier.weight(1f))
                Text(text = "Lorem", modifier.weight(3f))

            }
        }
        OutlinedCard(modifier = Modifier.fillMaxWidth().height(400.dp)) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Card 4", fontSize = 24.sp, modifier = Modifier.weight(1f))
                Text(text = "Lorem", modifier.weight(3f))

            }
        }
        OutlinedCard(modifier = Modifier.fillMaxWidth().height(400.dp)) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Card 5", fontSize = 24.sp, modifier = Modifier.weight(1f))
                Text(text = "Lorem", modifier.weight(3f))

            }
        }

    }
}

@Composable
fun Caja(color: Color) {
    Box(
        modifier = Modifier.height(120.dp).width(120.dp).clip(CircleShape).background(color)
    )
}

@Composable
fun Cajitas() {
    Row(
        Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Caja(Color.Red)
        Caja(Color.Green)
        Caja(Color.Blue)

    }
}
@Composable
fun Contador(){
    var contador by rememberSaveable {mutableStateOf(0) }
    Column(modifier = Modifier.fillMaxSize()
    , horizontalAlignment = Alignment.CenterHorizontally
    , verticalArrangement =  Arrangement.Center){
        Row(verticalAlignment = Alignment.Top) { }
        Text(text = "Contador : $contador")

        Row(horizontalArrangement = Arrangement.spacedBy(5.dp)
        ){
            Button(onClick =  {
                contador++
                Log.d("contador",contador.toString())
            }){
                Text(text = "Incrementar")

            }
            Button(onClick =  {
                contador--
                Log.d("contador",contador.toString())
            }){
                Text(text = "Decrementar")
            }
            Button(onClick =  {
                contador=0
                Log.d("contador",contador.toString())
            }){
                Text(text = "0")
            }

        }

    }
}

@Composable
fun ContadorStateless(){
    var contador by rememberSaveable{mutableStateOf(0)}
    Column(modifier = Modifier.fillMaxSize()
    , horizontalAlignment = Alignment.CenterHorizontally
    , verticalArrangement = Arrangement.Center){
        Text(text = "Contador : $contador")
        Boton(enClick={
            contador++
            Log.d("contador", contador.toString())
        })
    }
}

@Composable
fun Boton(enClick:()-> Unit){
    Button(onClick = {
        enClick()
    }){
        Text(text = "Incrementar")
    }
}


@Composable
fun GreetingPreview() {
    AppTheme {
        Greeting("Android")

    }
}


