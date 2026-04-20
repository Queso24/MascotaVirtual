package com.example.proyectoparcial.pantallas

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

//@Preview(showBackground = true)
@Composable

fun RegistroEstadisticasView(navController: NavHostController) {
    val measurements = listOf(
        "95 mg/dL" to "24/02 - 08:00",
        "120 mg/dL" to "25/02 - 09:30",
        "105 mg/dL" to "26/02 - 08:15"
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0F7F9))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item { Spacer(modifier = Modifier.height(16.dp)) }

        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF59D))
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("You're doing great!", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Text("Your control is excellent 💪", fontSize = 14.sp)
                }
            }
        }

        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("📊 My Glucose Level", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color(0xFF5C6BC0))
                    Spacer(modifier = Modifier.height(16.dp))

                    val data = listOf(95 to "24/02", 120 to "25/02", 105 to "26/02", 110 to "27/02", 98 to "28/02", 115 to "01/03", 108 to "02/03")

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        data.forEach { (valor, fecha) ->
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(valor.toString(), fontSize = 10.sp)
                                Box(
                                    modifier = Modifier
                                        .width(20.dp)
                                        .height((valor * 0.8).dp)
                                        .background(Color(0xFFA5D6A7))
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(fecha, fontSize = 9.sp, color = Color.Gray)
                            }
                        }
                    }
                }
            }
        }

        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("🔍 My Measurements", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color(0xFF5C6BC0))
                    Spacer(modifier = Modifier.height(12.dp))

                    measurements.forEach { (valor, fecha) ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("💧", fontSize = 18.sp)
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text(valor, fontWeight = FontWeight.Bold)
                                Text(fecha, fontSize = 12.sp, color = Color.Gray)
                            }
                        }
                    }
                }
            }
        }

        item { Spacer(modifier = Modifier.height(80.dp)) }
    }
}