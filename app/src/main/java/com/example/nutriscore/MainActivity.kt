package com.example.nutriscore


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


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, ListFragment())
            .commitAllowingStateLoss()
    }
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
   /*
        val product = Product(
            name = "Petits pois",
            quantity = "450g (310g net egoutté)",
            country = listOf() ,
            barcode = "3083680085304",
            url = "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
            ingredients = listOf(),
            allergenes = listOf(),
            additifs = listOf(),
            nutriscore = Nutriscore.A,


        )

        //Nom du produit
        findViewById<TextView>(R.id.product_name).text = product.name
        //Quantité contenu
        findViewById<TextView>(R.id.quantity).applyBoldText("Quantité", product.quantity)
        //Pays ou le produit est vendu
        findViewById<TextView>(R.id.country).applyBoldText(
            "Vendu en",
            product.country.joinToString { ", " })
        //Code bar
        findViewById<TextView>(R.id.barcode).applyBoldText("Code-barres", product.barcode)
        //Url de l'image du produit
        Glide.with(this).load(product.url)
            .placeholder(R.drawable.placeholder)
            .into(findViewById(R.id.product_image))
        //Nutriscore
        findViewById<ImageView>(R.id.nutriscore).setImageResource(resources.getIdentifier(
            "nutriscore_${product.nutriscore.letter.lowercase()}",
            "drawable",
            packageName,
        ))
        //Ingrédients
        findViewById<TextView>(R.id.ingredients).applyBoldText(
            "Ingrédients",
            product.ingredients.joinToString { ", " })
        //Allergènes
        findViewById<TextView>(R.id.allergenes).applyBoldText(
            "Allergènes",
            product.allergenes.joinToString { ", " })
        //Additifs
        findViewById<TextView>(R.id.additifs).applyBoldText(
            "Additifs",
            product.additifs.joinToString { ", " })



    }
}

data class Product(
    val name : String,
    val quantity: String,
    val country: List<String>,
    val barcode: String,
    val url: String,
    val ingredients: List<String>,
    val allergenes : List<String>,
    val additifs : List<String>,
    val nutriscore: Nutriscore
)

enum class Nutriscore(val letter: String) {
    A("A"), B("B"), C("C"), D("D"), E("E")
}

fun TextView.applyBoldText(prefix: String, value: String) {
    val text = "$prefix : $value"
    val builder = SpannableStringBuilder(text)
    builder.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(":") + 1, 0)
    setText(builder)
} */

