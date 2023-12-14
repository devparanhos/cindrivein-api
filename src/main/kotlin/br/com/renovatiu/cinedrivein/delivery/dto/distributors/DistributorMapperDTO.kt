package br.com.renovatiu.cinedrivein.delivery.dto.distributors

import br.com.renovatiu.cinedrivein.repository.entity.DistributorEntity
import br.com.renovatiu.cinedrivein.utils.extensions.numericCNPJ
import br.com.renovatiu.cinedrivein.utils.extensions.setCNPJMask

fun PostDistributorRequestDTO.toEntity() : DistributorEntity {
    return DistributorEntity(
        fantasyName = this.fantasyName,
        companyName = this.companyName,
        cnpj = this.cnpj.numericCNPJ()
    )
}

fun PutDistributorRequestDTO.toEntity() : DistributorEntity {
    return DistributorEntity(
        id = this.id,
        fantasyName = this.fantasyName,
        companyName = this.companyName,
        cnpj = this.cnpj.numericCNPJ()
    )
}

fun DistributorEntity.toGetDistributorResponseDto() : GetDistributorResponseDTO {
    return GetDistributorResponseDTO(
        id = this.id,
        fantasyName = this.fantasyName,
        companyName = this.companyName,
        cnpj = this.cnpj.setCNPJMask()
    )
}