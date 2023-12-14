package br.com.renovatiu.cinedrivein.delivery.dto.distributors

import br.com.renovatiu.cinedrivein.core.validation.cnpj.CNPJValidAnnotation
import br.com.renovatiu.cinedrivein.core.validation.cnpj.CheckSameCNPJAnnotation
import br.com.renovatiu.cinedrivein.core.validation.cnpj.CheckSameCNPJModel
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class PutDistributorRequestDTO(
    @field:NotNull
    val id: Int,

    @field:NotEmpty(message = "O nome fantasia é obrigatório")
    val fantasyName: String,

    @field:NotEmpty(message = "A razão social é obrigatória")
    val companyName: String,

    @field:NotEmpty(message = "O CNPJ é obrigatório")
    @CNPJValidAnnotation
    val cnpj: String,

    @CheckSameCNPJAnnotation
    val checkSameCNPJ: CheckSameCNPJModel = CheckSameCNPJModel(id = id, cnpj = cnpj)
)