package br.com.renovatiu.cinedrivein.service.distributors

import br.com.renovatiu.cinedrivein.delivery.dto.distributors.GetDistributorResponseDTO
import br.com.renovatiu.cinedrivein.delivery.dto.distributors.toGetDistributorResponseDto
import br.com.renovatiu.cinedrivein.repository.datasource.DistributorRepository
import br.com.renovatiu.cinedrivein.repository.entity.DistributorEntity
import org.springframework.stereotype.Service

@Service
class DistributorService(
    private val repository: DistributorRepository
) {

    fun create(distributor: DistributorEntity){
        repository.save(distributor)
    }

    fun isCnpjAvailable(cnpj: String) : Boolean{
        return repository.isCnpjAvailable(cnpj = cnpj) == 0L
    }

    fun getById(id: Int) : DistributorEntity {
        return repository.findById(id).orElseThrow()
    }

    fun getAll() : List<GetDistributorResponseDTO>{
        return repository.findAll().map { it.toGetDistributorResponseDto() }
    }

    fun delete(id: Int) {
        repository.deleteById(id)
    }

    fun update(id: Int, distributor: DistributorEntity){
        val result = getById(id = id)

        repository.save(
            result.copy(
                id = id,
                fantasyName = distributor.fantasyName,
                companyName = distributor.companyName,
                cnpj = distributor.cnpj
            )
        )
    }
}