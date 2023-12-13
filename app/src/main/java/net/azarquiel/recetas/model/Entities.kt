package net.azarquiel.recetas.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "receta")
data class Receta(
    @PrimaryKey
    var id: Int,
    var categoria: Int,
    var titulo: String,
    var foto: String,
    var pasos: String,
    var ingredientes: String,
    var comensales: String,
    var dificultad: String,
    var precio: String,
    var tiempo: String): Serializable

@Entity(tableName = "categoria")
data class Categoria(
    @PrimaryKey
    var id: Int,
    var nombre:String): Serializable