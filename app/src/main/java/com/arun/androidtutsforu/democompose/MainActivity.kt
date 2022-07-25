package com.arun.androidtutsforu.democompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arun.androidtutsforu.democompose.ui.theme.DemoComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CalculateScreen()
                }
            }
        }
    }
}

@Composable
fun CalculateScreen(){
    var firstNum by rememberSaveable{ mutableStateOf("")}
    var secondNum by rememberSaveable { mutableStateOf("")}
    val num1 = firstNum.toIntOrNull()?:0
    val num2 = secondNum.toIntOrNull()?:0
    val sum = num1+num2
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally

        ) {
        Text(
            text = "JetPack Compose Demo",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Blue
        )
        Spacer(modifier = Modifier.height(32.dp))
        TextField(
            value =firstNum ,
            onValueChange ={firstNum = it} ,
            label = { Text(text = "Enter First Num")}
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = secondNum,
            onValueChange = {secondNum=it},
            label = { Text(text = "Enter Second Num")}
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "The sum is $sum",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}