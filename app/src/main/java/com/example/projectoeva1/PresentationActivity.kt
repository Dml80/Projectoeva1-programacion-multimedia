package com.example.projectoeva1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PresentationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Asegúrate de que este nombre de layout coincide exactamente con tu archivo XML en res/layout
        setContentView(R.layout.activity_presentation)

        // Busca el botón por su id exacto en el XML
        val btnFormulario = findViewById<Button>(R.id.btnFormularioActivity)

        // Listener para abrir el formulario
        btnFormulario.setOnClickListener {
            val intent = Intent(this@PresentationActivity, FormularioActivity::class.java)
            startActivity(intent)
        }
    }
}
