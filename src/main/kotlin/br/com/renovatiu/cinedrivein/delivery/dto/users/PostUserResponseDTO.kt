package br.com.renovatiu.cinedrivein.delivery.dto.users

data class PostUserResponseDTO(
    val id: Int? = null,
    val name: String,
    val email: String,
    val ancineCode: String
)
