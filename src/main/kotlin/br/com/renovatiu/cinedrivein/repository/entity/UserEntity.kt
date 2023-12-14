package br.com.renovatiu.cinedrivein.repository.entity

import jakarta.persistence.*

@Entity(name = "users")
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column
    var name: String,

    @Column
    var email: String,

    @Column
    var password: String,

    @Column(name = "ancine_code")
    val ancineCode: String
)
