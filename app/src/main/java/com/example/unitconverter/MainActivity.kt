package com.example.unitconverter

import android.os.Bundle
import android.text.style.IconMarginSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UnitConverter(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun UnitConverter(modifier: Modifier=Modifier){
    var inputValue by remember { mutableStateOf("")}
    var outputValue by remember { mutableStateOf("")}
    var outputUnit by remember { mutableStateOf("M")}
    var inputUnit by remember { mutableStateOf("Cm")}
    var iExpanded by remember { mutableStateOf(false)}
    var oExpanded by remember { mutableStateOf(false)}
    val conversionFactor = remember { mutableStateOf(0.01)}
    Column(
        modifier= Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Unit Converter")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = outputValue, onValueChange ={
            outputValue=it
        } )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
          Box{
              Button(onClick = { /*TODO*/
               iExpanded = true
              }) {
                Text(inputUnit, style = MaterialTheme.typography.headlineSmall)
                Icon(Icons.Default.ArrowDropDown , contentDescription = "Hello" )


            }
              DropdownMenu(expanded = iExpanded, onDismissRequest = { /*TODO*/
                  iExpanded=false

              }) {
                  DropdownMenuItem(text = { Text(text = "Cm") }, onClick = { /*TODO*/
                   iExpanded=false
                   inputUnit="Cm"
                   conversionFactor.value=0.01
                  })
                  DropdownMenuItem(text = { Text(text = "m") }, onClick = { /*TODO*/
                      iExpanded=false
                      inputUnit="m"
                      conversionFactor.value=0.01
                  })
                  DropdownMenuItem(text = { Text(text = "feet") }, onClick = { /*TODO*/
                      iExpanded=false
                      inputUnit="Cm"
                      conversionFactor.value=0.01
                  })
                  DropdownMenuItem(text = { Text(text = "mm") }, onClick = { /*TODO*/
                      iExpanded=false
                      inputUnit="Cm"
                      conversionFactor.value=0.01
                  })
                  
              }
              }
            Spacer(modifier = Modifier.width(16.dp))
            Box{
                Button(onClick = { /*TODO*/
                oExpanded=true
                }) {
                    Text(outputUnit)
                    Icon(Icons.Default.ArrowDropDown , contentDescription = "Hello" )


                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { /*TODO*/
                oExpanded=false
                }) {
                    DropdownMenuItem(text = { Text(text = "Cm") }, onClick = { /*TODO*/
                        oExpanded=false
                        outputUnit="Cm"
                        conversionFactor.value=0.01
                    })
                    DropdownMenuItem(text = { Text(text = "m") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "feet") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "mm") }, onClick = { /*TODO*/ })

                }
            }
            
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Result :")
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverter()
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )

}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    UnitConverterTheme {
//        Greeting("Android")
//    }
//}