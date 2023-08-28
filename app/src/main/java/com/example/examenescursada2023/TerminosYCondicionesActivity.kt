package com.example.examenescursada2023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TerminosYCondicionesActivity : AppCompatActivity() {

    lateinit var btnAceptarTerminos : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terminos_ycondiciones)

        btnAceptarTerminos = findViewById(R.id.btn_aceptarTerminos)
        btnAceptarTerminos.setOnClickListener {
            var intentLogin = Intent(this, LoginActivity::class.java)
            startActivity(intentLogin)
            finish()
        }
    }
}