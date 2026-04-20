package com.example.proyectoparcial.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.proyectoparcial.R

val FondoArena = Color(0xFFE8C87C)
val AzulBarra = Color(0xFF5C6BC0)
val VerdeSeccion = Color(0xFF4CAF50)
val AmbarSeccion = Color(0xFFFFC107)
val RojoSeccion = Color(0xFFF44336)

data class ComidaItem(val nombre: String, val emoji: String)

@Composable
//@Preview(showBackground = true)
fun RegistroComidasView(navController: NavHostController) {
    val saludables = listOf(
        ComidaItem("Salad", "🥗"),
        ComidaItem("Fruits", "🍎"),
        ComidaItem("Veggies", "🥦"),
        ComidaItem("Chicken", "🍗"),
        ComidaItem("Fish", "🐟"),
        ComidaItem("Water", "💧"),
        ComidaItem("Oatmeal", "🌾"),
        ComidaItem("Egg", "🥚")
    )

    val moderacion = listOf(
        ComidaItem("Pizza", "🍕"),
        ComidaItem("Pasta", "🍝"),
        ComidaItem("Bread", "🍞"),
        ComidaItem("Rice", "🍚"),
        ComidaItem("Cheese", "🧀"),
        ComidaItem("Juice", "🧃")
    )

    val evitar = listOf(
        ComidaItem("Soda", "🥤"),
        ComidaItem("Chips", "🍟"),
        ComidaItem("Sweets", "🍬"),
        ComidaItem("Burger", "🍔"),
        ComidaItem("Sugar", "🍭")
    )

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(AzulBarra)
                .padding(horizontal = 8.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "What I Ate",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(FondoArena),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.dinosaurio),
                            contentDescription = null,
                            modifier = Modifier.size(120.dp)
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "What did you eat today?",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            item {
                SeccionComida(
                    titulo = "Healthy Food",
                    icono = Icons.Default.CheckCircle,
                    colorSeccion = VerdeSeccion,
                    comidas = saludables
                )
            }

            item {
                SeccionComida(
                    titulo = "Moderate",
                    icono = Icons.Default.AddCircle,
                    colorSeccion = AmbarSeccion,
                    comidas = moderacion
                )
            }

            item {
                SeccionComida(
                    titulo = "Avoid",
                    icono = Icons.Default.Close,
                    colorSeccion = RojoSeccion,
                    comidas = evitar
                )
            }
        }
    }
}

@Composable
fun SeccionComida(titulo: String, icono: ImageVector, colorSeccion: Color, comidas: List<ComidaItem>) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = icono,
                    contentDescription = null,
                    tint = colorSeccion,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = titulo,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorSeccion
                )
            }
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 8.dp),
                thickness = 2.dp,
                color = colorSeccion
            )
            comidas.chunked(2).forEach { fila ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    fila.forEach { comida ->
                        TarjetaComida(comida = comida, modifier = Modifier.weight(1f))
                    }
                    if (fila.size == 1) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun TarjetaComida(comida: ComidaItem, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5)),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = comida.emoji,
                fontSize = 36.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = comida.nombre,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        }
    }
}
