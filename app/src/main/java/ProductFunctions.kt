import android.content.res.ColorStateList
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.example.nutriscore.R

class ProductFunctions {

    //Determiner la couleur du cercle pour la matiere grasse  :
    fun matiereGrasse(value: Double, boutonView: View, numberView: TextView, quantityView: TextView) {

        when (value) {
            in 0.0..3.0 -> {
                DrawableCompat.setTintList(boutonView.background, ColorStateList.valueOf(
                    ContextCompat.getColor(boutonView.context, R.color.nutrient_level_low)))
                //Quantité pour 100g ou 100ml
                numberView.apply {
                    val montext = "$value g Matière grasse / Lipides"
                    text = montext
                }
                //Faible, forte, moyenne quantité
                quantityView.apply {
                    val montext = "En faible quantité"
                    text = montext
                }
            }
            in 3.0..20.0 -> {
                DrawableCompat.setTintList(boutonView.background, ColorStateList.valueOf(
                    ContextCompat.getColor(boutonView.context, R.color.nutrient_level_moderate)))
                numberView.apply {
                    val montext = "$value g Matière grasse / Lipides"
                    text = montext
                }
                quantityView.apply {
                    val montext = "En quantité modérée"
                    text = montext
                }
            }
            else -> {
                DrawableCompat.setTintList(boutonView.background, ColorStateList.valueOf(
                    ContextCompat.getColor(boutonView.context, R.color.nutrient_level_high)))
                numberView.apply {
                    val montext = "$value g Matière grasse / Lipides"
                    text = montext
                }
                //Faible, forte, moyenne quantité
                quantityView.apply {
                    val montext = "En quantité élevée"
                    text = montext
                }
            }
        }
    }

    //Determiner la couleur du cercle pour les acides gras  :
    fun acidesGras(value: Double, boutonView: View, numberView: TextView, quantityView: TextView) {

        when (value) {
            in 0.0..1.5 -> {
                DrawableCompat.setTintList(boutonView.background, ColorStateList.valueOf(
                    ContextCompat.getColor(boutonView.context, R.color.nutrient_level_low)))
                //Quantité pour 100g ou 100ml
                numberView.apply {
                    val montext = "$value g d'acides gras saturés"
                    text = montext
                }
                //Faible, forte, moyenne quantité
                quantityView.apply {
                    val montext = "En faible quantité"
                    text = montext
                }
            }
            in 1.5..5.0 -> {
                DrawableCompat.setTintList(boutonView.background, ColorStateList.valueOf(
                    ContextCompat.getColor(boutonView.context, R.color.nutrient_level_moderate)))
                numberView.apply {
                    val montext = "$value g d'acides gras saturés"
                    text = montext
                }
                quantityView.apply {
                    val montext = "En quantité modérée"
                    text = montext
                }
            }
            else -> {
                DrawableCompat.setTintList(boutonView.background, ColorStateList.valueOf(
                    ContextCompat.getColor(boutonView.context, R.color.nutrient_level_high)))
                numberView.apply {
                    val montext = "$value g d'acides gras saturés"
                    text = montext
                }
                //Faible, forte, moyenne quantité
                quantityView.apply {
                    val montext = "En quantité élevée"
                    text = montext
                }
            }
        }
    }

    //Determiner la couleur du cercle pour le sucre  :
    fun sucre(value: Double, boutonView: View, numberView: TextView, quantityView: TextView) {

        when (value) {
            in 0.0..5.0 -> {
                DrawableCompat.setTintList(boutonView.background, ColorStateList.valueOf(
                    ContextCompat.getColor(boutonView.context, R.color.nutrient_level_low)))
                //Quantité pour 100g ou 100ml
                numberView.apply {
                    val montext = "$value g de sucre"
                    text = montext
                }
                //Faible, forte, moyenne quantité
                quantityView.apply {
                    val montext = "En faible quantité"
                    text = montext
                }
            }
            in 5.0..12.5 -> {
                DrawableCompat.setTintList(boutonView.background, ColorStateList.valueOf(
                    ContextCompat.getColor(boutonView.context, R.color.nutrient_level_moderate)))
                numberView.apply {
                    val montext = "$value g de sucre"
                    text = montext
                }
                quantityView.apply {
                    val montext = "En quantité modérée"
                    text = montext
                }
            }
            else -> {
                DrawableCompat.setTintList(boutonView.background, ColorStateList.valueOf(
                    ContextCompat.getColor(boutonView.context, R.color.nutrient_level_high)))
                numberView.apply {
                    val montext = "$value g de sucre"
                    text = montext
                }
                //Faible, forte, moyenne quantité
                quantityView.apply {
                    val montext = "En quantité élevée"
                    text = montext
                }
            }
        }
    }

    //Determiner la couleur du cercle pour le sel  :
    fun sel(value: Double, boutonView: View, numberView: TextView, quantityView: TextView) {

        when (value) {
            in 0.0..0.3 -> {
                DrawableCompat.setTintList(boutonView.background, ColorStateList.valueOf(
                    ContextCompat.getColor(boutonView.context, R.color.nutrient_level_low)))
                //Quantité pour 100g ou 100ml
                numberView.apply {
                    val montext = "$value g de sel"
                    text = montext
                }
                //Faible, forte, moyenne quantité
                quantityView.apply {
                    val montext = "En faible quantité"
                    text = montext
                }
            }
            in 0.3..1.5 -> {
                DrawableCompat.setTintList(boutonView.background, ColorStateList.valueOf(
                    ContextCompat.getColor(boutonView.context, R.color.nutrient_level_moderate)))
                numberView.apply {
                    val montext = "$value g de sel"
                    text = montext
                }
                quantityView.apply {
                    val montext = "En quantité modérée"
                    text = montext
                }
            }
            else -> {
                DrawableCompat.setTintList(boutonView.background, ColorStateList.valueOf(
                    ContextCompat.getColor(boutonView.context, R.color.nutrient_level_high)))
                numberView.apply {
                    val montext = "$value g de sel"
                    text = montext
                }
                //Faible, forte, moyenne quantité
                quantityView.apply {
                    val montext = "En quantité élevée"
                    text = montext
                }
            }
        }
    }

}