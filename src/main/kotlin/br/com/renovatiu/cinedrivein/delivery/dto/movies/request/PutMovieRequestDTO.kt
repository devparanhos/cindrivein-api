package br.com.renovatiu.cinedrivein.delivery.dto.movies.request

import com.fasterxml.jackson.annotation.JsonAlias
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class PutMovieRequestDTO(
    @field:NotEmpty(message = "O título do filme é obrigatório")
    val title: String,

    val poster: String,

    val backdrop: String,

    @field:NotEmpty(message = "O código do filme é obrigatório")
    val cpb: String,

    @field:NotNull
    @JsonAlias("distributor_id")
    val distributorId: Int
)
