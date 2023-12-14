package br.com.renovatiu.cinedrivein.repository.datasource

import br.com.renovatiu.cinedrivein.repository.entity.DistributorEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface DistributorRepository: JpaRepository<DistributorEntity, Int> {
    @Query(value = "SELECT COUNT(*) FROM DISTRIBUTORS WHERE CNPJ = ?1", nativeQuery = true)
    fun isCnpjAvailable(cnpj: String) : Long
}