package com.example.examenescursada2023

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ExamenAdapter(var examenes: MutableList<Examen>, var context: Context):
RecyclerView.Adapter<ExamenAdapter.ExamenViewHolder>(){


    override fun onBindViewHolder(holder: ExamenViewHolder, position: Int) {
        val item = examenes.get(position)
        holder.txMateria.text = item.materia
        holder.txFecha.text = item.fecha
        holder.itemView.setOnClickListener( View.OnClickListener {
            Toast.makeText(context, item.materia, Toast.LENGTH_SHORT).show()
        })

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExamenViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_examen, parent, false)

        return ExamenViewHolder(view)
    }

    override fun getItemCount() = examenes.size

    class ExamenViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txMateria: TextView
        val txFecha: TextView

        init {
            txMateria = view.findViewById(R.id.tvMateria)
            txFecha = view.findViewById(R.id.tvFecha)
        }
    }


}