package com.example.examenescursada2023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    // Variables para vincular con la vista
    lateinit var etNota1: EditText
    lateinit var etNota2: EditText
    lateinit var btnPromedio: Button
    lateinit var tvResultado: TextView
    lateinit var toolbar: Toolbar

    // Funcion que se ejecuta al iniciar un Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saludarUsuario()

        etNota1 = findViewById(R.id.editNota1)
        etNota2 = findViewById(R.id.editNota2)
        tvResultado = findViewById(R.id.tvResultado)

        btnPromedio = findViewById(R.id.botonPromedio)
        btnPromedio.setOnClickListener {
            // Obtengo los datos de los campos
            var numero1 = etNota1.text.toString()
            var numero2 = etNota2.text.toString()

            // Hago el calculo
            var promedio = (numero1.toInt() + numero2.toInt()) / 2

            // Lo asigno al lugar correspondiente
            tvResultado.text = promedio.toString()
        }

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = resources.getString(R.string.titulo)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.item_listado){
            val intentListado = Intent(this, ListadoExamenesActivity::class.java)
            startActivity(intentListado)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun saludarUsuario() {
        // Obtengo los datos que me mandaron
        var bundle: Bundle? = intent.extras
        // Reviso que efectivamente tenga datos
        if(bundle != null){
            // Obtengo el dato especifico
            var usuario = bundle?.getString("nombre")
            // Muestro el mensaje
            Toast.makeText(this, "Bienvenido/a $usuario", Toast.LENGTH_SHORT).show()
        }
    }
}