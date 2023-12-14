package br.com.renovatiu.cinedrivein.utils.extensions

fun String.isCNPJValid(): Boolean {
    val cnpj = this.replace("[^\\d]".toRegex(), "")
    return cnpj.length == 14
}

fun String.numericCNPJ(): Long {
    return this.replace("[^\\d]".toRegex(), "").toLong()
}

fun Long.setCNPJMask(): String {
    val cnpj = this.toString()
    return  "${cnpj.substring(0, 2)}.${cnpj.substring(2, 5)}.${cnpj.substring(5, 8)}/${cnpj.substring(8, 12)}" +
            "-${cnpj.substring(12)}"
}