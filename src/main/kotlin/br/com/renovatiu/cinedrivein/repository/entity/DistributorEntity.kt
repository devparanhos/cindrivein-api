package br.com.renovatiu.cinedrivein.repository.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "distributors")
data class DistributorEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(name = "fantasy_name")
    val fantasyName: String,

    @Column(name = "company_name")
    val companyName: String,

    @Column
    val cnpj: Long
)
