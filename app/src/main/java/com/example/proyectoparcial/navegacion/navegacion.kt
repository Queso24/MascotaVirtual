package com.example.proyectoparcial.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectoparcial.clases.RegistroGlucosa
import com.example.proyectoparcial.pantallas.GlucosaView
import com.example.proyectoparcial.pantallas.MenuInicialView
import com.example.proyectoparcial.pantallas.RegistroComidasView
import com.example.proyectoparcial.pantallas.RegistroEstadisticasView

sealed class Rutas(val ruta: String) { //La usamos para tener una jerarquía de rutas definida
    // y evitar errores al escribir los nombres de las pantallas
    object Menu : Rutas("menu")
    object RegistroGlucosa : Rutas("registro_glucosa")
    object RegistroComidas : Rutas("registro_comidas")
    object RegistroEstadisticas : Rutas("registro_estadisticas")

}

@Composable
fun navegacion() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Rutas.Menu.ruta // La app siempre abre en el Menú
    ) {
        // El menu principal
        composable(Rutas.Menu.ruta) {
            // Aquí llamas a tu función de la pantalla del Menú
            // Debes pasarle el navController para que los botones puedan navegar
            MenuInicialView(navController = navController)
        }

        // Pantalla 2: Registro de Glucosa
        composable(Rutas.RegistroGlucosa.ruta) {
            // Aquí llamas a tu función del formulario de glucosa
            GlucosaView(navController = navController)
        }
        // Pantalla 3: Registro de Comida
        composable(route = Rutas.RegistroComidas.ruta) {
            RegistroComidasView(navController = navController)
        }
        // Pantalla 4: Registro de estadísticas
        composable(route = Rutas.RegistroEstadisticas.ruta) {
            RegistroEstadisticasView(navController = navController)
        }

    }
}