package com.example.examenescursada2023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class AgregarExamenActivity : AppCompatActivity() {
    lateinit var toolbar: Toolbar
    lateinit var etMateria: EditText
    lateinit var etFecha: EditText
    lateinit var btnAgregar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_examen)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = resources.getString(R.string.boton_agregar)

        etMateria = findViewById(R.id.etMateria)
        etFecha = findViewById(R.id.etFecha)
        btnAgregar = findViewById(R.id.btnGuardar)

        btnAgregar.setOnClickListener {
            var materia = etMateria.text.toString()
            var fecha = etFecha.text.toString()
            if(materia.isEmpty() || fecha.isEmpty()){
                Toast.makeText(this,"Es necesario completar los datos", Toast.LENGTH_SHORT).show()
            } else {
                var nuevoExamen = Examen(materia, fecha)
                AppDatabase.getDatabase(this).examenDao().insertExamen(nuevoExamen)
                var intentListado = Intent(this, ListadoExamenesActivity::class.java)
                startActivity(intentListado)
            }
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_agregar_examen, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.item_volver){
            val intent = Intent(this, ListadoExamenesActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

}