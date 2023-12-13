package net.azarquiel.recetas.view

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.Html
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.azarquiel.recetas.databinding.ActivityDetalleBinding
import net.azarquiel.recetas.model.Receta


class DetalleActivity : AppCompatActivity() {

    private lateinit var receta: Receta
    private lateinit var binding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        receta = intent.getSerializableExtra("receta") as Receta
        val titulo =  if (receta.titulo.length > 20) receta.titulo.substring(0, 20) + "..." else receta.titulo
        title = titulo

        setDatos()
    }

    private fun setDatos() {
        binding.contentdetalle.tvDetalleTitulo.text = receta.titulo

        binding.contentdetalle.tvDetalleComensales.setRedBoldText("Comensales:", receta.comensales)
        binding.contentdetalle.tvDetalleDificultad.setRedBoldText("Dificultad:", receta.dificultad)
        binding.contentdetalle.tvDetallePrecio.setRedBoldText("Precio:", receta.precio)
        binding.contentdetalle.tvDetalleTiempo.setRedBoldText("Tiempo:", receta.tiempo)
        binding.contentdetalle.tvDetallePasos.setRedBoldTextHtml("Pasos:", receta.pasos)
        binding.contentdetalle.tvDetalleIngredientes.setRedBoldTextHtml("Ingredientes:", receta.ingredientes)
    }

    fun TextView.setRedBoldText(label: String, value: String) {
        val redColor = Color.RED

        val labelSpannable = SpannableString("$label ")
        labelSpannable.setSpan(ForegroundColorSpan(redColor), 0, label.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        labelSpannable.setSpan(StyleSpan(Typeface.BOLD), 0, label.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        val builder = SpannableStringBuilder().append(labelSpannable).append(value)

        this.text = builder
    }

    fun TextView.setRedBoldTextHtml(label: String, value: String) {
        val redColor = Color.RED

        val labelSpannable = SpannableString("$label ")
        labelSpannable.setSpan(ForegroundColorSpan(redColor), 0, label.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        labelSpannable.setSpan(StyleSpan(Typeface.BOLD), 0, label.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        val builder = SpannableStringBuilder().append(labelSpannable)

        val htmlContent = Html.fromHtml(value, Html.FROM_HTML_MODE_LEGACY)
        builder.append(htmlContent)

        this.text = builder
    }
}