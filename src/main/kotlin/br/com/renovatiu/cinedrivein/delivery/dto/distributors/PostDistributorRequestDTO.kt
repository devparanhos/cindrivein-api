package br.com.renovatiu.cinedrivein.delivery.dto.distributors

import br.com.renovatiu.cinedrivein.core.validation.cnpj.CNPJAvailableAnnotation
import br.com.renovatiu.cinedrivein.core.validation.cnpj.CNPJValidAnnotation
import jakarta.validation.constraints.NotEmpty

data class PostDistributorRequestDTO(
    @field:NotEmpty(message = "O nome fantasia é obrigatório")
    val fantasyName: String,

    @field:NotEmpty(message = "A razão social é obrigatória")
    val companyName: String,

    @field:NotEmpty(message = "O CNPJ é obrigatório")
    @CNPJAvailableAnnotation
    @CNPJValidAnnotation
    val cnpj: String
)
