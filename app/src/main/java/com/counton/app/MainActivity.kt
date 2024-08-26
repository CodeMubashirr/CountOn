package com.counton.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.counton.app.ui.theme.CountOnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CountOnTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CounterApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Custom color
fun customColor(hex: String): Color {
    return Color(android.graphics.Color.parseColor(hex))
}

val gradColor1 = customColor("#ff9a9e")
val gradColor2 = customColor("#ff9a9e")
val incrementColor = customColor("#8cd6f5")
val decrementColor = customColor("#c77587")
val resetColor = customColor("#969696")
val textColor = customColor("#ffffff")

// Main counter app composable
@Composable
fun CounterApp(modifier: Modifier) {
    var number by rememberSaveable { mutableStateOf(0) }

    // Setting background
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        gradColor2,
                        gradColor1,
                    )
                )
            )
    ) {

    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 32.dp, bottom = 150.dp, end = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Count value
        Text(
            "$number", fontSize = 200.sp, fontWeight = FontWeight.ExtraBold, color = Color.LightGray
        )
        Spacer(Modifier.height(32.dp))

        // Action buttons
        Row {

            // Increment button
            Button(
                onClick = {
                    number++
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .height(80.dp),
                shape = RoundedCornerShape(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = incrementColor,
                    contentColor = textColor
                )
            )
            {
                Text(
                    "INCREASE",
                    fontSize = 20.sp
                )
            }

            // Decrement button
            Button(
                onClick = {
                    number--
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .height(80.dp),
                shape = RoundedCornerShape(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = decrementColor,
                    contentColor = textColor
                )
            ) {
                Text(
                    "DECREASE",
                    fontSize = 20.sp
                )
            }
        }
        Box() {

            // Reset button
            Button(
                onClick = {
                    number = 0
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                shape = RoundedCornerShape(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = resetColor,
                    contentColor = textColor
                )
            ) {
                Text(
                    "RESET",
                    fontSize = 20.sp
                )
            }
        }
    }
}


// < ---------------------------------------- Ends Here ---------------------------------------- >

