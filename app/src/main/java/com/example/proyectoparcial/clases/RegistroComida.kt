package com.example.proyectoparcial.clases

data class RegistroComida(
    val id: String = java.util.UUID.randomUUID().toString(),
    val nombreAlimento: String,
    val categoria: CategoriaComida,
    val fechaHora: Long = System.currentTimeMillis()
)

enum class CategoriaComida {
    SALUDABLE,
    MODERACION,
    NO_SALUDABLE
}
