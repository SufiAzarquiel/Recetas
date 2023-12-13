package net.azarquiel.recetas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import net.azarquiel.recetas.R
import net.azarquiel.recetas.model.Receta

class AdapterRecetas(val context: Context,
                        val layout: Int
) : RecyclerView.Adapter<AdapterRecetas.ViewHolder>() {

    private var dataList: List<Receta> = emptyList()

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

    internal fun setRecetas(Recetas: List<Receta>) {
        this.dataList = Recetas
        notifyDataSetChanged()
    }

    class ViewHolder(viewlayout: View, val context: Context) : RecyclerView.ViewHolder(viewlayout) {
        fun bind(dataItem: Receta){
            val ivrowreceta = itemView.findViewById(R.id.ivRowReceta) as ImageView
            val tvrowreceta = itemView.findViewById(R.id.tvRowReceta) as TextView

            tvrowreceta.text = dataItem.titulo
            ivrowreceta.setImageResource(R.drawable.plato)

            itemView.tag = dataItem
        }
    }
}