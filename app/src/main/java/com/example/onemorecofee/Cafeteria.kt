package com.example.onemorecofee


import androidx.annotation.DrawableRes

object Cafeteria {
    private val catalogo: Map<Int, List<Cafe>> = mapOf(
        0 to listOf(
            Cafe(
                "Espresso doble ristretto",
                "Extracción curta e concentrada, con moi pouca auga.",
                5, R.drawable.cafe_ristretto
            ),
            Cafe(
                "Café só de arábica",
                "Menos amargo ca o robusta, con notas afroitadas.",
                4, R.drawable.cafe_arabica
            )
        ),
        1 to listOf(
            Cafe(
                "Capuchino con vainilla",
                "Un terzo de café, un terzo de leite e un terzo de escuma.",
                2, R.drawable.cafe_capuchino
            ),
            Cafe(
                "Mocaccino con caramelo",
                "Café con chocolate e leite, para quen non quere notar o café.",
                1, R.drawable.cafe_mocaccino
            )
        ),
        2 to listOf(
            Cafe(
                "Cold brew con xeo",
                "Infusión en frío durante doce horas. Sen amargor.",
                3, R.drawable.cafe_cold_brew
            ),
            Cafe(
                "Frappé clásico",
                "Café batido con xeo ata facer escuma.",
                2, R.drawable.cafe_frappe
            )
        )
    )
    private val porDefecto = listOf(
        Cafe(
            "Café con leite de toda a vida",
            "O de sempre. Non falla nunca.",
            3, R.drawable.cafe_leite
        )
    )
    fun recomendacions(tipo: Int): List<Cafe> = catalogo[tipo] ?: porDefecto
    fun cafe(tipo: Int, indice: Int): Cafe = recomendacions(tipo)[indice]
    @DrawableRes
    fun imaxeTipo(tipo: Int): Int =
        when (tipo) {
            0 -> R.drawable.cabeceira_intenso
            1 -> R.drawable.cabeceira_suave
            2 -> R.drawable.cabeceira_frio
            else -> R.drawable.cabeceira_sorpresa
        }
}
