package com.example.examenescursada2023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.RecyclerView

class ListadoExamenesActivity : AppCompatActivity() {

    lateinit var rvExamenes: RecyclerView
    lateinit var examenesAdapter: ExamenAdapter
    lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_examenes)

        rvExamenes = findViewById(R.id.rvExamenes)
        examenesAdapter = ExamenAdapter(getExamenes(), this)
        rvExamenes.adapter = examenesAdapter

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = resources.getString(R.string.titulo)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_listado, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.item_agregar){
            val intentAgregar = Intent(this, AgregarExamenActivity::class.java)
            startActivity(intentAgregar)
        }
        return super.onOptionsItemSelected(item)
    }
    private fun getExamenes(): MutableList<Examen> {
        var examenes: MutableList<Examen> = ArrayList()
        var bdd = AppDatabase.getDatabase(this)
        examenes.addAll(bdd.examenDao().getAll())
        //examenes.add(Examen("Ingenieria de Software 1", "2022-04-05"))
        /*examenes.add(Examen(2, "Algoritmos y Estructuras de Datos", "2022-04-07"))
        examenes.add(Examen(3, "Prueba de Software", "2022-04-08"))
        examenes.add(Examen(4, "Matematica", "2022-04-10"))
        examenes.add(Examen(5, "Ingenieria de Software 1", "2022-04-05"))
        examenes.add(Examen(6, "Algoritmos y Estructuras de Datos", "2022-04-07"))
        examenes.add(Examen(7, "Prueba de Software", "2022-04-08"))
        examenes.add(Examen(8, "Matematica", "2022-04-10"))
        examenes.add(Examen(9, "Ingenieria de Software 1", "2022-04-05"))
        examenes.add(Examen(10, "Ingenieria de Software 1", "2022-04-05"))
        examenes.add(Examen(11, "Ingenieria de Software 1", "2022-04-05"))
        examenes.add(Examen(12, "Algoritmos y Estructuras de Datos", "2022-04-07"))
        examenes.add(Examen(13, "Prueba de Software", "2022-04-08"))
        examenes.add(Examen(14, "Matematica", "2022-04-10"))
        examenes.add(Examen(15, "Ingenieria de Software 1", "2022-04-05"))
        examenes.add(Examen(16, "Algoritmos y Estructuras de Datos", "2022-04-07"))
        examenes.add(Examen(17, "Prueba de Software", "2022-04-08"))
        examenes.add(Examen(18, "Matematica", "2022-04-10"))*/
        return examenes

    }
}