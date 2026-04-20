package com.example.proyectoparcial.pantallas
import android.R.attr.onClick
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.proyectoparcial.R
import com.example.proyectoparcial.navegacion.Rutas

// Colores del diseño
val BackgroundLight = Color(0xFFE0F7F9)
val CardYellow = Color(0xFFFFF59D)
val CardBlue = Color(0xFF81D4FA)
val CardGreen = Color(0xFFA5D6A7)
val GradientPink = Brush.linearGradient(listOf(Color(0xFFF48FB1), Color(0xFFFFCC80)))

@Composable

//@Preview(showBackground = true)
fun MenuInicialView(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // --- ENCABEZADO (Tarjetas Pequeñas) ---
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SmallInfoCard(Icons.Default.Favorite, "85%", Color(0xFF5C6BC0),onClick = { })
            SmallInfoCard(Icons.Default.Info, "110 mg/dL", Color(0xFF5C6BC0),onClick = { })
        }

        Spacer(modifier = Modifier.height(30.dp))

        // --- MASCOTA ---
        Image(
            painter = painterResource(id = R.drawable.tamagochi),
            contentDescription = "Pet",
            modifier = Modifier.size(280.dp)
        )

        // --- BURBUJA DE ESTADO ---
        Card(
            shape = CircleShape,
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(2.dp, Color(0xFFFFEB3B)),
            elevation = CardDefaults.cardElevation(2.dp)
        ) {
            Text(
                text = "¡I feel great today!! 😊",
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 10.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        // --- GRID DE ACCIONES ---
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                StandardActionCard("Check Glucose", "Log your level", CardBlue, Icons.Default.Info, onClick = { navController.navigate(Rutas.RegistroGlucosa.ruta)}, Modifier.weight(1f))
                StandardActionCard("Meals", "What did you eat?", CardYellow, Icons.Default.Info, onClick = { navController.navigate(Rutas.RegistroComidas.ruta)}, Modifier.weight(1f))
            }
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                StandardActionCard("Statistics", "Your numbers", Color.Transparent, Icons.Default.Info, onClick = { navController.navigate(Rutas.RegistroEstadisticas.ruta)}, Modifier.weight(1f), brush = GradientPink)
                StandardActionCard("My Pet", "Customize it", CardGreen, Icons.Default.Info, onClick = { navController.navigate(Rutas.RegistroGlucosa.ruta)}, Modifier.weight(1f))
            }
        }
    }
}

// Carta pequeña del encabezado
@Composable
fun SmallInfoCard(icon: ImageVector, value: String, color: Color,onClick: () -> Unit) {
    Card(
        modifier = Modifier.size(width = 110.dp, height = 75.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(icon, contentDescription = null, tint = color, modifier = Modifier.size(24.dp))
            Text(text = value, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }
    }
}

// Carta normal para las acciones de abajo
@Composable
fun StandardActionCard(
    title: String,
    subtitle: String,
    bgColor: Color,
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    brush: Brush? = null
) {
    Card(
        modifier = modifier.height(150.dp).clickable { onClick() },
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .then(if (brush != null) Modifier.background(brush) else Modifier.background(bgColor))
                .padding(16.dp)
        ) {
            Column {
                Icon(icon, contentDescription = null, modifier = Modifier.size(32.dp), tint = Color.Black)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = title, fontWeight = FontWeight.ExtraBold, fontSize = 16.sp, color = Color.Black)
                Text(text = subtitle, fontSize = 12.sp, color = Color.DarkGray)
            }
        }
    }
}