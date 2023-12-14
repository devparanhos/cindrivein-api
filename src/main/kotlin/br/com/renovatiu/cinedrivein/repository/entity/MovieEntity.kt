package br.com.renovatiu.cinedrivein.repository.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity(name = "movies")
data class MovieEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column
    var title: String,

    @Column
    var poster: String,

    @Column
    var backdrop: String? = null,

    @Column
    val cpb: String,

    @ManyToOne
    @JoinColumn(name = "distributor_id")
    val distributor: DistributorEntity
)
