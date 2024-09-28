package com.example.kotlinflows1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlinflows1.ui.theme.KotlinFlows1Theme
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinFlows1Theme {
               Surface(
                   modifier = Modifier.fillMaxSize(),
                   color = Color.White
               ) {
                   consumer()
               }
            }
        }
    }
}


fun producer():Flow<Int>{
    return flow {
        for (i in 1..10){
            delay(1000)
            emit(i)
        }
    }
}

fun consumer(){

    runBlocking {
        producer().collect{data->
            Log.d("flowdata","$data")
        }
    }

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinFlows1Theme {

    }
}