package net.azarquiel.recetas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import net.azarquiel.recetas.R
import net.azarquiel.recetas.model.Categoria

class AdapterCategorias(val context: Context,
                        val layout: Int
) : RecyclerView.Adapter<AdapterCategorias.ViewHolder>() {

    private var dataList: List<Categoria> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewlayout = layoutInflater.inflate(layout, parent, false)
        return ViewHolder(viewlayout, context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    internal fun setCategorias(categorias: List<Categoria>) {
        this.dataList = categorias
        notifyDataSetChanged()
    }

    class ViewHolder(viewlayout: View, val context: Context) : RecyclerView.ViewHolder(viewlayout) {
        fun bind(dataItem: Categoria){
            val ivrowcategoria = itemView.findViewById(R.id.ivRowCategoria) as ImageView
            val tvrowcategoria = itemView.findViewById(R.id.tvRowCategoria) as TextView

            tvrowcategoria.text = dataItem.nombre
            ivrowcategoria.setImageResource(R.drawable.cocinero)

            itemView.tag = dataItem
        }
    }
}