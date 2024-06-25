package org.example


fun main() {
//    products.apply {
//        this.values.forEach {
//            if (!it.isAvailable) {
//                it.isAvailable = true
//            }
//        }
//    }

//    val newProducts = products.filter { it.value.isAvailable }

//    val newItems = items.map {
//        if (it.value.name === "Hojas de oficio") {
//            it.value.isAvailable = true
//        }
//        it
//    }


    items.apply {
        this.values.forEach {
            if (it.name === "Hojas de oficio") {
                it.isAvailable = true
            }
            it.name = it.name.uppercase()
        }
    }

    items[1]?.stock = 100
    items[1]?.isAvailable = true

    items[2]?.stock = 400
    items[2]?.isAvailable = false

    items[3]?.stock = 30
    items[3]?.isAvailable = true

    var total = 0

    items.values.forEach {
        total += it.stock
    }

    val filteredItems = items.filter { !it.value.isAvailable }




    val sortedItems = items.toList().sortedByDescending { (key, value) -> value.stock }.toList()


    sortedItems.forEach {     println("Nombre: ${it.second.name}, Stock: ${it.second.stock} "  )    }
}

data class Item(
    val id: Int,
    var name: String,
    val description: String? = null,
    var isAvailable: Boolean,
    var isEnabled: Boolean = true,
    var stock: Int = 0
)

val items = mapOf(
    1 to Item(1, "Lápiz", null, true),
    2 to Item(2, "Hojas de oficio", null, false),
    3 to Item(1, "Corchetera", null, true),
    4 to Item(4, "Hojas de carta", null, true, true, 400)
)

val products = mapOf(
    1 to Item(id = 100, name = "Item1", isAvailable = true),
    2 to Item(id = 101, name = "Item2", description = "descripción", isAvailable = false),
    3 to Item(
        id = 102, name = "Item3", isAvailable = false, isEnabled = false
    )
)