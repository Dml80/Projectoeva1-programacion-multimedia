package com.example.projectoeva1

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FormularioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etMensaje = findViewById<EditText>(R.id.etMensaje)
        val btnEnviar = findViewById<Button>(R.id.btnEnviar)

        btnEnviar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val mensaje = etMensaje.text.toString().trim()

            // Validaciones
            if (nombre.isEmpty() || email.isEmpty() || mensaje.isEmpty()) {
                Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Correo no válido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Guardar datos
            val prefs = getSharedPreferences("DatosUsuario", MODE_PRIVATE)
            val editor = prefs.edit()
            editor.putString("nombre", nombre)
            editor.putString("email", email)
            editor.putString("mensaje", mensaje)
            editor.apply()

    // Pasar datos y abrir pantalla de confirmación
            val intent = Intent(this, ConfirmacionActivity::class.java)
            intent.putExtra("nombre", nombre)
            intent.putExtra("email", email)
            intent.putExtra("mensaje", mensaje)
            startActivity(intent)




            // Limpia los campos
            etNombre.text.clear()
            etEmail.text.clear()
            etMensaje.text.clear()
        }
    }
}
