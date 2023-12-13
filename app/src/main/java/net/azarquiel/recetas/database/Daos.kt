package net.azarquiel.recetas.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import net.azarquiel.recetas.model.Categoria
import net.azarquiel.recetas.model.Receta

@Dao
interface RecetaDao {
    @Query("SELECT * FROM receta ORDER BY categoria ASC")
    fun getAllRecetas(): LiveData<List<Receta>>

    @Query("SELECT * FROM receta WHERE categoria = :categoria ORDER BY categoria ASC")
    fun getRecetasByCategoria(categoria: Int): LiveData<List<Receta>>
}

@Dao
interface CategoriaDao {
    @Query("SELECT * from categoria ORDER BY id ASC")
    fun getAllCategorias(): LiveData<List<Categoria>>

    @Query("SELECT * from categoria where id = :id ORDER BY id ASC")
    fun getCategoriaById(id:Int): LiveData<Categoria>
}