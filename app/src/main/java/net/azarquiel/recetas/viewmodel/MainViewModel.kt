package net.azarquiel.recetas.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import net.azarquiel.recetas.database.CategoriaRepository
import net.azarquiel.recetas.database.RecetaRepository
import net.azarquiel.recetas.model.Categoria
import net.azarquiel.recetas.model.Receta

class RecetaViewModel (application: Application) : AndroidViewModel(application) {

    private var repository: RecetaRepository = RecetaRepository(application)

    fun getAllRecetas(): LiveData<List<Receta>> {
        return repository.getAllRecetas()
    }

    fun getRecetasByCategoria(categoria: Int): LiveData<List<Receta>> {
        return repository.getRecetasByCategoria(categoria)
    }
}

class CategoriaViewModel (application: Application) : AndroidViewModel(application) {

    private var repository: CategoriaRepository = CategoriaRepository(application)

    fun getAllCategorias(): LiveData<List<Categoria>>{
        return repository.getAllCategorias()
    }

    fun getCategoriaById(id: Int): LiveData<Categoria>{
        return repository.getCategoriaById(id)
    }
}