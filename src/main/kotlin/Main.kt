package com.desafiolatam

import com.sun.org.apache.xpath.internal.operations.Bool

data class Product(
    val id: Int,
    var name: String,
    val description: String?,
    var isAvailable: Boolean = true,
    var isEnable: Boolean = true,
    var stock: Int = 0,
)

/**
- Cambiar todos los nombres de producto a mayúscula (2 Puntos)
- Cuando la descripción sea nula, entonces reemplazar con "N/A" (1 Puntos)
- Cuando un valor sea true, entonces mostrar "SI" (2 Puntos)
- Cuando un valor sea false, entonces mostrar con "NO" (1 Puntos)
- Cuando el stock sea cero (0), entonces mostrar "Sin Stock" (1 Puntos)
- Ordena los resultados por stock descendiente (2 Puntos)
- Entregar un archivo .kt con el nombre del desafío más el nombre y apellido del alumno, ejemplo: desafio2_NombreApellido.kt (1 Puntos
 */

fun main() {

    val products = populateData()

    products.forEach {
        println("+++++++++++++++++++++++++++++++++++++++++++++")
        val product = it.value
        if (product != null) {
            println(
                "ID: ${product.id} " +
                        "\nNOMBRE: ${product.name.uppercase()} " +
                        "\nDESCRIPCIÓN: ${isDescriptionNull(product.description)} " +
                        "\nDISPONIBLE: ${booleanToString(product.isAvailable)} " +
                        "\nHABILITADO ${booleanToString(product.isEnable)} " +
                        "\nSTOCK: ${outOfStock(product.stock)}"
            )
        }
        println("+++++++++++++++++++++++++++++++++++++++++++++")
    }
}

/**
 * Puedes crear extensiones para resolver 2,3,4 y 5
 */


fun isDescriptionNull(description: String?): String {
    return description ?: "N/A"
}

fun booleanToString(exists: Boolean): String {
//    exists && return "Sí"
//    return "No"
    return when (exists) {
        true -> "Sí"
        false -> "No"
    }

}


fun outOfStock(stock: Int): String {
    return when {
        stock == 0 -> "Sin stock"
        else ->"" + stock
    }

}

/**
 * ADVERTENCIA: No modificar la funcion populateData() o los datos
 */
fun populateData(): MutableMap<Int, Product?> =
    mutableMapOf(
        1 to Product(
            id = 100,
            name = "Lapiz",
            description = null,
            isAvailable = true,
            isEnable = true,
            stock = 20
        ),
        2 to Product(
            id = 101,
            name = "Hoja de oficio",
            description = "Hojas para impresora",
            isAvailable = false,
            isEnable = true,
            stock = 150
        ),
        3 to Product(
            id = 102,
            name = "Hoja de carta",
            description = "Hojas para impresora",
            isAvailable = true,
            isEnable = true,
            stock = 100
        ),
        4 to Product(
            id = 103,
            name = "Corchetera",
            description = null,
            isAvailable = true,
            isEnable = false,
            stock = 150
        ),
        5 to Product(
            id = 104,
            name = "Tijeras",
            description = null,
            isAvailable = true,
            isEnable = true,
            stock = 100
        ),
        6 to Product(
            id = 105,
            name = "Sillas de oficina",
            description = null,
            isAvailable = false,
            isEnable = true,
            stock = 0
        ),
    )
