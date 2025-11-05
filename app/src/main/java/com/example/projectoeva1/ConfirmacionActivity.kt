package com.example.projectoeva1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmacionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmacion)

        val tvDatos = findViewById<TextView>(R.id.tvDatos)

        val nombre = intent.getStringExtra("nombre")
        val email = intent.getStringExtra("email")
        val mensaje = intent.getStringExtra("mensaje")

        val texto = """
            Nombre: $nombre
            Correo: $email
            Mensaje: $mensaje
           """.trimIndent()

        tvDatos.text = texto

        val tvMensaje = findViewById<TextView>(R.id.tvMensajeConfirmacion)
        val btnVolver = findViewById<Button>(R.id.btnVolverInicio)

        tvMensaje.text = "Datos guardados con éxito"

        btnVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            // Limpiamos la pila de actividades para volver al inicio
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }
}
