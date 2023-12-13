package net.azarquiel.recetas.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import net.azarquiel.recetas.R
import net.azarquiel.recetas.adapter.AdapterRecetas
import net.azarquiel.recetas.databinding.ActivityRecetasBinding
import net.azarquiel.recetas.model.Categoria
import net.azarquiel.recetas.model.Receta
import net.azarquiel.recetas.viewmodel.RecetaViewModel

class RecetasActivity : AppCompatActivity() {

    private lateinit var recetaViewModel: RecetaViewModel
    private lateinit var adapterRecetas: AdapterRecetas
    private lateinit var binding: ActivityRecetasBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecetasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val categoria = intent.getSerializableExtra("categoria") as Categoria
        setTitle(categoria.nombre)

        initRV()
        getDatos()
    }

    private fun getDatos() {
        recetaViewModel = ViewModelProvider(this).get(RecetaViewModel::class.java)
        recetaViewModel.getAllRecetas().observe(this, Observer { recetas ->
            // Update the cached copy of the recetas in the adapter.
            recetas?.let { adapterRecetas.setRecetas(it) }
        })
    }

    private fun initRV() {
        adapterRecetas = AdapterRecetas(this, R.layout.row_recetas)
        binding.contentrecetas.rvRecetas.adapter = adapterRecetas
        binding.contentrecetas.rvRecetas.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_recetas, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_next -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun onClickReceta(v: View) {
        var receta = v.tag as Receta
        val intent = Intent(this, DetalleActivity::class.java)
        intent.putExtra("receta", receta)
        startActivity(intent)
    }
}