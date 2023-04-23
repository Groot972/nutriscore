package com.example.nutriscore


import NutritionFacts
import NutritionFactsItem
import Product
import ProductFunctions
import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.net.IpPrefix
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.bumptech.glide.Glide


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.accueil_vide)

        //Produit d'exemple
        val product = Product(
            nom = "Jus d'orange",
            marque = "Tropicana",
            codeBarres = "5410056000563",
            nutriscore = Nutriscore.B,
            url_image = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwallpaperaccess.com%2Ffull%2F4075663.jpg&f=1&nofb=1&ipt=1da8819a5b40f9480b00b0c6edfafd18ef8c0c760ed44c5256c8024969fb968a&ipo=images",
            quantity = "1L",
            pays = listOf("Belgique", "Pays-Bas"),
            ingredients = listOf("Jus d'orange concentré", "Eau"),
            allergenes = listOf(),
            additifs = listOf("Acide ascorbique"),
            nutrition =  NutritionFacts(
                calories = NutritionFactsItem("kj", 293.0, 0.0),
                matiere_grasse = NutritionFactsItem("g", 0.0, 0.8),
                acides_gras = NutritionFactsItem("g", 0.1, 1.6),
                glucides = NutritionFactsItem("g", 8.4, 0.0),
                sucres = NutritionFactsItem("g", 5.2, 5.2),
                fibres = NutritionFactsItem("g", 5.2, 0.0),
                proteines = NutritionFactsItem("g", 4.8, 0.0),
                sel = NutritionFactsItem("g", 0.75, 2.0),
                sodium = NutritionFactsItem("g", 0.295, 0.0)
            ))

        /*
        //Vue pour les nutriments du produit
        val pf = ProductFunctions()
        pf.matiereGrasse(product.nutrition.matiere_grasse.quantity_cent, findViewById(R.id.nutri_matiere_grasse_color), findViewById(R.id.nutri_matiere_grasse_number), findViewById(R.id.nutri_matiere_grasse_quantity))
        pf.acidesGras(product.nutrition.acides_gras.quantity_cent, findViewById(R.id.nutri_acides_gras_color),  findViewById(R.id.nutri_acides_gras_number), findViewById(R.id.nutri_acides_gras_quantity))
        pf.sel(product.nutrition.sel.quantity_cent, findViewById(R.id.nutri_sel_color),  findViewById(R.id.nutri_sel_number), findViewById(R.id.nutri_sel_quantity))
        pf.sucre(product.nutrition.sucres.quantity_cent, findViewById(R.id.nutri_sucres_color),  findViewById(R.id.nutri_sucres_number), findViewById(R.id.nutri_sucres_quantity))

        */

        /*
        //Vue pour le detail du produit

        findViewById<TextView>(R.id.product_nom).applyBoldText("Nom", product.nom)
        findViewById<TextView>(R.id.product_marque).applyBoldText("Marque", product.marque)
        findViewById<TextView>(R.id.product_code_barre).applyBoldText("Code-barres", product.codeBarres)
       // findViewById<ImageView>(R.id.product_nutriscore).setImageResource(resources.getIdentifier("nutriscore_${product.nutriscore.letter.lowercase()}", "drawable", packageName))
        findViewById<TextView>(R.id.product_quantity).applyBoldText("Quantité", product.quantity)
        findViewById<TextView>(R.id.product_pays).applyBoldText("Pays", product.pays.joinToString { ", " })
        findViewById<TextView>(R.id.product_ingredients).applyBoldText("Ingrédients", product.ingredients.joinToString { ", " })
        findViewById<TextView>(R.id.product_allergenes).applyBoldText("allèrgènes", product.allergenes.joinToString { ", " })
        findViewById<TextView>(R.id.product_additifs).applyBoldText("Additifs", product.additifs.joinToString { ", " })

        Glide.with(this).load(product.url_image).into(findViewById(R.id.product_url_image))

*/

        /*
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, ListFragment())
            .commitAllowingStateLoss()*/
    }
}

//Texte en gras
fun TextView.applyBoldText(prefix: String, value : String){
    val text = "$prefix : $value"
    val builder = SpannableStringBuilder(text)
    builder.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(":") + 1, 0)
    setText(builder)
}





class ListAdapter(private val listOfPositions: List<String>,
                  val listener: OnProductClickListener,
) : RecyclerView.Adapter<PositionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PositionViewHolder {
        return PositionViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.cell_item, parent, false),
            listener,
        )
    }

    override fun onBindViewHolder(holder: PositionViewHolder, position: Int) {
        holder.updateCell(listOfPositions[position])
    }

    override fun getItemCount(): Int {
        return listOfPositions.size
    }

}
class PositionViewHolder(v: View, val listener: OnProductClickListener) : RecyclerView.ViewHolder(v) {

    private val text : TextView = v.findViewById(R.id.item_text)

    fun updateCell(position: String) {
        itemView.setOnClickListener {
            listener.onProductClicked(position)
        }

        text.text = position
    }

}

interface OnProductClickListener {
    fun onProductClicked(position: String)
}

class ListFragment : Fragment() {

    // Equivalent du setContentView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(requireContext()).inflate(
            R.layout.fragment_list,
            container, false,
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = List(100) {
            "Position ${it + 1}"
        }

        view.findViewById<RecyclerView>(R.id.list).apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ListAdapter(list, object : OnProductClickListener {
                override fun onProductClicked(position: String) {
                    // TODO Ouvrir l'écran
                }
            })
        }
    }
}


