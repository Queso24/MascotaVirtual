package com.example.proyectoparcial.pantallas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val ButtonBlue = Color(0xFF4552B3)

@Composable
@Preview(showBackground = true)

fun GlucosaView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Tarjeta de medición
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Registra tu medición",
                    color = Color(0xFF7986CB),
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(20.dp))

                // TextField de nivel de glucosa
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Nivel de Glucosa") },
                    placeholder = { Text("mg/dL") },
                    leadingIcon = { Icon(Icons.Default.Info, null) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Textfield de fecha
                OutlinedTextField(
                    value = "3/2/2026",
                    onValueChange = {},
                    label = { Text("Fecha") },
                    leadingIcon = { Icon(Icons.Default.Info, null) },
                    trailingIcon = { Icon(Icons.Default.Info, null) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Textfield de hora
                OutlinedTextField(
                    value = "12:30",
                    onValueChange = {},
                    label = { Text("Hora") },
                    leadingIcon = { Icon(Icons.Default.Info, null) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Valores rápidos
                Text(
                    text = "Valores rápidos:",
                    modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp),
                    color = Color.Gray,
                    fontSize = 14.sp
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
                ) {
                    val valores1 = listOf("65", "90", "110", "150")
                    valores1.forEach { valor ->
                        OutlinedButton(
                            onClick = {},
                            shape = CircleShape,
                            border = BorderStroke(2.dp, Color(0xFF7986CB)),
                            contentPadding = PaddingValues(0.dp),
                            modifier = Modifier.size(width = 65.dp, height = 40.dp)
                        ) {
                            Text(text = valor, color = Color.Black, fontWeight = FontWeight.Bold)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    OutlinedButton(
                        onClick = { /* Acción aquí */ },
                        shape = CircleShape,
                        border = BorderStroke(2.dp, Color(0xFF7986CB)),
                        modifier = Modifier.size(width = 80.dp, height = 40.dp)
                    ) {
                        Text(text = "200", color = Color.Black, fontWeight = FontWeight.Bold)
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Botón de guardar
                Button(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth().height(56.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = ButtonBlue),
                    shape = RoundedCornerShape(28.dp)
                ) {
                    Icon(Icons.Default.CheckCircle, null)
                    Spacer(Modifier.width(8.dp))
                    Text("Guardar Medición", fontSize = 18.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Tabla de rangos de referencia
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(32.dp),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(
                modifier = Modifier
                    .background(GradientPink)
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Rangos de Referencia",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                // Diseño de las filas
                val filaEstilo = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .background(Color.White.copy(alpha = 0.7f), RoundedCornerShape(16.dp))
                    .padding(horizontal = 16.dp, vertical = 12.dp)

                Box(modifier = filaEstilo) {
                    Text("↓  Baja: < 70 mg/dL", color = Color.Black)
                }

                Box(modifier = filaEstilo) {
                    Text("✓  Normal: 70-180 mg/dL", color = Color.Black)
                }
                
                Box(modifier = filaEstilo) {
                    Text("↑  Alta: > 180 mg/dL", color = Color.Black)
                }
            }
        }


    }
}