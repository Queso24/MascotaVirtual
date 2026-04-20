package com.example.proyectoparcial.clases

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Creamos la instancia de DataStore
val Context.dataStore by preferencesDataStore(name = "configuracion_mascota")

object PreferenciasMascota {
    // Definimos la llave para el nombre
    private val LLAVE_NOMBRE = stringPreferencesKey("nombre_mascota")

    // Función para guardar el nombre (suspend porque DataStore es asíncrono)
    suspend fun guardarNombre(context: Context, nombre: String) {
        context.dataStore.edit { preferencias ->
            preferencias[LLAVE_NOMBRE] = nombre
        }
    }

    // Función para leer el nombre como un Flow
    fun leerNombre(context: Context): Flow<String> {
        return context.dataStore.data.map { preferencias ->
            // Si no hay nada guardado, devolvemos "Nina" por defecto
            preferencias[LLAVE_NOMBRE] ?: "Nina"
        }
    }
}