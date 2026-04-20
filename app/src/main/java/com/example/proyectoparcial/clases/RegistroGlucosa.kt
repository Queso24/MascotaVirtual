package com.example.proyectoparcial.clases

data class RegistroGlucosa(
    val id: String = java.util.UUID.randomUUID().toString(), //etiqueta única
    val valor: Int,
    val fechaHora: Long,
    val estado: EstadoGlucosa
)

//Enum Class nos ayudará a cambiar fácilmente el color de la mascota o de las gráficas
enum class EstadoGlucosa {
    BAJA,    // Menor a 70 mg/dL
    NORMAL,  // Entre 70 y 180 mg/dL
    ALTA     // Mayor a 180 mg/dL
}
