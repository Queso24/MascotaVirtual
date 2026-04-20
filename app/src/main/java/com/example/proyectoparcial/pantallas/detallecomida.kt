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
        "Ensalada"    -> DetalleComida("Mezcla de vegetales frescos, baja en calorías y rica en vitaminas esenciales.", "25", "1.5g", "4g", "0.3g", "2g")
        "Frutas"      -> DetalleComida("Fuente natural de azúcares, vitaminas y antioxidantes que protegen el organismo.", "60", "0.8g", "15g", "0.2g", "2.5g")
        "Verduras"    -> DetalleComida("Alto contenido en vitaminas, minerales y fibra dietética para una digestión saludable.", "35", "2g", "7g", "0.3g", "3g")
        "Pollo"       -> DetalleComida("Proteína magra de alta calidad, bajo en grasa saturada e ideal para el músculo.", "165", "31g", "0g", "3.6g", "0g")
        "Pescado"     -> DetalleComida("Rico en omega-3 y proteínas de alto valor biológico que benefician el corazón.", "120", "22g", "0g", "3g", "0g")
        "Agua"        -> DetalleComida("Esencial para la hidratación y el correcto funcionamiento de todos los órganos.", "0", "0g", "0g", "0g", "0g")
        "Avena"       -> DetalleComida("Cereal integral con alto contenido de fibra que brinda energía sostenida al cuerpo.", "389", "17g", "66g", "7g", "10g")
        "Huevo"       -> DetalleComida("Fuente completa de proteínas con todos los aminoácidos esenciales que necesitas.", "143", "13g", "1g", "10g", "0g")
        "Pizza"       -> DetalleComida("Alta en sodio y grasas saturadas, se recomienda consumirla de forma ocasional.", "266", "11g", "33g", "10g", "2g")
        "Pasta"       -> DetalleComida("Buena fuente de carbohidratos, se recomienda preferir la versión integral.", "220", "8g", "43g", "1.3g", "2.5g")
        "Pan"         -> DetalleComida("Carbohidrato simple de fácil digestión, mejor consumirlo en versión integral.", "265", "9g", "49g", "3.2g", "2.7g")
        "Arroz"       -> DetalleComida("Fuente de energía rápida; elige la versión integral para mayor valor nutricional.", "130", "2.7g", "28g", "0.3g", "0.4g")
        "Queso"       -> DetalleComida("Rico en calcio y proteínas, pero con alto contenido de grasas saturadas.", "402", "25g", "1.3g", "33g", "0g")
        "Jugo"        -> DetalleComida("Aporta vitaminas pero es alto en azúcar y carece de la fibra de la fruta entera.", "90", "0.7g", "22g", "0.2g", "0.5g")
        "Refresco"    -> DetalleComida("Sin valor nutricional real, muy alto en azúcar y aditivos artificiales dañinos.", "140", "0g", "39g", "0g", "0g")
        "Frituras"    -> DetalleComida("Alta densidad calórica con grasas trans y sodio en exceso, evita su consumo.", "547", "6g", "57g", "35g", "4g")
        "Dulces"      -> DetalleComida("Calorías vacías sin ningún nutriente esencial que elevan el azúcar en sangre.", "390", "0g", "98g", "0g", "0g")
        "Hamburguesa" -> DetalleComida("Alta en grasas saturadas, sodio y calorías; su consumo frecuente es perjudicial.", "295", "17g", "24g", "14g", "1g")
        "Alcohol"     -> DetalleComida("Sin valor nutricional, daña el hígado y el sistema nervioso central con el tiempo.", "231", "0g", "3.5g", "0g", "0g")
        "Azúcar"      -> DetalleComida("Calorías completamente vacías que aumentan el riesgo de desarrollar diabetes.", "387", "0g", "100g", "0g", "0g")
        else          -> DetalleComida("Alimento registrado en el sistema. Consulta a tu nutricionista para más detalles.", "—", "—", "—", "—", "—")
    }
}

@Composable
@Preview(showBackground = true)
fun DetalleComidaView(
    comida: ComidaItem = ComidaItem("Ensalada", "🥗")
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
                                text = "Datos Nutricionales",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = AzulBarra
                            )
                        }
                        Text(
                            text = "Por cada 100g de alimento",
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
                            TarjetaNutriente("Calorías", detalle.calorias + " kcal", Modifier.weight(1f))
                            TarjetaNutriente("Proteínas", detalle.proteinas, Modifier.weight(1f))
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            TarjetaNutriente("Carbohidratos", detalle.carbohidratos, Modifier.weight(1f))
                            TarjetaNutriente("Grasas", detalle.grasas, Modifier.weight(1f))
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            TarjetaNutriente("Fibra", detalle.fibra, Modifier.weight(1f))
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
                            text = "¿Cuánto vas a consumir?",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = AzulBarra
                        )
                        Text(
                            text = "Ingresa la porción en gramos",
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
                            label = { Text("Cantidad") },
                            placeholder = { Text("ej. 150") },
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
                            Text("Agregar al Registro", fontSize = 18.sp)
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
