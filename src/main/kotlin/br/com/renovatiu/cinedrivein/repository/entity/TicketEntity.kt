package br.com.renovatiu.cinedrivein.repository.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "tickets")
data class TicketEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column
    val name: String,

    @Column(name = "full_price")
    val fullPrice: Double,

    @Column(name = "half_price")
    val halfPrice: Double,

    @Column
    val published: Boolean,

    @Column
    val days: Int
)