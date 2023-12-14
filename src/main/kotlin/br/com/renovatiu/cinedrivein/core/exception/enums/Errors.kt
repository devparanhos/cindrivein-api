package br.com.renovatiu.cinedrivein.core.exception.enums

enum class Errors(val code: String, val message: String) {

    CDIE001("CDIE-001", "Dado inválido"),
    CDIE002("CDIE-002", "Existem erros no formulário enviado"),
    CDIE101("CDIE-101", "Ops, algo deu errado! Tente novamente.")

}