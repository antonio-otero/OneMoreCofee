package com.example.onemorecofee

import android.os.Bundle
import android.widget.Spinner
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. Enlazar vistas por ID
        val spTipoCafe = findViewById<Spinner>(R.id.spTipoCafe)
        val btnRecomendar = findViewById<Button>(R.id.btnRecomendar)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        //Chequeo de eventos/Acciones con Toast --> Equivalente a salida consola
       /* btnRecomendar.setOnClickListener {
            Toast.makeText(this, "Pulsado", Toast.LENGTH_SHORT).show()

        */
       btnRecomendar.setOnClickListener {

           // 3. Leer la selección: el texto para mostrarlo, la posición para decidir
           val tipoSeleccionado = spTipoCafe.selectedItem.toString()
           val recomendaciones = obtenerCafesRecomendados(spTipoCafe.selectedItemPosition)


         // 4. Componer y mostrar el resultado
           tvResultado.text = recomendaciones.joinToString(
               separator = "\n",
               prefix = "$tipoSeleccionado:\n")
           { "• $it" }
       }
    }

    /** https://pl.kotl.in/dsY2q3ZoD
     * Función de recomendación, análoga a getWines del temario.
     * Devuelve las sugerencias según la posición elegida en el desplegable.
     */
    private fun obtenerCafesRecomendados(posicion: Int): List<String> =
        when (posicion) {
            0 -> listOf("Espresso doble ristretto", "Café solo de arábica")
            1 -> listOf("Capuchino con vainilla", "Mocaccino con caramelo")
            2 -> listOf("Cold brew con hielo", "Frappé clásico")
            else -> listOf("Café con leche de toda la vida")
        }

}












