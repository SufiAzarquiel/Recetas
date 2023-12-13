package net.azarquiel.recetas.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import net.azarquiel.recetas.R
import net.azarquiel.recetas.adapter.AdapterCategorias
import net.azarquiel.recetas.databinding.ActivityMainBinding
import net.azarquiel.recetas.model.Categoria
import net.azarquiel.recetas.util.Util
import net.azarquiel.recetas.viewmodel.CategoriaViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var adapterCategorias: AdapterCategorias
    private lateinit var categoriaViewModel: CategoriaViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        Util.inyecta(this, "recetas.db")
        initRV()
        getDatos()
    }

    private fun getDatos() {
        categoriaViewModel = ViewModelProvider(this).get(CategoriaViewModel::class.java)
        categoriaViewModel.getAllCategorias().observe(this, Observer { categorias ->
            // Update the cached copy of the categorias in the adapter.
            categorias?.let { adapterCategorias.setCategorias(it) }
        })
    }

    private fun initRV() {
        adapterCategorias = AdapterCategorias(this, R.layout.row_categoria)
        binding.contentcategorias.rvCategorias.adapter = adapterCategorias
        binding.contentcategorias.rvCategorias.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun onClickCategoria(v: View) {
        var categoria = v.tag as Categoria
        val intent = Intent(this, RecetasActivity::class.java)
        intent.putExtra("categoria", categoria)
        startActivity(intent)
    }
}