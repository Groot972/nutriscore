data class Product(
    val nom: String,
    val marque: String,
    val codeBarres: String,
    val nutriscore: Nutriscore,
    val url_image: String,
    val quantity: String,
    val pays: List<String>,
    val ingredients: List<String>,
    val allergenes: List<String>,
    val additifs: List<String>,
    val nutrition : NutritionFacts
)
