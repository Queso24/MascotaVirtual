package com.example.proyectoparcial.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class DetalleComida(
    val descripcion: String,
    val calorias: String,
    val proteinas: String,
    val carbohidratos: String,
    val grasas: String,
    val fibra: String
)

fun obtenerDetalle(nombre: String): DetalleComida {
    return when (nombre) {
        "Salad"    -> DetalleComida("Fresh mix of vegetables, low in calories and rich in essential vitamins.", "25", "1.5g", "4g", "0.3g", "2g")
        "Fruits"      -> DetalleComida("Natural source of sugar, vitamins, and antioxidants that protect your body.", "60", "0.8g", "15g", "0.2g", "2.5g")
        "Vegetables"    -> DetalleComida("High in vitamins, minerals, and dietary fiber for healthy digestion.", "35", "2g", "7g", "0.3g", "3g")
        "Chicken"       -> DetalleComida("High-quality lean protein, low in saturated fat and ideal for muscles.", "165", "31g", "0g", "3.6g", "0g")
        "Fish"     -> DetalleComida("Rich in omega-3 and high biological value proteins that benefit the heart.", "120", "22g", "0g", "3g", "0g")
        "Water"        -> DetalleComida("Essential for hydration and the correct functioning of all organs.", "0", "0g", "0g", "0g", "0g")
        "Oatmeal"       -> DetalleComida("Whole grain with high fiber content that provides sustained energy.", "389", "17g", "66g", "7g", "10g")
        "Egg"       -> DetalleComida("Complete source of protein with all the essential amino acids you need.", "143", "13g", "1g", "10g", "0g")
        "Pizza"       -> DetalleComida("High in sodium and saturated fats; occasional consumption is recommended.", "266", "11g", "33g", "10g", "2g")
        "Pasta"       -> DetalleComida("Good source of carbohydrates; whole-grain versions are preferred.", "220", "8g", "43g", "1.3g", "2.5g")
        "Bread"         -> DetalleComida("Simple carbohydrate for easy digestion; whole-wheat is better.", "265", "9g", "49g", "3.2g", "2.7g")
        "Rice"       -> DetalleComida("Quick energy source; choose the whole-grain version for more nutrition.", "130", "2.7g", "28g", "0.3g", "0.4g")
        "Cheese"       -> DetalleComida("Rich in calcium and protein, but high in saturated fats.", "402", "25g", "1.3g", "33g", "0g")
        "Juice"        -> DetalleComida("Provides vitamins but is high in sugar and lacks whole fruit fiber.", "90", "0.7g", "22g", "0.2g", "0.5g")
        "Soda"    -> DetalleComida("No real nutritional value, very high in sugar and harmful additives.", "140", "0g", "39g", "0g", "0g")
        "Chips"    -> DetalleComida("High calorie density with trans fats and excess sodium; avoid it.", "547", "6g", "57g", "35g", "4g")
        "Sweets"      -> DetalleComida("Empty calories with no essential nutrients that spike blood sugar.", "390", "0g", "98g", "0g", "0g")
        "Burger" -> DetalleComida("High in saturated fats, sodium, and calories; frequent use is harmful.", "295", "17g", "24g", "14g", "1g")
        "Sugar"      -> DetalleComida("Empty calories that increase the risk of developing diabetes.", "387", "0g", "100g", "0g", "0g")
        else          -> DetalleComida("Food registered in the system. Consult your nutritionist for more details.", "—", "—", "—", "—", "—")
    }
}

@Composable
@Preview(showBackground = true)
fun DetalleComidaView(
    comida: ComidaItem = ComidaItem("Salad", "🥗")
) {
    var cantidad by remember { mutableStateOf("") }
    val detalle = obtenerDetalle(comida.nombre)

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(AzulBarra)
                .padding(horizontal = 8.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = comida.nombre,
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
                        Text(
                            text = comida.emoji,
                            fontSize = 72.sp,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = comida.nombre,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = detalle.descripcion,
                            fontSize = 14.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                    }
                }
            }

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = null,
                                tint = AzulBarra,
                                modifier = Modifier.size(22.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Nutrition Facts",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = AzulBarra
                            )
                        }
                        Text(
                            text = "Per 100g of food",
                            fontSize = 12.sp,
                            color = Color.Gray,
                            modifier = Modifier.padding(start = 30.dp)
                        )
                        HorizontalDivider(
                            modifier = Modifier.padding(vertical = 10.dp),
                            thickness = 2.dp,
                            color = AzulBarra
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            TarjetaNutriente("Calories", detalle.calorias + " kcal", Modifier.weight(1f))
                            TarjetaNutriente("Proteins", detalle.proteinas, Modifier.weight(1f))
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            TarjetaNutriente("Carbs", detalle.carbohidratos, Modifier.weight(1f))
                            TarjetaNutriente("Good Energy", detalle.grasas, Modifier.weight(1f))
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            TarjetaNutriente("Fiber", detalle.fibra, Modifier.weight(1f))
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }
            }

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
                            .padding(20.dp)
                    ) {
                        Text(
                            text = "How much will you eat?",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = AzulBarra
                        )
                        Text(
                            text = "Enter the portion in grams",
                            fontSize = 13.sp,
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        OutlinedTextField(
                            value = cantidad,
                            onValueChange = { texto ->
                                if (texto.isEmpty() || texto.toIntOrNull() != null) {
                                    cantidad = texto
                                }
                            },
                            label = { Text("Amount") },
                            placeholder = { Text("e.g. 150") },
                            trailingIcon = { Text("g", fontWeight = FontWeight.Bold, color = Color.Gray) },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp)
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = ButtonBlue),
                            shape = RoundedCornerShape(28.dp)
                        ) {
                            Icon(Icons.Default.Add, contentDescription = null)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Add to Log", fontSize = 18.sp)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TarjetaNutriente(etiqueta: String, valor: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5)),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = valor,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = AzulBarra,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = etiqueta,
                fontSize = 12.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
        }
    }
}
