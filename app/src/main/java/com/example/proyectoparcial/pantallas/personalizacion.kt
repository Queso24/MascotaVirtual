package com.example.proyectoparcial.pantallas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun PantallaPersonalizar() {

    var nombreTexto by remember { mutableStateOf("Nina") }
    var itemSeleccionado by remember { mutableStateOf(0) }

    // Datos del LazyGrids (Luego sustituir por imágenes para mejor representación)
    val nombres = listOf("Nina", "Niño", "Chica", "Niñito", "Unicornio", "Perrito", "Gatito", "Conejito", "Panda")
    val emojis = listOf("👧", "👦", "👩", "👶", "🦄", "🐶", "🐱", "🐰", "🐼")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFC5D3))
    ) {
        // Barra superior
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.PlayArrow, contentDescription = null, tint = Color.White)
            Spacer(modifier = Modifier.width(16.dp))
            Text("Personalizar Mascota", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }

        // Tarjetas de cambio de personaje
        Card(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Surface(
                    modifier = Modifier.size(80.dp),
                    shape = CircleShape,
                    color = Color(0xFFF0F0F0)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(emojis[itemSeleccionado], fontSize = 40.sp)
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(nombreTexto, fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                Text(nombreTexto, fontSize = 14.sp, color = Color.Gray)
            }
        }

        // Editar nombre
        Card(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Nombre de tu mascota", color = Color(0xFF673AB7), fontWeight = FontWeight.Bold)

                OutlinedTextField(
                    value = nombreTexto,
                    onValueChange = { nombreTexto = it },
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                    leadingIcon = { Icon(Icons.Default.Edit, contentDescription = null, tint = Color.Gray) },
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true
                )
            }
        }

        // GRID de selección
        Text(
            "Elige tu mascota favorita",
            color = Color.White,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp, start = 20.dp),
            fontWeight = FontWeight.Bold
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(9) { index ->
                val seleccionado = index == itemSeleccionado

                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .clickable { itemSeleccionado = index },
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = if (seleccionado) BorderStroke(2.dp, Color(0xFF673AB7)) else null,
                    elevation = CardDefaults.cardElevation(if (seleccionado) 6.dp else 0.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Surface(
                            modifier = Modifier.size(50.dp),
                            shape = CircleShape,
                            color = Color(0xFFF8F8F8)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(emojis[index], fontSize = 24.sp)
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = nombres.getOrElse(index) { "Mascota" },
                            fontSize = 12.sp,
                            color = if (seleccionado) Color(0xFF673AB7) else Color.Black,
                            fontWeight = if (seleccionado) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                }
            }
        }
    }
}