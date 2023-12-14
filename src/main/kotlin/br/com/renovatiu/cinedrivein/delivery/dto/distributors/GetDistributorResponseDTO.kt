package br.com.renovatiu.cinedrivein.delivery.dto.distributors

data class GetDistributorResponseDTO(
    val id: Int? = -1,
    val fantasyName: String,
    val companyName: String,
    val cnpj: String
)
