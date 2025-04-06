fun main() {
    val dados = listOf(10, 12, 12, 13, 12, 11, 10, 13, 100) // 100 é o outlier

    val sorted = dados.sorted()
    val q1 = percentile(sorted, 25.0)
    val q3 = percentile(sorted, 75.0)
    val iqr = q3 - q1

    val limiteInferior = q1 - 1.5 * iqr
    val limiteSuperior = q3 + 1.5 * iqr

    val outliers = dados.filter { it < limiteInferior || it > limiteSuperior }

    println("Outliers encontrados:")
    println(outliers)
}

fun percentile(data: List<Int>, percentile: Double): Double {
    val index = (percentile / 100.0) * (data.size - 1)
    val lower = index.toInt()
    val upper = lower + 1
    val weight = index - lower
    return if (upper >= data.size) data[lower].toDouble()
    else data[lower] * (1 - weight) + data[upper] * weight
}
