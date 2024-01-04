package com.banklannister.drinkingsoda

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.banklannister.drinkingsoda.ui.theme.DrinkingSodaTheme
import com.banklannister.drinkingsoda.ui.theme.WaterColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DrinkingSodaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    var usedAmount by remember {
                        mutableStateOf(100)
                    }

                    val totalWaterAmount = remember {
                        2500
                    }

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        SodaBottle(
                            totalWaterAmount = totalWaterAmount,
                            unit = "ml",
                            usedWaterAmount = usedAmount,
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = "Total amount is : $totalWaterAmount ml.",
                            textAlign = TextAlign.Center
                        )

                        Button(
                            onClick = {
                                usedAmount += 200
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = WaterColor)
                        ) {
                            Text(text = "Drink")
                        }
                    }
                }
            }
        }
    }
}