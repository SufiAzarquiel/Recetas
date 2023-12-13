package net.azarquiel.recetas.database

import android.app.Application
import androidx.lifecycle.LiveData
import net.azarquiel.recetas.model.Categoria
import net.azarquiel.recetas.model.Receta

class RecetaRepository(application: Application) {

    val recetaDao = RecetasDB.getDatabase(application).recetaDao()
    // select
    fun getAllRecetas(): LiveData<List<Receta>> {
        return recetaDao.getAllRecetas()
    }
    fun getRecetasByCategoria(categoria : Int): LiveData<List<Receta>> {
        return recetaDao.getRecetasByCategoria(categoria)
    }
}

class CategoriaRepository(application: Application) {

    val categoriaDao = RecetasDB.getDatabase(application).categoriaDao()
    // select
    fun getAllCategorias(): LiveData<List<Categoria>> {
        return categoriaDao.getAllCategorias()
    }
    fun getCategoriaById(id : Int): LiveData<Categoria> {
        return categoriaDao.getCategoriaById(id)
    }
}